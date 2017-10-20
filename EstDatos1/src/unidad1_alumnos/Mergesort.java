package unidad1_alumnos;

public class Mergesort {

	public boolean separar(Alumnos []a, int inicio, int fin) {
		if(inicio<fin) {
			int mit = (inicio+fin)/2;
			separar(a,inicio,mit);
			separar(a,mit+1,fin);
			mezclar(a,inicio,mit,fin);
		}
		return true;
	}
	
	public void mezclar(Alumnos[] a, int izq, int mit, int der) {
		String [] aux1 = new String[a.length];
		String [] aux2 = new String[a.length];
		String [] aux3 = new String[a.length];
		//System.arraycopy(a, 0, aux, 0, der);
		
		for(int i=izq;i<=der;i++) {
			aux1[i] = a[i].getNumControl();
			aux2[i] = a[i].getNombre();
			aux3[i] = a[i].getDireccion();
		}
		
		int i = izq;
		int j = mit+1;
		int k = izq;
		
		while(i<=mit && j<=der) {
			if(aux1[i].compareTo(aux1[j]) < 0) {
				a[k].setNumControl(aux1[i]);
				a[k].setNombre(aux2[i]);
				a[k].setDireccion(aux3[i]);
				i++;
			} else {
				a[k].setNumControl(aux1[j]);
				a[k].setNombre(aux2[j]);
				a[k].setDireccion(aux3[j]);
				j++;
			}
			k++;
		}
		while(i<=mit) {
			a[k].setNumControl(aux1[i]);
			a[k].setNombre(aux2[i]);
			a[k].setDireccion(aux3[i]);
			i++;
			k++;
		}
	}
}
