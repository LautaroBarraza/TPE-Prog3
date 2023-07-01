package Entrega2;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static <T> void main(String[] args) {
		
		GrafoNoDirigido g = new GrafoNoDirigido();
		String path = "dataset/dataset2.txt";
		CSVReader reader = new CSVReader(path);
		reader.read(g);
		ServicioTunelesBackTraking s= new ServicioTunelesBackTraking(g);
		s.tunelesBackTraking();
		s.printInforme();
		/*Iterator<Arco<T>> i = g.obtenerArcos();
		while (i.hasNext()) {
			System.out.println(i.next());
		}*/
		
		//for(LinkedList<Arco<T>> s1: so) {
			//System.out.println(s1);
		//}
		
		
		ServicioTunelesGreddy sG = new ServicioTunelesGreddy(g);
		sG.TunelesGreddy();
		sG.printInforme();
		
		
	}
}
