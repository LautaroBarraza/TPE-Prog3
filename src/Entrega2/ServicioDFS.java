package Entrega2;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioDFS {

	private Grafo<?> grafo;
	HashMap<Integer, String> registro= new HashMap<Integer,String>();
	LinkedList<Integer> resultado = new LinkedList<>();
	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> dfsForest() {
		this.recorrer();
		Iterator<Integer> key = grafo.obtenerVertices();
		while(key.hasNext()) {
			Integer temp = key.next();
			if(registro.get(temp).equals("blanco")){
				dfs_visit(temp);
			}
		}
		return resultado;
	}
	private void recorrer() {
		Iterator<Integer> aux = grafo.obtenerVertices();
		while(aux.hasNext()) {
			Integer temp = aux.next();
			registro.put(temp,"blanco");		
		}
	}
	private void dfs_visit(Integer key) {
		registro.put(key,"amarillo");
		resultado.add(key);
		Iterator<Integer>aux = grafo.obtenerAdyacentes(key);
		while(aux.hasNext()) {
			Integer temp =aux.next();
			if(registro.get(temp).equals("blanco")) {
				dfs_visit(temp);
			}
		}
		registro.put(key,"negro");
	}
	
}
