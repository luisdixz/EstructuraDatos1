package listaDobleEnlazada;

import javax.swing.JOptionPane;

public class ListaDoble {

	private Nodo cabeza;

	public ListaDoble() {
		this.cabeza = null;
	}

	public Nodo getCabeza() {
		return cabeza;
	}

	public void setCabeza(Nodo cabeza) {
		this.cabeza = cabeza;
	}
	
    public boolean isVacio() {
        boolean res = false;
        if(this.cabeza==null)
            res=true;
        return res;
    }
    
    public int contar () {
        int n = 0;
        Nodo temp = this.cabeza;
        while(temp!= null) {
            n++;
            temp = temp.getSig();
        }		
        return n;
    }
    
    public void insertar(Musica datos) {
    	Nodo nodo = new Nodo();
    	nodo.setDatos(datos);
    	nodo.setAnt(null);
    	nodo.setSig(null);
    	this.cabeza = nodo;
    }
    
    public boolean insertarAdelante(Musica datos) {
    	boolean res = false;
    	
    	if(this.isVacio()) {
    		this.insertar(datos);
    		res = true;
    	} else {
    		Nodo nodo = new Nodo();
    		Nodo temp = this.cabeza;
    		
    		nodo.setDatos(datos);
    		
    		while(temp.getSig()!=null)
    			temp = temp.getSig();
    		
    		nodo.setAnt(temp);
    		nodo.setSig(null);
    		temp.setSig(nodo);
    		res = true;
    	}
    	return res;
    }
    
    public boolean insertarAtras(Musica datos) {
    	boolean res = false;
    	
    	if(this.isVacio()) {
    		this.insertar(datos);
    		res = true;
    	} else {
    		Nodo nodo = new Nodo();
    		nodo.setDatos(datos);
    		nodo.setAnt(null);
    		nodo.setSig(this.cabeza);
    		this.cabeza.setAnt(nodo);
    		this.cabeza = nodo;
    		
    		res = true;
    	}
    	
    	return res;
    }
    
    public boolean eliminarPrimero(int opc) {    
    	boolean res = false;
    	if(opc==0) {
    		if(this.contar()==1) {
    			this.cabeza=null;
    		}
    		else {
    			this.setCabeza(this.cabeza.getSig());
    			this.cabeza.setAnt(null);
    			res = true;
    		}
    	}
    	return res;
    }
    
    public boolean eliminarUltimo(int opc) {
    	boolean res = false;
    	
    	if(opc==0) {
    		if(this.contar()==1) 
    			this.cabeza=null;
    		else {
    			Nodo temp = this.cabeza;
    			while(temp.getSig()!=null) {
    				temp = temp.getSig();
    			}
    			temp.getAnt().setSig(null);
    			res=true;
    		}
    	}
    	
    	return res;
    }
    
    public StringBuilder recAdelante() {
    	StringBuilder cadena = new StringBuilder();
    	
    	Nodo temp = this.cabeza;
    	
    	cadena.append("Cabeza:");
    	cadena.append("\n------------------------------\n");
    	//int n = 0;
    	
    	while(temp!=null) {
    		cadena.append("Nodo anterior: ");
    		cadena.append(temp.getAnt());
    		cadena.append("\n\n");
    		cadena.append(temp.getDatos());
    		cadena.append("\n\n");
    		cadena.append("Nodo siguiente: ");
    		cadena.append(temp.getSig());
    		cadena.append("\n------------------------------\n");
    		temp = temp.getSig();
    		/*n++;
            JOptionPane.showMessageDialog(null, n);*/
    	}
    	
    	cadena.append(temp);
    	
    	return cadena;
    }
    
    public StringBuilder recAtras() {
    	StringBuilder cadena = new StringBuilder();
    	Nodo temp = this.cabeza;
    	
    	while(temp.getSig()!=null)
    		temp = temp.getSig();
    	
    	cadena.append("Cabeza:");
    	cadena.append("\n------------------------------\n");
    	
    	while(temp!=null) {
    		cadena.append("Nodo anterior: ");
    		cadena.append(temp.getAnt());
    		cadena.append("\n\n");
    		cadena.append(temp.getDatos());
    		cadena.append("\n\n");
    		cadena.append("Nodo siguiente: ");
    		cadena.append(temp.getSig());
    		cadena.append("\n------------------------------\n");
    		temp = temp.getAnt();
    	}
    	
    	return cadena;
    }
    
}
