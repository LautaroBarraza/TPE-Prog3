package Entrega2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ServicioTunelesGreddy<T> {
	private HashMap<Integer, Integer> unionFind= new HashMap<Integer, Integer>();
	private LinkedList<Arco<T>> arcos= new LinkedList<Arco<T>>();
	private LinkedList<Arco<T>> solucionArcos= new LinkedList<Arco<T>>();
	private Integer total =0;
	private Integer iteraciones = 0;
	Grafo<T>grafo;
	
	
	
	//mis candidatos van a ser los arcos
	public ServicioTunelesGreddy(Grafo<T>g) {
		this.grafo=g;
	}
	
	//metodo publico que retorna la solucion que hayo greedy
	public LinkedList<Arco<T>> tunelesGreedy() {
		this.guardarArcos(); //guarda los arcos del grafo y los ardena segun el criterio greedy
		this.guardarVertices(); //guarda los vertices para el unionfind
		return this.greedy();

	}
	
	//algoritmo greedy
	private LinkedList<Arco<T>> greedy() {
		this.iteraciones = 0;
		while(!this.arcos.isEmpty() && !esSolucion()) { 
			this.iteraciones+= 1;	
			//obtengo primera conexion
			Arco<T> u = this.arcos.removeFirst();								
			if(u!=null) {		
				//busco las raices en el unionfind
				int v1 = u.getVerticeOrigen();					
				int v2 = u.getVerticeDestino();	
				int r1 = this.find(v1);
				int r2 = this.find(v2);
				//si las estaciones no estan en el mismo subconjunto la agrego a al solucion
				if(r1!=r2) {										
					this.unionFind.put(r1, r2);									
			        this.solucionArcos.add(u);	
			        this.total+=(int) u.getEtiqueta();
				}
			}
		}
		return this.solucionArcos;
	}
	
	
	//funcion que verifica que todos las estaciones esten en el mismo sub conjunto
	private Boolean esSolucion() {
        boolean resultado = true;
        Iterator<Integer> i = this.grafo.obtenerVertices();
        Integer temp = i.next();
        int nroConjunto = this.find(temp);
        while(i.hasNext()) {
            temp = i.next();
            int x = this.find(temp);
            if(x!=nroConjunto) {
                return false;
            }
        }
        return resultado;
    }
	
	// funcion que retorna la raiz de un valor en el unionFind
	private Integer find(Integer k) {
		//si "k" es root
		if(this.unionFind.get(k)==k) {
			return k;
		}
		//recurre para el padre hasta que encontramos raiz
		return find(this.unionFind.get(k));
	}
	
	//procedimiento que guarda los vertices del grafo en el hashMap
	private void guardarVertices() {
		Iterator<Integer> i = this.grafo.obtenerVertices();
		while(i.hasNext()) {
			Integer temp = i.next();
			this.unionFind.put(temp, temp);
		}
	}
	
	//procedimiento que guarda los arcos/conexiones del grafo en una linkedList
	private void guardarArcos() {
		Iterator<Arco<T>> aux = this.grafo.obtenerArcos();
		while(aux.hasNext()) {
			Arco<T> temp = aux.next();
			arcos.add(temp);
		}
		Collections.sort(this.arcos);
	}
	
	
	//procedimiento que imprime el informe de lo obtenido por greedy
	public void printInforme() {
		System.out.println("Greedy");
		System.out.println(this.solucionArcos);
		System.out.println(this.total+" Kms");
		System.out.println(this.iteraciones+" iteraciones realizadas");
	}
}