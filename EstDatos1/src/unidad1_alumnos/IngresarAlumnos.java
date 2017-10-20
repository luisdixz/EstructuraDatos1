package unidad1_alumnos;

import java.util.Scanner;

public class IngresarAlumnos {
	
	public boolean ingresar(int n, Alumnos[] a) {
		//boolean res = false;
		
		Scanner leer = new Scanner(System.in);
		
		for(int i=0; i<n; i++){
			a[i]=new Alumnos();
			
			System.out.print("Ingrese número de control del alumno "+(i+1)+": ");
			a[i].setNumControl(leer.nextLine());
			
			System.out.print("Ingrese nombre del alumno "+(i+1)+": ");
			a[i].setNombre(leer.nextLine());
			
			System.out.print("Ingrese dirección del alumno "+(i+1)+": ");
			a[i].setDireccion(leer.nextLine());
		}
		
		return false;
	}
	
}
