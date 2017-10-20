package unidad1;

import java.util.Random;
import java.util.Scanner;

public class P04_BusqRec {
	
	public static boolean busqueda(int inf, int sup, int b, int[]ar) {
		int prom = (inf+sup)/2;
		boolean band = false;
		//System.out.println(prom+ " "+band);
		
		if(inf == sup) {
			if(b==ar[prom])
				band = true;
		} 
		else if(b > ar[prom])
			return busqueda(inf = prom+1, sup, b, ar); 
		else if(b<ar[prom])
			return busqueda(inf, sup = prom-1, b, ar);
		else if(b==ar[prom])
			return band = true;
		return band;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		Random r = new Random();
		int n;
		System.out.print("Tamaño del arreglo: ");
		n = leer.nextInt();
		
		int [] a = new int[n];
		
		for(int i=0;i<n;i++) {
			//System.out.print("Escribe un numero para "+i+": ");
			a[i] = r.nextInt(100);
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
		
		
		//----------------------------- B U S Q U E D A ------------------------------------
		//------------------------------ B I N A R I A -------------------------------------
		
		System.out.print("Escriba el número a buscar: ");
		int busq = 0;
		busq = leer.nextInt();
		
		int lim0 = 0;
		int lim1 = a.length-1;
		
		if(busqueda(lim0, lim1, busq, a)) 
			System.out.println("Dato encontrado");
		else
			System.out.println("Dato no encontrado");
		
	}

}
