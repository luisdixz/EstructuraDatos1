package unidad1;

public class P05_QuicksortPropio {

	public static void metQuickSort(int a[], int i, int d){			
		int piv= a[i];
		int izq = i;
		int der = d;		
		int aux;
		
		while(izq<=der) {
			while(a[izq]<piv)
				izq++;
			while(piv<a[der])
				der--;
			
			if(izq<=der) {
				aux=a[izq];
				a[izq]=a[der];
				a[der]=aux;
				izq++;
				der--;
			}
			System.out.println("i="+izq+"\nd="+der+"\npiv="+piv+"\n");
			for(int is=0; is<a.length;is++)
				System.out.println(a[is]);
			System.out.println("----------------------------------");
		}
		if(i<der)
			metQuickSort(a,i,der);
		if(d>izq)
			metQuickSort(a,izq,d);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {56,12,11,90,18,10,57,33,45,7};
		int izq = 0;
		int der = a.length-1;
		
		for(int i=0; i<a.length;i++)
			System.out.println(a[i]);
		System.out.println("----------------------------------");

		
		metQuickSort(a,izq,der);
		
		for(int i=0; i<a.length;i++)
			System.out.println(a[i]);
				/*
		System.out.println("----------------------------------");
		for(int i=0; i<a.length;i++)
			System.out.println(a[i]);*/
	}

}
