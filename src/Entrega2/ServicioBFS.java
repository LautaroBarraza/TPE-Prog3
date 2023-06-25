package Entrega2;



import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ServicioBFS {

	private Grafo<?> grafo;
	HashMap<Integer, Boolean> registro= new HashMap<Integer,Boolean>();
	Queue<Integer> q = new LinkedList<Integer>();
	LinkedList<Integer> resultado= new LinkedList<Integer>();
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> bfsForest() {
		// Resolver BFS
		q.clear();
		this.recorrer();
		LinkedList<Integer> aux = new LinkedList<Integer>();
		Iterator<Integer> key = grafo.obtenerVertices();
		while(key.hasNext()) {
			Integer temp = key.next();
			if(!registro.get(temp)){
				aux.addAll(this.bfs_visit(temp));
			}
		}
		return aux;
	}
	
	private LinkedList<Integer> bfs_visit(Integer i) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		registro.replace(i, true);
		res.add(i);
		q.add(i);
		while(!q.isEmpty()) {
			Integer aux= q.poll();
			Iterator<Integer> it= this.grafo.obtenerAdyacentes(aux);
			while(it.hasNext()) {
				Integer v= it.next();
				if(!registro.get(v)) {
					this.registro.replace(v, true);
					res.add(v);
					q.add(v);
				}
			}
		}
		return res;
	}
	
	private void recorrer() {
		Iterator<Integer> aux = grafo.obtenerVertices();
		while(aux.hasNext()) {
			Integer temp = aux.next();
			registro.put(temp,false);		
		}
	}
	
	
	
}
