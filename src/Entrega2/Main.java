package Entrega2;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static <T> void main(String[] args) {
		
		GrafoNoDirigido g;
		String path1 = "dataset/dataset1.txt";
		String path2 = "dataset/dataset2.txt";
		String path3 = "dataset/dataset3.txt";
		String path4 = "dataset/dataset4.txt";
		String path5 = "dataset/dataset5.txt";
		String path6 = "dataset/dataset6.txt";
		String path7 = "dataset/dataset7.txt";
		

		System.out.println("/////////////////////////////////////////////////////////\n");
		System.out.println("Dataset1");
		CSVReader reader = new CSVReader(path1);
		g=reader.read();
		ServicioTunelesBackTraking s= new ServicioTunelesBackTraking(g);
		s.tunelesBackTraking();
		s.printInforme();
		System.out.println("\n");
		ServicioTunelesGreddy sG = new ServicioTunelesGreddy(g);
		sG.tunelesGreedy();
		sG.printInforme();
		
		
		System.out.println("/////////////////////////////////////////////////////////\n");
		System.out.println("Dataset2");
		CSVReader reader2 = new CSVReader(path2);
		g=reader2.read();
		ServicioTunelesBackTraking s2= new ServicioTunelesBackTraking(g);
		s2.tunelesBackTraking();
		s2.printInforme();
		System.out.println("\n");
		ServicioTunelesGreddy sG2 = new ServicioTunelesGreddy(g);
		sG2.tunelesGreedy();
		sG2.printInforme();
		
		System.out.println("/////////////////////////////////////////////////////////\n");
		System.out.println("Dataset3");
		CSVReader reader3 = new CSVReader(path3);
		g=reader3.read();
		ServicioTunelesBackTraking s3= new ServicioTunelesBackTraking(g);
		s3.tunelesBackTraking();
		s3.printInforme();
		System.out.println("\n");
		ServicioTunelesGreddy sG3 = new ServicioTunelesGreddy(g);
		sG3.tunelesGreedy();
		sG3.printInforme();
		
		System.out.println("/////////////////////////////////////////////////////////\n");
		System.out.println("Dataset4");
		CSVReader reader4 = new CSVReader(path4);
		g=reader4.read();
		ServicioTunelesBackTraking s4= new ServicioTunelesBackTraking(g);
		s4.tunelesBackTraking();
		s4.printInforme();
		System.out.println("\n");
		ServicioTunelesGreddy sG4 = new ServicioTunelesGreddy(g);
		sG4.tunelesGreedy();
		sG4.printInforme();
		
		
		System.out.println("/////////////////////////////////////////////////////////\n");
		System.out.println("Dataset5");
		CSVReader reader5 = new CSVReader(path5);
		g=reader5.read();
		ServicioTunelesBackTraking s5= new ServicioTunelesBackTraking(g);
		s5.tunelesBackTraking();
		s5.printInforme();
		System.out.println("\n");
		ServicioTunelesGreddy sG5 = new ServicioTunelesGreddy(g);
		sG5.tunelesGreedy();
		sG5.printInforme();
		

		System.out.println("/////////////////////////////////////////////////////////\n");
		System.out.println("Dataset6");
		CSVReader reader6 = new CSVReader(path6);
		g=reader6.read();
		/*ServicioTunelesBackTraking s6= new ServicioTunelesBackTraking(g);
		s6.tunelesBackTraking();
		s6.printInforme();
		System.out.println("\n");
		*/ServicioTunelesGreddy sG6 = new ServicioTunelesGreddy(g);
		sG6.tunelesGreedy();
		sG6.printInforme();
		
		
		System.out.println("/////////////////////////////////////////////////////////");
		System.out.println("Dataset7");
		CSVReader reader7 = new CSVReader(path7);
		g=reader7.read();
		/*
		ServicioTunelesBackTraking s7= new ServicioTunelesBackTraking(g);
		s7.tunelesBackTraking();
		s7.printInforme();
		*/
		System.out.println("\n");
		ServicioTunelesGreddy sG7 = new ServicioTunelesGreddy(g);
		sG7.tunelesGreedy();
		sG7.printInforme();
		
	}
}
