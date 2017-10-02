package unidad1;

import java.util.Random;
import java.util.Scanner;

public class P06_MergeSort {
		
	public int [] separar(int a[], int inicio, int fin){
		int [] arr= new int[a.length];
		if(inicio<fin){
			int mitad = (inicio+fin)/2;
			
			separar(a,inicio,mitad);
			separar(a,mitad+1,fin);
			arr=mezclar(a,inicio,mitad,fin);
			
		}
		return arr;
	}
	
	public int [] mezclar(int a[], int izq, int mid, int der) {
		int x, y, z;
		int [] aux = new int[a.length]; 
		
		for (int i=izq; i<=der; i++) 
			aux[i]=a[i];

		x=izq; 
		y=mid+1; 
		z=izq;
		
		while (x<=mid && y<=der) {
			if (aux[x]<=aux[y])
				a[z++]=aux[x++];
		    else
		    	a[z++]=aux[y++];
		}
			
		while (x<=mid) 
			a[z++]=aux[x++];
		return a; 
	}
	
	public static void main(String []args) {
		Scanner leer = new Scanner(System.in);
		Random r = new Random();
		P06_MergeSort ms = new P06_MergeSort();
		
		int n = 0;
		
		System.out.print("Tamaño del arreglo:");
		n = leer.nextInt();
		
		int arr[] = new int[n]; 
		for(int i =0; i<arr.length; i++)
			arr[i] = r.nextInt(100);
		
		for(int i =0; i<arr.length; i++) 
			System.out.println(arr[i]);
		System.out.println("----------");
		
		arr = ms.separar(arr,0,arr.length-1);
		
		for(int i =0; i<arr.length; i++) 
			System.out.println(arr[i]);
	}
	
}
