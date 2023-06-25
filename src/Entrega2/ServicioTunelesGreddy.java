package Entrega2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

	public class ServicioTunelesGreddy<T> {
		private HashMap<Integer, Integer> distancia= new HashMap<Integer, Integer>();//Integer(VERTICE) Integer(DISTANCIA)
		private LinkedList<Integer>vertices = new LinkedList<Integer>();
		private HashMap<Integer, Integer> padre= new HashMap<Integer, Integer>();//a Integer se llega desde Integer
		public LinkedList<Integer> solucion = new LinkedList<Integer>();
		public Integer total =0;
		Grafo<T>grafo;
		
		
		
		//mis candidatos van a ser los arcos
		public ServicioTunelesGreddy(Grafo<T>g) {
			this.grafo=g;
		}
		public void TunelesGreddy(Integer o) {
			System.out.println("Greddy");
			System.out.println(this.greddy(o));
			System.out.println(this.calcularTotal());
		}
		private HashMap<Integer,Integer> greddy(Integer origen) {
			
			Iterator<Integer> i = this.grafo.obtenerVertices();
			while(i.hasNext()) {
				Integer vertice = i.next();
				this.distancia.put(vertice, Integer.MAX_VALUE);
				vertices.add(vertice);
				padre.put(vertice, origen);
			}
			
			this.distancia.put(origen,0);
			while(!this.vertices.isEmpty()) {
				Integer u = SeleccionarVertice();
				if(u!=null) {
					this.vertices.remove(u);
					this.solucion.add(u);
					Iterator<Integer> j = this.grafo.obtenerAdyacentes(u);
					if(j!=null) {	
						while(j.hasNext()) {
							Integer adyacente = j.next();
							Arco<T> arco=this.grafo.obtenerArco(u, adyacente);
							int dist=(int) arco.getEtiqueta();
							if(this.vertices.contains(adyacente)) {	
								if(this.distancia.get(u)+dist< this.distancia.get(adyacente)) {
									this.distancia.put(adyacente,this.distancia.get(u)+dist);
									this.padre.put(adyacente, u);
								}
							}
						}
					}
					
				}
			}
			return this.padre;
	}
		private Integer SeleccionarVertice() {
			Integer menor=Integer.MAX_VALUE;
			Integer key=0;
			for(Integer i:this.vertices) {
				if(this.distancia.get(i)<menor) {
					menor = this.distancia.get(i);
					key = i;
				}
			}
			return key;
		}
		private Integer calcularTotal() {
			this.total = 0;
			for(Integer i : this.solucion) {
				Integer aux = this.padre.get(i);
				Arco<T> arco = this.grafo.obtenerArco(aux,i);
					if(arco!=null) {
						int distancia = (int) arco.getEtiqueta();
						total += distancia;
					}
				}
			return this.total;
		}
	}
