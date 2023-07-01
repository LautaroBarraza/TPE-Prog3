package Entrega2;

import java.util.Objects;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco<T> {



	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}

	public String toString() {
        return verticeOrigen + "-" + verticeDestino;
    }
	
	public boolean equals(Object obj) {
		try {
			Arco<T> a2 = (Arco) obj;
			return ((a2.getVerticeOrigen()==this.getVerticeDestino() && a2.getVerticeDestino()==this.getVerticeOrigen())&& a2.getEtiqueta().equals(this.getEtiqueta())) || ((a2.getVerticeOrigen()==this.getVerticeOrigen() && a2.getVerticeDestino()==this.getVerticeDestino()) && a2.getEtiqueta().equals(this.getEtiqueta()));
		}catch(Exception e) {
			return false;
		}
		
	}
	
	

}
