package unidad1_alumnos;

import java.util.Random;

public class Quicksort {
	
	public boolean ordenar(Alumnos []a, int i, int d){
		
		String piv= a[i].getNumControl();
		int izq = i;
		int der = d;		
		String aux1, aux2, aux3;
		
		while(izq<=der) {
			while(a[izq].getNumControl().compareTo(piv) < 0)
				izq++;
			while(a[der].getNumControl().compareTo(piv) > 0)
				der--;
			
			if(izq<=der) {
				aux1 = a[izq].getNumControl();
				aux2 = a[izq].getNombre();
				aux3 = a[izq].getDireccion();
				a[izq].setNumControl(a[der].getNumControl());
				a[izq].setNombre(a[der].getNombre());
				a[izq].setDireccion(a[der].getDireccion());
				a[der].setNumControl(aux1);
				a[der].setNombre(aux2);
				a[der].setDireccion(aux3);
				izq++;
				der--;
			}/*
			System.out.println("i="+izq+"\nd="+der+"\npiv="+piv+"\n");
			for(int is=0; is<a.length;is++)
				System.out.println(a[is]);
			System.out.println("----------------------------------");*/
		}
		if(i<der)
			ordenar(a,i,der);
		if(d>izq)
			ordenar(a,izq,d);
		return true;
	}
}
