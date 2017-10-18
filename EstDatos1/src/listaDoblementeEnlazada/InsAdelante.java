package listaDoblementeEnlazada;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsAdelante extends JFrame implements ActionListener {

    private JLabel fondo;
    private JLabel lbl_id, lbl_nombre, lbl_artista, lbl_album, lbl_genero;
    private JTextField tf_id, tf_nom, tf_art, tf_alb, tf_gen;
    private JButton btn_aceptar, btn_cancelar;

    private Font fuente = new Font("Tahoma", Font.PLAIN, 16);
    private Font f2 = new Font("Tahoma",Font.PLAIN,14);

    private String id, cancion, artista, album, genero;
    private Principal prin;
    private ListaDoble lis;

    public InsAdelante(Principal tld, ListaDoble lista) {
        setTitle("Insertar Adelante");
        setBounds(400,150,500,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        prin = tld;
        lis = tld.getLista();

        fondo = new JLabel();
        fondo.setOpaque(true);
        fondo.setLayout(null);
        setContentPane(fondo);

        lbl_id = new JLabel("id:");
        lbl_id.setFont(fuente);
        lbl_id.setBounds(50,50,150,25);
        fondo.add(lbl_id);

        lbl_nombre = new JLabel("Nombre:");
        lbl_nombre.setFont(fuente);
        lbl_nombre.setBounds(50,100,150,25);
        fondo.add(lbl_nombre);

        lbl_artista = new JLabel("Artista:");
        lbl_artista.setFont(fuente);
        lbl_artista.setBounds(50,150,150,25);
        fondo.add(lbl_artista);

        lbl_album = new JLabel("Álbum:");
        lbl_album.setFont(fuente);
        lbl_album.setBounds(50,200,150,25);
        fondo.add(lbl_album);

        lbl_genero = new JLabel("Género:");
        lbl_genero.setFont(fuente);
        lbl_genero.setBounds(50,250, 150,25);
        fondo.add(lbl_genero);

        tf_id = new JTextField();
        tf_id.setFont(fuente);
        tf_id.setBounds(200,50,250,25);
        fondo.add(tf_id);

        tf_nom = new JTextField();
        tf_nom.setFont(fuente);
        tf_nom.setBounds(200,100,250,25);
        fondo.add(tf_nom);

        tf_art = new JTextField();
        tf_art.setFont(fuente);
        tf_art.setBounds(200,150,250,25);
        fondo.add(tf_art);

        tf_alb = new JTextField();
        tf_alb.setFont(fuente);
        tf_alb.setBounds(200,200,250,25);
        fondo.add(tf_alb);

        tf_gen = new JTextField();
        tf_gen.setFont(fuente);
        tf_gen.setBounds(200,250,250,25);
        fondo.add(tf_gen);

        btn_aceptar = new JButton("Insertar");
        btn_aceptar.setBounds(140,300,100,25);
        btn_aceptar.setFont(fuente);
        btn_aceptar.addActionListener(this);
        fondo.add(btn_aceptar);

        btn_cancelar = new JButton("Cancelar");
        btn_cancelar.setFont(fuente);
        btn_cancelar.setBounds(260,300,100,25);
        btn_cancelar.addActionListener(this);
        fondo.add(btn_cancelar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btn_cancelar) {
            this.dispose();
        } else if(e.getSource()==btn_aceptar) {
            id = tf_id.getText();
            cancion = tf_nom.getText();
            artista = tf_art.getText();
            album = tf_alb.getText();
            genero = tf_gen.getText();
            lis.insertarAdelante(id,cancion,artista,album,genero);
            //prin.setLista(prin.getLista().insertarAdelante(id,cancion,artista,album,genero));
        }
    }

}
