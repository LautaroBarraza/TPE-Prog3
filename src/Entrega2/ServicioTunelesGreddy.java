package Entrega2;

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
	public void TunelesGreddy() {
		this.guardarArcos();
		this.guardarVertices();
		
		
		System.out.println("Greddy");
		System.out.print(this.greddy()); 
		System.out.println("total -->"+this.calcularTotal()+"KM");
		System.out.println(this.iteraciones);

	}
	
	private LinkedList<Arco<T>> greddy() {
		this.iteraciones = 0;
		while(!this.arcos.isEmpty() && esSolucion()) {
			this.iteraciones+= 1;
			Arco<T> u = SeleccionarArco();
			if(u!=null) {
				this.arcos.remove(u);
				if(esFactible(u)) {
					Integer v1 = u.getVerticeOrigen();
					Integer v2 = u.getVerticeDestino();
					this.union(v1, v2);
			        Arco<T> arco = this.grafo.obtenerArco(v1, v2);
			        this.solucionArcos.add(arco);
				}
			}
		}
		return this.solucionArcos;
	}
	
	private Boolean esSolucion() {
		boolean resultado = true;
		Iterator<Integer> i = this.grafo.obtenerVertices();
		while(i.hasNext()) {
			Integer temp = i.next();
			if(!this.unionFind.containsKey(temp)) {
				resultado = false;
			}
		}
		return resultado;
	}
	private Integer find(Integer k) {
		//si "k" es root
		if(this.unionFind.get(k)==k) {
			return k;
		}
		//recurre para el padre hasta que encontramos raiz
		return find(this.unionFind.get(k));
	}
	public void union(Integer a,Integer b) {
		// encontrar la raíz de los conjuntos a los que pertenecen los elementos `x` e `y`
        int x = find(a);
        int y = find(b);
        
        this.unionFind.put(x, y);

        
	}
	private Arco<T> SeleccionarArco() {
		Integer menor=Integer.MAX_VALUE;
		Arco<T> key=null;
		for(Arco<T> i:this.arcos) {
			if((int)i.getEtiqueta()<menor) {
				menor = (int) i.getEtiqueta();
				key = i;
			}
		}
		return key;
	}
	private boolean esFactible(Arco<T> a) {
		//chequear que no esten conectadas
			Integer v1 = a.getVerticeOrigen();
			Integer v2 = a.getVerticeDestino();
			Integer r1 = this.find(v1);
			Integer r2 = this.find(v2);
			if(r1==r2) {
				return false;
			}
			else {
				return true;
			}
	}
	private Integer calcularTotal() {
		this.total = 0;
		for(Arco<T> i : this.solucionArcos) {
				if(i!=null) {
					Integer distancia = (int) i.getEtiqueta();
					total += distancia;
				}
			}
		return this.total;
	}
	private void guardarVertices() {
		Iterator<Integer> i = this.grafo.obtenerVertices();
		while(i.hasNext()) {
			Integer temp = i.next();
			this.unionFind.put(temp, temp);
		}
	}
	private void guardarArcos() {
		Iterator<Arco<T>> aux = this.grafo.obtenerArcos();
		while(aux.hasNext()) {
			Arco<T> temp = aux.next();
			arcos.add(temp);
		}
	}
}