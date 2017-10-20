package unidad1_alumnos;

public class Burbuja {

	public boolean ordenarB(Alumnos []a){
		
		for(int piv=0;piv < a.length-1;piv++) {
			for(int pun=piv+1; pun<a.length; pun++) {
				if (a[piv].getNumControl().compareTo(a[pun].getNumControl())<0) {
					String temp1 = a[piv].getNumControl();
					String temp2 = a[piv].getNombre();
					String temp3 = a[piv].getDireccion();
					a[piv].setNumControl(a[pun].getNumControl());
					a[piv].setNombre(a[pun].getNombre());
					a[piv].setDireccion(a[pun].getDireccion());
					a[pun].setNumControl(temp1);
					a[pun].setNombre(temp2);
					a[pun].setDireccion(temp3);
				}
			}
		}
		return true;
	}
}
