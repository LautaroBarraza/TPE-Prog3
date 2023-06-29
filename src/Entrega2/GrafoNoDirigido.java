package Entrega2;

import java.util.Iterator;
import java.util.LinkedList;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		super.agregarArco(verticeId2, verticeId1, etiqueta);
	}
	
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}
	
	@Override
	public int cantidadArcos() {
		return super.cantidadArcos()/2;
	}
	
	public boolean existeArco(int verticeId1, int verticeId2) {
		return super.existeArco(verticeId1, verticeId2) && super.existeArco(verticeId2, verticeId1);
	}
	
	/*public Iterator<Arco<T>> obtenerArcos(){
		LinkedList<Arco<T>>aux= new LinkedList<>();
		for(Integer key: this.adjacencyList.keySet()) {
			//obtengo la lista de arcos del vertice
			//recorro la lista y comparo si no existe el arco lo guardo
			LinkedList<Arco<T>> arcos= this.adjacencyList.get(key);
			for (Arco<T> a:arcos) {
				if(!aux.contains(a)) {
					aux.add(a);
				}
			}
		}
		return aux.iterator();
	}*/
}
