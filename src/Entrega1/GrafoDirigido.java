package Entrega1;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, LinkedList<Arco<T>>> adjacencyList= new HashMap<Integer, LinkedList<Arco<T>>>();
	private int cantArcos=0;
	
	
	@Override
	/*
	 * Complejidad: O(1) debido a que solo debe agregar un key,value al hashmap
	 * 
	 */
	public void agregarVertice(int verticeId) {
		// TODO Auto-generated method stub
		LinkedList<Arco<T>> l= new LinkedList<Arco<T>>();
		this.adjacencyList.put(verticeId, l);

	}

	@Override
	/*
	 * Complejidad: O(N)donde n son los arcos, debido a que para borrar un vertice el acceder al mismo es O(1) por el hashmap
	 * pero lo que hace que el algoritmo dure mas o menos es el recorrer los arcos, donde en el peor de los casos 
	 * se van a tener que recorrer todos.
	 * 
	 */
	public void borrarVertice(int verticeId) {
		// TODO Auto-generated method stub
		this.adjacencyList.remove(verticeId);
		for(Integer key: this.adjacencyList.keySet()) {
			this.borrarArco(key, verticeId);
			this.cantArcos--;
		}

	}

	@Override
	/*
	 * Complejidad: O(1) debido a que para agregar un arco se debe obtener el vertice O(1) por el hashmap y agregar
	 * el arco a una lista vinculada O(1)
	 * 
	 */
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// TODO Auto-generated method stub
		Arco<T> aux = new Arco<T>(verticeId1,verticeId2,etiqueta);
		this.adjacencyList.get(verticeId1).add(aux);
		this.cantArcos++;

	}

	
	@Override
	/*
	 * Complejidad: O(N) donde n es la cantidad de arcos de la lista de un vertice, debido a que para borrar un arco
	 * se utiliza el metodo removeIf de la lista vinculada, 
	 * que en el peor de los casos va a tener que recorrer toda la lista para encontrar el arco a borrar
	 * 
	 */
	public void borrarArco(int verticeId1, int verticeId2) {
		//borrar arcos del origen que apunten el destino
		LinkedList<Arco<T>> aux = this.adjacencyList.get(verticeId1);
		aux.removeIf(a -> a.getVerticeDestino()==verticeId2);
		this.cantArcos--;
	}

	@Override
	/*
	 * Complejidad: O(1) debido a que para saber si contiene un vertice se utiliza el metodo containsKey del hashmap
	 * que tiene complejidad O(1) 
	 * 
	 */
	public boolean contieneVertice(int verticeId) {
		// TODO Auto-generated method stub
		return this.adjacencyList.containsKey(verticeId);
	}

	@Override
	/*
	 * Complejidad: O(n) donde n es la cantidad de arcos de un vertice, debido a que para encontrar un arco se
	 * tiene que recorrer la lista vinculada hasta encontrarlo, y en el peor de los casos se recorre todos los arcos de la lista
	 * 
	 */
	public boolean existeArco(int verticeId1, int verticeId2) {
		LinkedList<Arco<T>> aux = this.adjacencyList.get(verticeId1);
		Iterator<Arco<T>> i= aux.iterator();
		boolean encontrado=false;
			while(i.hasNext()&&!encontrado) {
				Arco<T> arco= i.next();
				if((arco.getVerticeOrigen()==verticeId1) && arco.getVerticeDestino()==verticeId2) {
					encontrado=true;
				}
			}
		return encontrado;
	}

	@Override
	/*
	 * Complejidad: O(n) donde n es la cantidad de arcos de un vertice, debido a que para encontrar un arco y retornarlo se
	 * recorre la lista vinculada hasta encontrarlo, y en el peor de los casos se recorre todos los arcos de la lista
	 * 
	 */
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		LinkedList<Arco<T>> aux = this.adjacencyList.get(verticeId1);
		Iterator<Arco<T>> i= aux.iterator();
		Arco<T> resultado=null;
		boolean encontrado=false;
			while(i.hasNext()&&!encontrado) {
				Arco<T> arco= i.next();
				if((arco.getVerticeOrigen()==verticeId1) && arco.getVerticeDestino()==verticeId2) {
					encontrado=true;
					resultado=arco;
				}
			}
		return resultado;
	}

	@Override
	/*
	 * Complejidad: O(1) debido a que solo se tiene que acceder a la variable donde se va guardando y actualizando la cantidad de vertices
	 * 
	 */
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return this.adjacencyList.size();
	}

	@Override
	/*
	 * Complejidad: O(1) debido a que solo se tiene que acceder a la variable donde se va guardando y actualizando la cantidad de Arcos
	 * 
	 */
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		return this.cantArcos;
	}

	@Override
	/*
	 * Complejidad: O(1) debido a que solo se tiene que llamar al metodo .iterator del hashmap
	 * 
	 */
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return this.adjacencyList.keySet().iterator();
	}

	@Override
	/*
	 * Complejidad: O(n) donde n es la cantidad de arcos debido a que para obtener los adyacentes
	 * se tiene que recorrer cada arco de la lista vinculada de los vertices
	 * 
	 */
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		LinkedList<Integer>aux = new LinkedList<>();
		LinkedList<Arco<T>>list = this.adjacencyList.get(verticeId);
		for(Arco<T> a: list) {
			aux.addLast(a.getVerticeDestino());
		}
		return aux.iterator();
	}

	@Override
	/*
	 * Complejidad: O(N) donde n es la cantidad de arcos, debido a que se debe insertar todos los arcos a una lista vinculada,
	 * y para esto se utiliza el metodo addAll que tiene una complejidad o(n) dado que accede a los n arcos para insertarlos
	 * 
	 */
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>>aux= new LinkedList<>();
		for(Integer key: this.adjacencyList.keySet()) {
			aux.addAll(this.adjacencyList.get(key));
		}
		return aux.iterator();
	}

	@Override
	/*
	 * Complejidad O(1) debido a que solo debe acceder a un vertice en el hashmap y retornar el iterator de la lista de arcos para
	 * obtener los mismos de un vertice
	 */
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		LinkedList<Arco<T>> aux = this.adjacencyList.get(verticeId);
		return aux.iterator();
	}

}
