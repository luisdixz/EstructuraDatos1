package unidad1_alumnos;

import java.util.Scanner;

public class Principal {
	
	private Alumnos[] a;
	private int n, opc;
	private String numControl;
	private IngresarAlumnos ia = new IngresarAlumnos();
	private BusqSecuencial bs = new BusqSecuencial();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leer = new Scanner(System.in);
		Principal p = new Principal();
		
		System.out.print("Tamaño del arreglo: ");
		p.n = leer.nextInt();
		
		p.a = new Alumnos[p.n];
		
		p.ia.ingresar(p.n, p.a);
		
		p.opc = 0;
		
		while(p.opc!=6){
			System.out.println("----------- MENU DE OPCIONES -----------");
			System.out.println("\t1. Búsqueda secuencial"
					+ "\n\t2. Búsqueda binaria"
					+ "\n\t3. Ordenamiento de la burbuja"
					+ "\n\t4.Ordenamiento Quick-sort"
					+ "\n\t5. Imprimir base de datos"
					+ "\n\t6. Salir"
					+ "\nSeleccione una opcion del menu:");
			
			p.opc = leer.nextInt();
			
			switch (p.opc) {
				case 1:
					System.out.print("Ingresa el numero de control a buscar: ");
					p.numControl = leer.next();
					
					if(p.bs.buscar(p.numControl, p.a))
						System.out.println("Dato encontrado");
					else
						System.out.println("No existe el dato buscado");
					
					break;
				case 2:
					break;
				case 3: 
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					System.out.println("Adios :3");
					break;
				default:
					System.out.println("Selecciona una opcion correcta");
			}
		}
		
		
		
		/*System.out.println(p.a[0]);
		System.out.println(p.a[1]);
		System.out.println(p.a[0].compareTo(p.a[1]));
		System.out.println(p.a[1].compareTo(p.a[0]));*/
	}

}
