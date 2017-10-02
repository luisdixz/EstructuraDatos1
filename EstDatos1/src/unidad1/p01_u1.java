package unidad1;
import java.util.Scanner;

public class p01_u1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leer = new Scanner(System.in);
		int n;
		System.out.print("Tamaño del arreglo: ");
		n = leer.nextInt();
		
		int [] a = new int[n];
		
		for(int i=0;i<n;n++) {
			System.out.print("Escribe un numero para "+n+": ");
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
			System.out.print("El numero en la posicion "+i+" es: "+a[i]);
	}

}
