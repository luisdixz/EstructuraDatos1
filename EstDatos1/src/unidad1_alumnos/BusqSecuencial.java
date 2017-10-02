package unidad1_alumnos;

public class BusqSecuencial {

	public boolean buscar(String nc, Alumnos[] a) {
		boolean res = false;
		
		for(int i=0; i<a.length; i++) {
			if(a[i].getNumControl().equals(nc))
				res = true;
		}
		
		return res;
	}
	
}
