package unidad1;

import java.util.Random;
import java.util.Scanner;

public class P06_MergeSort {
	
	public void separar(int[] a, int inicio, int fin) {
		if(inicio<fin) {
			int mit = (inicio+fin)/2;
			separar(a,inicio,mit);
			separar(a,mit+1,fin);
			mezclar(a,inicio,mit,fin);
		}
	}
	
	public void mezclar(int[] a, int inicio, int mit, int fin) {
		int[] aux = new int[a.length];
		
		System.arraycopy(a, 0, aux, 0, a.length);
		
		int i = inicio;
		int j = mit+1;
		int k = inicio;
		
		while(i<=mit && j<=fin) {
			if(aux[i]<aux[j]){
				a[k]= aux[i];
				i++;
			} else {
				a[k] = aux[j];
				j++;
			}
			k++;
		}
		while(i<=mit) {
			a[k] = aux[i];
			i++;
			k++;
		}
	}
	
	public void imprimir(int[] a){
		for(int i =0; i<a.length;i++) 
			System.out.println(a[i]);
	}
	
	public static void main(String [] args){
		int arr[] = {20,54,12,11,75,13,43};
		P06_MergeSort ms = new P06_MergeSort();
		
		System.out.println("Arreglo original: ");
		ms.imprimir(arr);
		
		ms.separar(arr,0,arr.length-1);
		
		System.out.println("Arreglo ordenado: ");
		ms.imprimir(arr);
	}	
	
	
	/*public int [] separar(int a[], int inicio, int fin){
		int [] arr= new int[a.length];
		int mitad = (inicio+fin)/2;
		
		if(mitad!=0){
			separar(a,inicio,mitad);
			separar(a,mitad+1,fin);
			
		}
		arr=mezclar(a,inicio,mitad,fin);
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
	
	/*
	public void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create temp arrays 
		int L[] = new int [n1];
		int R[] = new int [n2];

		//Copy data to temp arrays
		for (int i=0; i< L.length; ++i)
			L[i] = arr[l + i];
		for (int j=0; j< R.length; ++j)
			R[j] = arr[m + 1+ j];


		// Merge the temp arrays 

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < L.length && j < R.length)
		{
			if (L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any 
		while (i < n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any 
		while (j < n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	public void sort(int arr[], int l, int r)
	{
		if (l < r)
		{
			// Find the middle point
			int m = (l+r)/2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr , m+1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	// A utility function to print array of size n 
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver method
	public static void main(String args[])
	{
		int arr[] = {12, 11, 13, 5, 6, 7,20,33,10,9,50};
		
		P06_MergeSort ms = new P06_MergeSort();
		
		System.out.println("Given Array");
		printArray(arr);

		ms.sort(arr, 0, arr.length-1);

		System.out.println("\nSorted array");
		printArray(arr);
	}*/
}
