package listaDoblementeEnlazada;

public class Musica {

    private String id;
    private String cancion;
    private String artista;
    private String album;
    private String genero;
    private Musica sig;
    private Musica ant;

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

    public Musica getSig() {
        return sig;
    }

    public void setSig(Musica sig) {
        this.sig = sig;
    }

    public Musica getAnt() {
        return ant;
    }

    public void setAnt(Musica ant) {
        this.ant = ant;
    }
}
