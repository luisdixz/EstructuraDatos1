package listaDoblementeEnlazada;

import java.util.Scanner;

public class TestListaDoble {
    private ListaDoble lista = new ListaDoble();

    public static void main (String [] args) {
        TestListaDoble tld = new TestListaDoble();
        Scanner leer = new Scanner(System.in);
        int op = 0;
        String id, cancion, artista, album, genero;

        do {
            System.out.println("***** MENU DE OPCIONES *****\n");
            System.out.println("1. Vacío");
            System.out.println("2. Insertar - principio");
            System.out.println("3. Insertar - final");/*
            System.out.println("4. Insertar - atras");
            System.out.println("5. Insertar - adelante");*/
            System.out.println("4. Eliminar primer nodo");
            System.out.println("5. Eliminar ultimo nodo");
            System.out.println("6. Recorrido hacia adelante");
            System.out.println("7. Recorrido hacia atras");
            System.out.println("8. Imprimir");
            System.out.println("9. Salir");
            System.out.print("\nEscriba la opcion correspondiente a la accion que desea realizar (1-9)");
            op = Integer.parseInt(leer.nextLine());

            switch (op) {
                case 1:
                    if(tld.lista.isVacio())
                        System.out.println("La lista esta vacía\n");
                    else
                        System.out.println("La lista no esta vacía\n");
                    break;
                case 2:
                    System.out.println("-------------------------------------------");
                    System.out.println("Ingrese los siguientes datos:");
                    System.out.println("-------------------------------------------");
                    System.out.println("\tId de la canción:");
                    id = leer.nextLine();
                    System.out.println("\tNombre de la canción:");
                    cancion = leer.nextLine();
                    System.out.println("\tArtista al que pertenece la canción:");
                    artista = leer.nextLine();
                    System.out.println("\tAlbum del cual viene la canción:");
                    album = leer.nextLine();
                    System.out.println("\tGenero de la canción:");
                    genero = leer.nextLine();

                    tld.lista.insertarAntes(id,cancion,artista,album,genero);
                    System.out.println("-------------------------------------------");
                    System.out.println("Datos ingresados correctamente");
                    System.out.println("-------------------------------------------");
                    break;
                case 3:
                    System.out.println("-------------------------------------------");
                    System.out.println("Ingrese los siguientes datos:");
                    System.out.println("-------------------------------------------");
                    System.out.println("\tId de la canción:");
                    id = leer.nextLine();
                    System.out.println("\tNombre de la canción:");
                    cancion = leer.nextLine();
                    System.out.println("\tArtista al que pertenece la canción:");
                    artista = leer.nextLine();
                    System.out.println("\tAlbum del cual viene la canción:");
                    album = leer.nextLine();
                    System.out.println("\tGenero de la canción:");
                    genero = leer.nextLine();

                    tld.lista.insertarAdelante(id,cancion,artista,album,genero);
                    System.out.println("-------------------------------------------");
                    System.out.println("Datos ingresados correctamente");
                    System.out.println("-------------------------------------------");
                    break;
                case 4:
                    System.out.println("-------------------------------------------");
                    tld.lista.eliminarPrimero();
                    System.out.println("-------------------------------------------");
                    break;
                case 5:
                    System.out.println("-------------------------------------------");
                    System.out.println("Nodo Eliminado");
                    System.out.println("-------------------------------------------");
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println(tld.lista.imprimir());
                    break;
                case 9:
                    break;
            }
        } while (op!=9);
    }
}
