package unidad1;

import java.util.Random;
import java.util.Scanner;

public class P07_ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leer = new Scanner(System.in);
		Random r = new Random();
		int n;
		/*System.out.print("Tamaño del arreglo: ");
		n = leer.nextInt();
		
		int [] a = new int[n];*/
		int[] a={8,3,7,10,1,4,9,5};
		
		/*for(int i=0;i<a.length;i++) {
			//System.out.print("Escribe un numero para "+i+": ");
			a[i] = r.nextInt(100);
		}*/
		imprimirLista(a);
		//ordenacionShell(a);
		//sort(a);
		System.out.println("---------------------");
		ordenashell(a,a.length);
        imprimirLista(a);
	}

	public static void imprimirLista(int a[]) {
		for(int i = 0; i<a.length;i++) 
			System.out.println(a[i]);
	}
	
	public static void sort(int[] array) {
	    int inner, outer;
	    int temp;
	 
	    int h = 1;
	    while (h <= array.length / 3) {
	      h = h * 3 + 1;
	    }
	    while (h > 0) {
	      for (outer = h; outer < array.length; outer++) {
	        temp = array[outer];
	        inner = outer;
	 
	        while (inner > h - 1 && array[inner - h] >= temp) {
	          array[inner] = array[inner - h];
	          inner -= h;
	        }
	        array[inner] = temp;
	      }
	      h = (h - 1) / 3;
	    }
	  }
	
	public static void ordenacionShell(int a[]) {
		int intervalo, i, j, k, aux;
		int n= a.length;
		intervalo = n / 2;
		while (intervalo > 0){
			for (i = intervalo; i < n; i++){
				j = i - intervalo;
				while (j >= 0) {
					k = j + intervalo;
					if (a[j] <= a[k])
						j = -1; // par de elementos ordenado
					else {
						aux = a[j];
						a[j] = a[j + 1];
						a[j + i] = aux;
						j -= intervalo;
					}
				}
			}
			intervalo = intervalo / 2;
		}
	}

	
	public static void ordenashell(int a[], int n) {
		int i, aux1, aux2;
		boolean bandera;

		for (i = n; i > 0; i--) {
			i = i / 2;
			bandera = true;

			while (bandera) {
				bandera = false;
				aux1 = 0;
				while ((aux1 + i) < n) {

					if (a[aux1] > a[aux1 + i]) {
						aux2 = a[aux1];
						a[aux1] = a[aux1 + i];
						a[aux1 + i] = aux2;
						bandera = true;
					}
					aux1 = aux1 + 1;
				}

			}

		}
	}

}
