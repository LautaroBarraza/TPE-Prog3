package Entrega2;

import java.util.LinkedList;

public class Main {

	public static <T> void main(String[] args) {
		
		GrafoNoDirigido g = new GrafoNoDirigido();
		String path = "C:/Users/lautaro/OneDrive/Escritorio/tudai/prog3/repo/programacion3/datasets/dataset1.txt";
		CSVReader reader = new CSVReader(path);
		reader.read(g);
		ServicioTunelesBackTraking s= new ServicioTunelesBackTraking(g);
		LinkedList<Arco<T>>so = s.tunelesBackTraking();
		System.out.println(so);
		for (Arco<T> a:so) {
			System.out.println(a);
		}
		
		//for(LinkedList<Arco<T>> s1: so) {
			//System.out.println(s1);
		//}
		System.out.println(s.sumaMejor);
		
	}
}
