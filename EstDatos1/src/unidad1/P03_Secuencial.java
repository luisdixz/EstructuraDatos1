package unidad1;

import java.util.Scanner;

public class P03_Secuencial {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leer = new Scanner(System.in);
		int n;
		System.out.print("Tamaño del arreglo: ");
		n = leer.nextInt();
		
		int [] a = new int[n];
		
		for(int i=0;i<n;i++) {
			System.out.print("Escribe un numero para "+(i+1)+": ");
			a[i] = leer.nextInt();
		}
		
		
		for(int piv=0;piv < n-1;piv++) {
			for(int pun=piv+1; pun<n; pun++) {
				if (a[piv] > a[pun]) {
					int temp = a[piv];
					a[piv] = a[pun];
					a[pun] = temp;
				}
			}
		}
		
		System.out.print("\n------------------------------------\n");
		
		for(int i=0;i<n;i++) 
			System.out.println("El numero en la posicion "+(i+1)+" es: "+a[i]);
		/*
		//----------------------------- B U S Q U E D A ------------------------------------
		//--------------------------- S E C U E N C I A L ----------------------------------
		
		System.out.print("Escriba el número a buscar: ");
		int busq = 0;
		busq = leer.nextInt();
		
		int i=0;
		while(i<a.length) {
			System.out.println("i="+i);	
			if(busq==a[i]){
					
				break;
			} else {
				if(a[i]>busq) {
					System.out.println("Número no encontrado");
					break;
				}
			}
			i++;
		}*/
		
		
		//----------------------------- B U S Q U E D A ----------------------------------//
		//------------------------------ B I N A R I A -----------------------------------//
		
		System.out.print("Escriba el número a buscar: ");
		int busq = 0;
		busq = leer.nextInt();
		
		int lim0 = 0;
		int lim1 = a.length-1;
		int prom = 0;
		boolean band = false;
		do {
			prom=(lim0 + lim1) / 2;
		//	System.out.println(prom);
			if (lim0==lim1) {
				if (busq==a[prom]) 
					System.out.println("El número fue encontrado");
				else
					System.out.println("El número no fue encontrado");
				
				band = true;
			}
			else if(busq<a[prom])
				lim1 = prom-1;
			else if (busq>a[prom])
				lim0=prom+1;
			else if(busq == a[prom])
			{
				System.out.println("El número fue encontrado");
				band=true;
			}
				
			
		} while(band == false);
	}
}
