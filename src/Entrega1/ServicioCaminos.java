package Entrega1;



import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioCaminos<T> {

	private Grafo<T> grafo;
	private int origen;
	private int destino;
	private int lim;
	private LinkedList<List<Integer>> caminos = new LinkedList<List<Integer>>();
	private HashMap<Arco<T>,Boolean> arcos= new HashMap<Arco<T>,Boolean>();
	
	// Servicio caminos
	public ServicioCaminos(Grafo<T> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}

	public List<List<Integer>> caminos() {
		int cant = 0;
		this.guardarArcos();
		
		//recorremos los adyacentes del vertice origen obteniendo los caminos a destino
		Iterator<Integer> key = grafo.obtenerAdyacentes(origen);
		while(key.hasNext()) {
			Integer adyacentes = key.next();
			
			//marcamos al arco como visitado y buscamos los caminos
			Arco<T> arcoAVisitar = grafo.obtenerArco(origen, adyacentes);
			arcos.put(arcoAVisitar,true);
			LinkedList<LinkedList<Integer>> caminosEncontrados= encontrarCaminos(adyacentes,cant+1);
			
			//marcamos todos los arcos como no vistados
			this.setNoVisitados();
			//por cada camino agrego al vertice origen
			for(LinkedList<Integer> camino:caminosEncontrados) {
				camino.addFirst(origen);
			}
			if(!caminosEncontrados.isEmpty()) {
				caminos.addAll(caminosEncontrados);
			}

		}
		return this.caminos;
	}
	
	
	private LinkedList<LinkedList<Integer>> encontrarCaminos(Integer vertice, int cant){
		LinkedList<LinkedList<Integer>>resultado= new LinkedList<LinkedList<Integer>>();
		if(cant<this.lim) {
			
			//caso en el que llego a destino, empiezo a devolver el camino
			if(vertice.equals(this.destino)){
				LinkedList<Integer>aux=new LinkedList<Integer>();
				aux.add(vertice);
				resultado.add(aux);
				
				return resultado;
			}
			else {
				//caso en el que no es el destino, recorro todos sus adyacentes en busca del arco destino, sin repetir arcos
					Iterator<Integer>adyacentes = grafo.obtenerAdyacentes(vertice);
					while(adyacentes.hasNext()) {
						Integer temp =adyacentes.next();
						Arco<T> arco = grafo.obtenerArco(vertice, temp);
						if(!this.arcos.get(arco)) {
							arcos.put(arco, true);
							//si el adyacente no devolvio un camino significa que no encontro nada o llego al limite
							//si el adyasente devuelve caminos los agrego al resultado
							LinkedList<LinkedList<Integer>> caminosAdyacentes=encontrarCaminos(temp,cant+1);
							if(!caminosAdyacentes.isEmpty()) {
								resultado.addAll(caminosAdyacentes);
								
							}
							
						}
					}
					//por cada camino encontrado me agrego como vertice al mismo
					for(LinkedList<Integer> camino:resultado) {
						camino.addFirst(vertice);
					}
				}
			}
		//retorno una lista vacia si pase el limite o no tenog mas adyacentes o retorno una lista con caminos.
		this.setNoVisitados();
		return resultado;
		
	}
	
	//metodo que guarda arcos
	private void guardarArcos() {
		Iterator<Arco<T>> aux = this.grafo.obtenerArcos();
		while(aux.hasNext()) {
			Arco<T> temp = aux.next();
			arcos.put(temp, false);
		}
	}
	
	//metodo que marca a todos los arcos como no visitados
	private void setNoVisitados() {
		for(Arco<T> a: this.arcos.keySet()) {
			this.arcos.put(a, false);
		}
	}

}
