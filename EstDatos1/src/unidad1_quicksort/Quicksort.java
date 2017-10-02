package unidad1_quicksort;

import java.util.Random;

public class Quicksort {
	
	public static void insertar(Arreglo []a){
		Random r = new Random();
		
		for (int i=0; i<a.length; i++){
			a[i] = new Arreglo();
			a[i].setNum(String.valueOf(r.nextInt(100)));
		}
	}
	
	public static void ordenar(Arreglo []a, int i, int d){
		
		int piv= Integer.parseInt(a[i].getNum());
		int izq = i;
		int der = d;		
		String aux;
		
		while(izq<=der) {
			while(Integer.parseInt(a[izq].getNum()) < piv)
				izq++;
			while(piv < Integer.parseInt(a[der].getNum()))
				der--;
			
			if(izq<=der) {
				aux=a[izq].getNum();
				a[izq].setNum(a[der].getNum());
				a[der].setNum(aux);
				izq++;
				der--;
			}
			System.out.println("i="+izq+"\nd="+der+"\npiv="+piv+"\n");
			for(int is=0; is<a.length;is++)
				System.out.println(a[is]);
			System.out.println("----------------------------------");
		}
		if(i<der)
			ordenar(a,i,der);
		if(d>izq)
			ordenar(a,izq,d);
	}
	
}
