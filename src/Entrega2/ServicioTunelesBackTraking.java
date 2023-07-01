package Entrega2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ServicioTunelesBackTraking<T> {
	LinkedList<Arco<T>> conexiones;
	LinkedList<Arco<T>> tuneles;
	LinkedList<Integer> estacionConectadas = new LinkedList<Integer>();
	HashMap<Integer, Boolean> estaciones= new HashMap<Integer,Boolean>();
	Grafo<T> g;
	Grafo<T> solucionParcial;
	int sumaMejor=Integer.MAX_VALUE;
	int iteraciones;
	
	//constructor
	public ServicioTunelesBackTraking(Grafo<T> g) {
		this.g=g;
		this.solucionParcial= new GrafoNoDirigido<T>();
		this.conexiones= new LinkedList<Arco<T>>();
		this.tuneles= new LinkedList<Arco<T>>();
		this.cargarEstaciones();
		this.cargarGrafo(solucionParcial);
		this.cargarConexiones();
	}
	
	//metodo publico backTraking
	
	public LinkedList<Arco<T>> tunelesBackTraking(){
		this.iteraciones=1;
		this.getTunelesBackTraking(this.solucionParcial);
		return this.tuneles;
	}
	
	//metodos privados

	
	//backtraking
	private void getTunelesBackTraking(Grafo<T> solucionParcial) {
		
		if(this.conexiones.isEmpty()) {
			if(this.isBest(solucionParcial)) {
				this.cargarMejorSolucion(solucionParcial);
				
			}
		}else {
			//sigo recorriendo el backtraking
			//opcion de no construir el arco
			this.iteraciones++;
			Arco<T> a= this.conexiones.removeFirst();
			this.getTunelesBackTraking(solucionParcial);
			this.conexiones.addFirst(a);
			
			
			//opcion de construir
			a= this.conexiones.removeFirst();
			int o= a.getVerticeOrigen();
			int d= a.getVerticeDestino();
			solucionParcial.agregarArco(o, d, a.getEtiqueta());
			this.getTunelesBackTraking(solucionParcial);
			solucionParcial.borrarArco(o, d);
			this.conexiones.addFirst(a);
			
			
		}
		
	}
	
	
	//funcion que retorna si la solucion actual es mejor a la ya establecida
	private boolean isBest(Grafo<T> aux) {
		if(this.isConnected(aux)) {
			int suma=0;
			Iterator<Arco<T>> i= aux.obtenerArcos();
			while(i.hasNext()) {
				suma+= (int) i.next().getEtiqueta();
			}
			if(suma<this.sumaMejor) {
				return true;
			}
		}
		return false;
	}
	
	//funcion que retorna si un grafo es conexo
	private boolean isConnected(Grafo<T> aux) {
		Iterator<Integer> i = aux.obtenerVertices();
		if(i.hasNext()) {
			this.estacionConectadas.clear();
			this.cargarEstaciones();
			int e=i.next();
			this.isconnected(e,aux);
		}
		return this.estacionConectadas.size()==this.g.cantidadVertices();
	}
	
	//procedimeinto que recorre el grafo en profundidad guardando las estaciones visitadas
	private void isconnected(int estacion,Grafo<T> aux) {
			this.estaciones.replace(estacion, true);
			this.estacionConectadas.add(estacion);
			Iterator<Integer> i = aux.obtenerAdyacentes(estacion);
			while(i.hasNext()) {
				int a= i.next();
				if(!this.estaciones.get(a)) {
					this.isconnected(a,aux);
				}
			}
	}
	
	//Procedimiento que carga todas las estaciones en un hashMap seteandolas como no visitadas
	private void cargarEstaciones() {
		Iterator<Integer> i = this.g.obtenerVertices();
		while (i.hasNext()) {
			int e= i.next();
			this.estaciones.put(e, false);
		}
	}
	
	//procedimiento que copia los vertices pasados como dato a la solucion actual
	private void cargarGrafo(Grafo<T> h) {
		Iterator<Integer> i = this.g.obtenerVertices();
		while (i.hasNext()) {
			int e= i.next();
			h.agregarVertice(e);
		}
	}

	
	//procedimeinto que carga las conexiones entre las estaciones en una linkedList
	private void cargarConexiones() {
		Iterator<Arco<T>> i = this.g.obtenerArcos();
		while(i.hasNext()) {
			Arco<T> t= i.next();
			this.conexiones.add(t);
		}
	}
	
	//procedimeinto que carga la mejor solucion sin arcos repetidos
	private void cargarMejorSolucion(Grafo<T> solucionParcial) {
		this.tuneles.clear();
		this.sumaMejor=0;
		Iterator<Arco<T>> i =solucionParcial.obtenerArcos();
		while(i.hasNext()){
			Arco<T> a= i.next();
			this.sumaMejor+=(int) a.getEtiqueta();
				this.tuneles.add(a);
		}
	}
	
	public int getIteraciones() {
		return this.iteraciones;
	}
	
	public void printInforme() {
		System.out.println("BackTracking");
		System.out.println(this.tuneles);
		System.out.println(this.sumaMejor+" Kms");
		System.out.println(this.getIteraciones()+" iteraciones realizadas");
		
	}
}
