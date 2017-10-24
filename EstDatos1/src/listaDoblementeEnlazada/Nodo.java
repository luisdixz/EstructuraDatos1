package listaDoblementeEnlazada;

public class Nodo {

	private Nodo ant;
	private Nodo sig;
	private Musica datos;
	
	public Nodo getAnt() {
		return ant;
	}
	public void setAnt(Nodo ant) {
		this.ant = ant;
	}
	public Nodo getSig() {
		return sig;
	}
	public void setSig(Nodo sig) {
		this.sig = sig;
	}
	public Musica getDatos() {
		return datos;
	}
	public void setDatos(Musica datos) {
		this.datos = datos;
	}
	
	
}
