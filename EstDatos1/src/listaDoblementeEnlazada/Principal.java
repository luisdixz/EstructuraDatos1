package listaDoblementeEnlazada;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener {

    private ListaDoble lista = new ListaDoble();
    //private Musica mu = new Musica();

    private JScrollBar js;
    private JMenuBar jmb;
    private JMenu jm_insertar,jm_eliminar, jm_recorrido, jm_opc;
    private JMenuItem jmi_Iadelante, jmi_Iatras, jmi_imprimir, jmi_salir, jmi_vacio;
    private JLabel fondo;
    private JLabel lbl_res;
    private JTextArea ta_res;
    private JPanel pnl_Iadelante, pnl_imp;

    private Font fuente = new Font("Tahoma", Font.PLAIN, 16);
    private Font f2 = new Font("Tahoma",Font.PLAIN,14);
    private Font fLog = new Font("",Font.PLAIN,14);
    
    private JLabel lbl_id, lbl_nombre, lbl_artista, lbl_album, lbl_genero;
    private JTextField tf_id, tf_nom, tf_art, tf_alb, tf_gen;
    private JButton btn_aceptar, btn_cancelar;
    
    private String id, cancion, artista, album, genero;
    
    public Principal() {
        setTitle("Listas");
        setBounds(400,200,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fondo = new JLabel();
        fondo.setBackground(new Color(255,255,255));
        fondo.setOpaque(true);
        fondo.setLayout(null);
        setContentPane(fondo);

        jmb = new JMenuBar();
        setJMenuBar(jmb);

        jm_insertar = new JMenu("Insertar");
        jm_insertar.setFont(fuente);
        jm_insertar.setMnemonic(KeyEvent.VK_I);

        jm_opc = new JMenu("Opciones...");
        jm_opc.setFont(fuente);
        jm_opc.setMnemonic(KeyEvent.VK_O);

        jmb.add(jm_opc);
        jmb.add(jm_insertar);

        jmi_vacio = new JMenuItem("Â¿Lista vacia? (1)");
        jmi_vacio.setFont(f2);
        jmi_vacio.setMnemonic(KeyEvent.VK_1);
        jmi_vacio.addActionListener(this);

        jmi_imprimir = new JMenuItem("Imprimir lista en pantalla (2)");
        jmi_imprimir.setFont(f2);
        jmi_imprimir.setMnemonic(KeyEvent.VK_2);
        jmi_imprimir.addActionListener(this);

        jmi_salir = new JMenuItem("Salir (3)");
        jmi_salir.setFont(f2);
        jmi_salir.setMnemonic(KeyEvent.VK_3);

        jm_opc.add(jmi_vacio);
        jm_opc.add(jmi_imprimir);
        jm_opc.add(jmi_salir);

        jmi_Iadelante = new JMenuItem("Adelante (1)");
        jmi_Iadelante.setFont(f2);
        jmi_Iadelante.setMnemonic(KeyEvent.VK_1);
        jmi_Iadelante.addActionListener(this);

        jmi_Iatras = new JMenuItem("Atras (2)");
        jmi_Iatras.setFont(f2);
        jmi_Iatras.setMnemonic(KeyEvent.VK_2);
        jmi_Iatras.addActionListener(this);

        jm_insertar.add(jmi_Iadelante);
        jm_insertar.add(jmi_Iatras);

        pnl_imp = new JPanel();
        pnl_imp.setLayout(null);
        pnl_imp.setBounds(25, 25, 440, 380);
        pnl_imp.setBackground(new Color(255,255,255));
        pnl_imp.setVisible(false);
        fondo.add(pnl_imp);      
        
        lbl_res = new JLabel("Lista Actual:");
        lbl_res.setBounds(10,10,200,25);
        lbl_res.setFont(f2);
        //lbl_res.setVisible(false);
        pnl_imp.add(lbl_res);

        ta_res = new JTextArea();
        ta_res.setFont(f2);
        ta_res.setBounds(0,0,400,325);
        //ta_res.setVisible(false);
        pnl_imp.setEnabled(false);

        js = new JScrollBar();
        js.setBounds(50,75,400,325);
        js.add(ta_res);
        //js.setVisible(false);
        pnl_imp.add(js);
        
        pnl_Iadelante = new JPanel();
        pnl_Iadelante.setBorder(BorderFactory.createTitledBorder("Insertar adelante"));
        pnl_Iadelante.setLayout(null);
        pnl_Iadelante.setBounds(25, 25, 440, 380);
        pnl_Iadelante.setBackground(new Color(255,255,255));
        pnl_Iadelante.setVisible(false);
        fondo.add(pnl_Iadelante);  
        
        lbl_id = new JLabel("id:");
        lbl_id.setFont(fuente);
        lbl_id.setBounds(25,50,150,25);
        pnl_Iadelante.add(lbl_id);

        lbl_nombre = new JLabel("Nombre:");
        lbl_nombre.setFont(fuente);
        lbl_nombre.setBounds(25,100,150,25);
        pnl_Iadelante.add(lbl_nombre);

        lbl_artista = new JLabel("Artista:");
        lbl_artista.setFont(fuente);
        lbl_artista.setBounds(25,150,150,25);
        pnl_Iadelante.add(lbl_artista);

        lbl_album = new JLabel("Álbum:");
        lbl_album.setFont(fuente);
        lbl_album.setBounds(25,200,150,25);
        pnl_Iadelante.add(lbl_album);

        lbl_genero = new JLabel("Género:");
        lbl_genero.setFont(fuente);
        lbl_genero.setBounds(25,250, 150,25);
        pnl_Iadelante.add(lbl_genero);

        tf_id = new JTextField();
        tf_id.setFont(fuente);
        tf_id.setBounds(150,50,250,25);
        pnl_Iadelante.add(tf_id);

        tf_nom = new JTextField();
        tf_nom.setFont(fuente);
        tf_nom.setBounds(150,100,250,25);
        pnl_Iadelante.add(tf_nom);

        tf_art = new JTextField();
        tf_art.setFont(fuente);
        tf_art.setBounds(150,150,250,25);
        pnl_Iadelante.add(tf_art);

        tf_alb = new JTextField();
        tf_alb.setFont(fuente);
        tf_alb.setBounds(150,200,250,25);
        pnl_Iadelante.add(tf_alb);

        tf_gen = new JTextField();
        tf_gen.setFont(fuente);
        tf_gen.setBounds(150,250,250,25);
        pnl_Iadelante.add(tf_gen);

        btn_aceptar = new JButton("Insertar");
        btn_aceptar.setBounds(115,300,100,25);
        btn_aceptar.setFont(fuente);
        btn_aceptar.addActionListener(this);
        pnl_Iadelante.add(btn_aceptar);

        btn_cancelar = new JButton("Cancelar");
        btn_cancelar.setFont(fuente);
        btn_cancelar.setBounds(235,300,100,25);
        btn_cancelar.addActionListener(this);
        pnl_Iadelante.add(btn_cancelar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== jmi_vacio) {
            if(this.lista.isVacio())
                JOptionPane.showMessageDialog(null,"La lista esta vacía");
            else
                JOptionPane.showMessageDialog(null,"La lista no esta vacía");
        }
        else if(e.getSource()==jmi_Iadelante) {
        	pnl_imp.setVisible(false);
        	pnl_Iadelante.setVisible(true);
        	
        }
        else if(e.getSource()==jmi_imprimir) {
            pnl_imp.setVisible(true);
            pnl_Iadelante.setVisible(false);
        	//lbl_res.setVisible(true);
            String imp = this.lista.imprimir().toString();
            ta_res.setText(imp);
            JOptionPane.showMessageDialog(null, imp);
            //ta_res.setVisible(true);
        }
        else if(e.getSource()==btn_cancelar) {
        	pnl_imp.setVisible(false);
        	pnl_Iadelante.setVisible(false);
        	
        }
        else if(e.getSource()==btn_aceptar) {
        	id = tf_id.getText();
            cancion = tf_nom.getText();
            artista = tf_art.getText();
            album = tf_alb.getText();
            genero = tf_gen.getText();
            
            if(this.lista.insertarAdelante(id, cancion, artista, album, genero))
            	JOptionPane.showMessageDialog(null, "Se ingresaron los datos");
            pnl_Iadelante.setVisible(false);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Principal pr = new Principal();
                pr.setVisible(true);
            }
        });
    }
}
