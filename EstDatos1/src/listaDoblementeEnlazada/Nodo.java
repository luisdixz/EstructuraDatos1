package listaDoblementeEnlazada;

public class Nodo {
	
    //private Musica datos;
    private Nodo sig;
    private Nodo ant;
    private String id;
    private String cancion;
    private String artista;
    private String album;
    private String genero;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCancion() {
		return cancion;
	}
	public void setCancion(String cancion) {
		this.cancion = cancion;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Nodo getSig() {
		return sig;
	}
	public void setSig(Nodo sig) {
		this.sig = sig;
	}
	public Nodo getAnt() {
		return ant;
	}
	public void setAnt(Nodo ant) {
		this.ant = ant;
	}
	
	/*public Musica getDatos() {
		return datos;
	}
	
	public void setDatos(Musica datos) {
		this.datos = datos;
	}    */
}
