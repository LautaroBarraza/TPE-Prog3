package Entrega1;


public class Main {

	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo<Integer> g= new GrafoDirigido<Integer>();
		
		g.agregarVertice(0);
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		g.agregarVertice(6);
		g.agregarVertice(7);
		g.agregarVertice(8);
		
		g.agregarArco(1, 3, 0);
		//g.agregarArco(1, 2, 0);
		g.agregarArco(2, 3, 0);
		g.agregarArco(4, 1, 0);
		g.agregarArco(4, 5, 0);
		g.agregarArco(4, 2, 0);
		g.agregarArco(3, 4, 0);
		g.agregarArco(5, 7, 0);
		g.agregarArco(7, 2, 0);
		g.agregarArco(5, 8, 0);
		g.agregarArco(1, 2, 0);
		g.agregarArco(4, 8, 0);
		g.agregarArco(8, 5, 0);
		g.agregarArco(8, 2, 0);
		g.agregarArco(2, 5, 0);
		/*g.agregarArco(1, 3, 0);
        g.agregarArco(1, 2, 0);
        g.agregarArco(2, 3, 0);
        g.agregarArco(4, 1, 0);
        g.agregarArco(4, 5, 0);
        g.agregarArco(4, 2, 0);
        g.agregarArco(3, 4, 0);
        g.agregarArco(3, 7, 0);
        g.agregarArco(7, 4, 0);
        g.agregarArco(5, 8, 0);
        g.agregarArco(2, 7, 0);
        g.agregarArco(7, 1, 0);*/
		
		System.out.println(g.obtenerArco(1, 3));
		System.out.println(g.obtenerArcos(1).hasNext());
		
		ServicioCaminos s = new ServicioCaminos(g,1,5,6);
		//ServicioDFS s1 = new ServicioDFS(g);
		//ServicioBFS s2 = new ServicioBFS(g);
		//System.out.println(s1.dfsForest());
		//System.out.println(s2.bfsForest());
		System.out.println(s.caminos());
		
	}

}
