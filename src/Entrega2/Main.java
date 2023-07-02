package Entrega2;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static <T> void main(String[] args) {
		
		GrafoNoDirigido g = new GrafoNoDirigido();
		String path1 = "dataset/dataset1.txt";
		String path2 = "dataset/dataset2.txt";
		String path3 = "dataset/dataset3.txt";
		String path4 = "dataset/dataset4.txt";
		String path5 = "dataset/dataset5.txt";
		String path6 = "dataset/dataset6.txt";
		String path7 = "dataset/dataset7.txt";
		
		/*
		System.out.println("Dataset1");
		CSVReader reader = new CSVReader(path1);
		reader.read(g);
		ServicioTunelesBackTraking s= new ServicioTunelesBackTraking(g);
		s.tunelesBackTraking();
		s.printInforme();
		System.out.println("/////////////////////////////////////////////////////////");
		ServicioTunelesGreddy sG = new ServicioTunelesGreddy(g);
		sG.TunelesGreddy();
		sG.printInforme();
		
		
		System.out.println("Dataset2");
		System.out.println("/////////////////////////////////////////////////////////");
		CSVReader reader2 = new CSVReader(path2);
		reader2.read(g);
		ServicioTunelesBackTraking s2= new ServicioTunelesBackTraking(g);
		s2.tunelesBackTraking();
		s2.printInforme();
		System.out.println("/////////////////////////////////////////////////////////");
		ServicioTunelesGreddy sG2 = new ServicioTunelesGreddy(g);
		sG2.TunelesGreddy();
		sG2.printInforme();
		
		System.out.println("/////////////////////////////////////////////////////////");
		System.out.println("Dataset3");
		CSVReader reader3 = new CSVReader(path3);
		reader3.read(g);
		ServicioTunelesBackTraking s3= new ServicioTunelesBackTraking(g);
		s3.tunelesBackTraking();
		s3.printInforme();
		System.out.println("/////////////////////////////////////////////////////////");
		ServicioTunelesGreddy sG3 = new ServicioTunelesGreddy(g);
		sG3.TunelesGreddy();
		sG3.printInforme();
		
		System.out.println("/////////////////////////////////////////////////////////");
		System.out.println("Dataset4");
		CSVReader reader4 = new CSVReader(path4);
		reader4.read(g);
		ServicioTunelesBackTraking s4= new ServicioTunelesBackTraking(g);
		s4.tunelesBackTraking();
		s4.printInforme();
		System.out.println("/////////////////////////////////////////////////////////");
		ServicioTunelesGreddy sG4 = new ServicioTunelesGreddy(g);
		sG4.TunelesGreddy();
		sG4.printInforme();
		
		
		System.out.println("/////////////////////////////////////////////////////////");
		System.out.println("Dataset5");
		CSVReader reader5 = new CSVReader(path5);
		reader5.read(g);
		ServicioTunelesBackTraking s5= new ServicioTunelesBackTraking(g);
		s5.tunelesBackTraking();
		s5.printInforme();
		System.out.println("/////////////////////////////////////////////////////////");
		ServicioTunelesGreddy sG5 = new ServicioTunelesGreddy(g);
		sG5.TunelesGreddy();
		sG5.printInforme();
		
		*/
		System.out.println("/////////////////////////////////////////////////////////");
		System.out.println("Dataset6");
		CSVReader reader6 = new CSVReader(path6);
		reader6.read(g);
		/*ServicioTunelesBackTraking s6= new ServicioTunelesBackTraking(g);
		s6.tunelesBackTraking();
		s6.printInforme();
		System.out.println("/////////////////////////////////////////////////////////");
		*/ServicioTunelesGreddy sG6 = new ServicioTunelesGreddy(g);
		sG6.TunelesGreddy();
		sG6.printInforme();
		
		/*
		System.out.println("/////////////////////////////////////////////////////////");
		System.out.println("Dataset7");
		CSVReader reader7 = new CSVReader(path7);
		reader7.read(g);
		ServicioTunelesBackTraking s7= new ServicioTunelesBackTraking(g);
		s7.tunelesBackTraking();
		s7.printInforme();
		System.out.println("/////////////////////////////////////////////////////////");
		ServicioTunelesGreddy sG7 = new ServicioTunelesGreddy(g);
		sG7.TunelesGreddy();
		sG7.printInforme();
		*/
	}
}
