package unidad1_alumnos;

import java.util.Scanner;

public class Shellsort {

	public boolean ordenar(Alumnos []a) {
		int i,j, k=1;
		String temp, temp2, temp3;
		
		while (k< a.length/3) {
			k *= 3 + 1;
		}
		while(k>0) {
			for(i = k;i<a.length;i++){ 
				temp = a[i].getNumControl();
				temp2 = a[i].getNombre();
				temp3 = a[i].getDireccion();
				j=i;
				
				while(j > k-1 && (a[j-k].getNumControl().compareTo(temp) > 0 || a[j-k].getNumControl().compareTo(temp)==0)){
					a[j].setNumControl(a[j-k].getNumControl());
					a[j].setNombre(a[j-k].getNombre());
					a[j].setDireccion(a[j-k].getDireccion());
					j-=k;
				}
				a[j].setNumControl(temp);
				a[j].setNombre(temp2);
				a[j].setDireccion(temp3);
			}
			k = (k-1)/3;
		}
		return true;
	}
	
	/*public boolean ordenar(Alumnos []a) {
		int i, aux1, n=a.length;
		String aux2;
		boolean band = false;
		
		for (i = n; i > 0; i--) {
			i = i / 2;
			band = true;

			while (band) {
				band = false;
				aux1 = 0;
				while ((aux1 + i) < n) {

					if (a[aux1].getNumControl().compareTo(a[aux1 + i].getNumControl()) > 0) {
						aux2 = a[aux1].getNumControl();
						a[aux1].setNumControl(a[aux1 + i].getNumControl());
						a[aux1 + i].setNumControl(aux2);
						band = true;
					}
					aux1 = aux1 + 1;
				}

			}

		}
		
		return true;
	}*/
}