package unidad1;

import java.util.Scanner;

public class P02_u1 {

	public static int factorial (int f){

		if(f==1)
			return f;
		else
			return f * factorial(f-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner (System.in);
		
		System.out.print("Escribe un numero entero: ");
		int n = leer.nextInt();
		
		System.out.println(factorial(n));
	}

}
