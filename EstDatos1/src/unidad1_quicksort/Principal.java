package unidad1_quicksort;

import java.util.Scanner;

public class Principal {

	private Arreglo[] a;
	private Insertar in = new Insertar();
	private Quicksort qu = new Quicksort();
	private int izq, der;
	
	
	public static void main(String []args) {
		Principal p = new Principal();
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Tamaño del arreglo: ");
		int n = leer.nextInt();
		
		p.a = new Arreglo[8];
		p.qu.insertar(p.a);
		
		p.izq = 0;
		p.der = p.a.length-1;
		
		for(int i=0; i<p.a.length;i++)
			System.out.println(p.a[i]);
		
		p.qu.ordenar(p.a,p.izq,p.der);
		
	}
}
