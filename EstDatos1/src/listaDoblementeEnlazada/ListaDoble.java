package listaDoblementeEnlazada;

//import javax.swing.JOptionPane;

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
        if(temp!= null) {

            n++;
            temp = temp.getSig();
        }

        return n;
    }

    //public void encontrar

    public void insertar(Musica dat) {
        Nodo nodo = new Nodo();

        
        /*nodo.setId(id);
        nodo.setCancion(cancion);
        nodo.setArtista(artista);
        nodo.setAlbum(album);
        nodo.setGenero(genero);*/
        nodo.setDatos(dat);
        nodo.setAnt(null);
        nodo.setSig(null);
        this.cabeza = nodo;
    }

    public boolean insertarAntes (Musica dat) {
        boolean res = false;
    	if(this.isVacio()) {
            this.insertar(dat);
            res = true;
    	}
        else {
            //Nodo temp = this.cabeza;
            Nodo nodo = new Nodo();
            /*nodo.setId(id);
            nodo.setCancion(cancion);
            nodo.setArtista(artista);
            nodo.setAlbum(album);
            nodo.setGenero(genero);*/
            nodo.setDatos(dat);
            nodo.setSig(this.cabeza);
            /*if (this.contar()>2) {

            } else*/
                this.cabeza.setAnt(nodo);
            this.cabeza=nodo;
            res = true;
        }
    	return res;
    }

    public boolean insertarAdelante (Musica dat) {
        boolean res= false;
    	if(this.isVacio()) {
    		this.insertar(dat);
    		res = true;
    	}            
        else{
            Nodo nodo = new Nodo();
            /*nodo.setId(id);
            nodo.setCancion(cancion);
            nodo.setArtista(artista);
            nodo.setAlbum(album);
            nodo.setGenero(genero);*/
            nodo.setDatos(dat);

            Nodo temp = this.cabeza;

            while(temp.getSig() != null) {
                temp = temp.getSig();
            }

            nodo.setAnt(temp);
            nodo.setSig(null);
            temp.setSig(nodo);
            res = true;
        }
    	return res;
    }

    public void eliminarPrimero () {
        this.setCabeza(this.cabeza.getSig());
        this.cabeza.setAnt(null);
        System.out.println("Nodo eliminado");
    }

    public StringBuilder imprimir() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("Cabeza:\n");
        Nodo temp = this.cabeza;

        while (temp!=null) {
            cadena.append("Nodo anterior: ");
            cadena.append(temp.getAnt());
            cadena.append("\n");
            cadena.append(temp.getDatos());
            cadena.append("\n");
            /*cadena.append(temp.getId());
            cadena.append("\n");
            cadena.append(temp.getCancion());
            cadena.append("\n");
            cadena.append(temp.getArtista());
            cadena.append("\n");
            cadena.append(temp.getAlbum());
            cadena.append("\n");
            cadena.append(temp.getGenero());
            cadena.append("\n");
            cadena.append("Nodo anterior: ");
            cadena.append(temp.getAnt());
            cadena.append("\n");*/
            cadena.append("Nodo siguiente: ");
            cadena.append(temp.getSig());

            cadena.append("\n----------------------------------\n");
            temp=temp.getSig();
        }
        cadena.append("NULL");
        return cadena;
    }
}
