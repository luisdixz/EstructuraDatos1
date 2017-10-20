package unidad1_alumnos;

public class BuscBin {

	public static boolean buscar(Alumnos [] a, int inf, int sup, String b){
		int prom = (inf+sup)/2;
		boolean band = false;
		//System.out.println(prom+ " "+band);
		
		if(inf == sup) {
			if(a[prom].getNumControl().compareTo(b)==0)
				band = true;
		} 
		else if(b.compareTo(a[prom].getNumControl())<0)
			return buscar(a, prom+1, sup, b); 
		else if(b.compareTo(a[prom].getNumControl())>0)
			return buscar(a, inf, prom-1, b);
		else if(a[prom].getNumControl().compareTo(b)==0)
			return band = true;
		return band;
	}
	
	/* int prom = (inf+sup)/2;
		boolean band = false;
		//System.out.println(prom+ " "+band);
		
		if(inf == sup) {
			if(a[prom].getNumControl().compareTo(b)==0)
				band = true;
		} 
		else if(a[prom].getNumControl().compareTo(b)>0)
			return buscar(a, prom+1, sup, b); 
		else if(a[prom].getNumControl().compareTo(b)<0)
			return buscar(a, inf, prom-1, b);
		else if(a[prom].getNumControl().compareTo(b)==0)
			return band = true;
		return band; */
	
}
