package listaDoblementeEnlazada;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

//import org.jvnet.substance.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceMarinerLookAndFeel;

public class Principal extends JFrame implements ActionListener {

    private ListaDoble lista = new ListaDoble();
    
    //private Principal prin;
    
    private JScrollPane js;
    private JMenuBar jmb;
    private JMenu jm_insertar,jm_eliminar, jm_recorrido, jm_opc;
    private JMenuItem jmi_Iadelante, jmi_Iatras, jmi_imprimir, jmi_salir, jmi_vacio, jmi_ePrim, jmi_eUlt;
    private JPanel fondo;
    private JLabel lbl_res;
    private JTextArea ta_res;
    private JPanel pnl_Iadelante, pnl_imp, pnl_Iatras, pnl_elimP;

    private Font fuente = new Font("Tahoma", Font.PLAIN, 16);
    private Font f2 = new Font("Tahoma",Font.PLAIN,14);
    private Font fLog = new Font("",Font.PLAIN,14);
    
    private JLabel[] lbl_id = new JLabel[2], 
    		lbl_nombre = new JLabel[2],
    		lbl_artista = new JLabel[2],
    		lbl_album = new JLabel[2],
    		lbl_genero = new JLabel[2];
    
    private JTextField[] tf_id = new JTextField[2],
    		tf_nom = new JTextField[2], 
    		tf_art = new JTextField[2], 
    		tf_alb = new JTextField[2], 
    		tf_gen = new JTextField[2];
    
    private JButton[] btn_aceptar = new JButton[2],
    		btn_cancelar = new JButton[2];
    
    private String id, cancion, artista, album, genero;
    
    public ListaDoble getLista() {
		return lista;
	}

	public void setLista(ListaDoble lista) {
		this.lista = lista;
	}
    
    public Principal() {    	
        setTitle("Listas");
        //setBounds(400,200,500,500);
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fondo = new JPanel();
        fondo.setBackground(new Color(255,255,255));
        fondo.setLayout(null);
        setContentPane(fondo);
        //add(fondo);

        jmb = new JMenuBar();
        jmb.setBorder(null);
        jmb.setBackground(new Color(0,0,0));
        jmb.setForeground(Color.white);
        setJMenuBar(jmb);

        ImageIcon temp = new ImageIcon("iconos/insertar.png");
        Icon ic = new ImageIcon(temp.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        
        jm_insertar = new JMenu("Insertar");
        jm_insertar.setFont(fuente);
        jm_insertar.setMnemonic(KeyEvent.VK_I);
        jm_insertar.setForeground(Color.white);
        jm_insertar.setIcon(ic);

        temp = new ImageIcon("iconos/opciones.png");
        ic = new ImageIcon(temp.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        
        jm_opc = new JMenu("Opciones...");
        jm_opc.setFont(fuente);
        jm_opc.setMnemonic(KeyEvent.VK_O);
        jm_opc.setForeground(Color.white);
        jm_opc.setIcon(ic);
        
        temp = new ImageIcon("iconos/eliminar.png");
        ic = new ImageIcon(temp.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        
        jm_eliminar = new JMenu("Eliminar");
        jm_eliminar.setFont(fuente);
        jm_eliminar.setMnemonic(KeyEvent.VK_E);
        jm_eliminar.setForeground(Color.white);
        jm_eliminar.setIcon(ic);
        
        jmb.add(jm_opc);
        jmb.add(jm_insertar);
        jmb.add(jm_eliminar);

        jmi_vacio = new JMenuItem("¿Lista vacia? (1)");
        jmi_vacio.setFont(f2);
        jmi_vacio.setMnemonic(KeyEvent.VK_1);
        jmi_vacio.setForeground(Color.white);
        jmi_vacio.setBackground(Color.black);
        jmi_vacio.addActionListener(this);

        jmi_imprimir = new JMenuItem("Imprimir lista en pantalla (2)");
        jmi_imprimir.setFont(f2);
        jmi_imprimir.setMnemonic(KeyEvent.VK_2);
        jmi_imprimir.setForeground(Color.white);
        jmi_imprimir.setBackground(Color.black);
        jmi_imprimir.addActionListener(this);

        jmi_salir = new JMenuItem("Salir (3)");
        jmi_salir.setFont(f2);
        jmi_salir.setMnemonic(KeyEvent.VK_3);
        jmi_salir.setForeground(Color.white);
        jmi_salir.setBackground(Color.black);

        JSeparator jjj = new JSeparator();
        jjj.setBackground(Color.black);
        JSeparator j2 = new JSeparator();
        j2.setBackground(Color.black);
        
        jm_opc.add(jmi_vacio);
        jm_opc.add(jjj);
        jm_opc.add(jmi_imprimir);
        jm_opc.add(j2);
        jm_opc.add(jmi_salir);

        jmi_Iadelante = new JMenuItem("Adelante (1)");
        jmi_Iadelante.setFont(f2);
        jmi_Iadelante.setMnemonic(KeyEvent.VK_1);
        jmi_Iadelante.setForeground(Color.white);
        jmi_Iadelante.setBackground(Color.black);
        jmi_Iadelante.addActionListener(this);

        jmi_Iatras = new JMenuItem("Atras (2)");
        jmi_Iatras.setFont(f2);
        jmi_Iatras.setMnemonic(KeyEvent.VK_2);
        jmi_Iatras.setForeground(Color.white);
        jmi_Iatras.setBackground(Color.black);
        jmi_Iatras.addActionListener(this);

        jm_insertar.add(jmi_Iadelante);
        jm_insertar.add(jmi_Iatras);
        
        jmi_ePrim = new JMenuItem("Primer nodo (1)");
        jmi_ePrim.setFont(f2);
        jmi_ePrim.setMnemonic(KeyEvent.VK_1);
        jmi_ePrim.setForeground(Color.WHITE);
        jmi_ePrim.setBackground(Color.black);
        jmi_ePrim.addActionListener(this);
        
        jm_eliminar.add(jmi_ePrim);

        pnl_imp = new JPanel();
        pnl_imp.setBorder(BorderFactory.createTitledBorder("Lista actual"));
        pnl_imp.setLayout(null);
        pnl_imp.setBounds(25, 25, 440, 380);
        pnl_imp.setBackground(new Color(255,255,255));
        pnl_imp.setVisible(true);      

        ta_res = new JTextArea();
        ta_res.setFont(f2);
        ta_res.setEditable(false);

        js = new JScrollPane(ta_res);
        js.setBounds(20,20,400,325);
        pnl_imp.add(js);
        
        pnl_Iadelante = new JPanel();
        pnl_Iadelante.setBorder(BorderFactory.createTitledBorder("Insertar adelante"));
        pnl_Iadelante.setLayout(null);
        pnl_Iadelante.setBounds(25, 25, 440, 380);
        pnl_Iadelante.setBackground(new Color(255,255,255));
        pnl_Iadelante.setVisible(false);
        
        pnl_Iatras = new JPanel();
        pnl_Iatras.setBorder(BorderFactory.createTitledBorder("Insertar atras"));
        pnl_Iatras.setLayout(null);
        pnl_Iatras.setBounds(25, 25, 440, 380);
        pnl_Iatras.setBackground(new Color(255,255,255));
        pnl_Iatras.setVisible(false);
        
        //pnl_elimP = new JPanel();
        
        for(int i=0;i<2;i++) {
        	lbl_id[i] = new JLabel("id:");
        	lbl_id[i].setFont(fuente);
        	lbl_id[i].setBounds(25,50,150,25);
        	
            lbl_nombre[i] = new JLabel("Nombre:");
            lbl_nombre[i].setFont(fuente);
            lbl_nombre[i].setBounds(25,100,150,25);

            lbl_artista[i] = new JLabel("Artista:");
            lbl_artista[i].setFont(fuente);
            lbl_artista[i].setBounds(25,150,150,25);

            lbl_album[i] = new JLabel("Álbum:");
            lbl_album[i].setFont(fuente);
            lbl_album[i].setBounds(25,200,150,25);

            lbl_genero[i] = new JLabel("Género:");
            lbl_genero[i].setFont(fuente);
            lbl_genero[i].setBounds(25,250, 150,25);

            tf_id[i] = new JTextField();
            tf_id[i].setFont(fuente);
            tf_id[i].setBounds(150,50,250,25);

            tf_nom[i] = new JTextField();
            tf_nom[i].setFont(fuente);
            tf_nom[i].setBounds(150,100,250,25);

            tf_art[i] = new JTextField();
            tf_art[i].setFont(fuente);
            tf_art[i].setBounds(150,150,250,25);

            tf_alb[i] = new JTextField();
            tf_alb[i].setFont(fuente);
            tf_alb[i].setBounds(150,200,250,25);

            tf_gen[i] = new JTextField();
            tf_gen[i].setFont(fuente);
            tf_gen[i].setBounds(150,250,250,25);
            
            btn_aceptar[i] = new JButton("Insertar");
            btn_aceptar[i].setBounds(115,300,100,25);
            btn_aceptar[i].setFont(fuente);
            btn_aceptar[i].addActionListener(this);

            btn_cancelar[i] = new JButton("Cancelar");
            btn_cancelar[i].setFont(fuente);
            btn_cancelar[i].setBounds(235,300,100,25);
            btn_cancelar[i].addActionListener(this);
        }
        
        pnl_Iadelante.add(lbl_id[0]);
        pnl_Iadelante.add(lbl_nombre[0]);
        pnl_Iadelante.add(lbl_artista[0]);
        pnl_Iadelante.add(lbl_album[0]);
        pnl_Iadelante.add(lbl_genero[0]);
        pnl_Iadelante.add(tf_id[0]);
        pnl_Iadelante.add(tf_nom[0]);
        pnl_Iadelante.add(tf_art[0]);
        pnl_Iadelante.add(tf_alb[0]);
        pnl_Iadelante.add(tf_gen[0]);
        pnl_Iadelante.add(btn_aceptar[0]);
        pnl_Iadelante.add(btn_cancelar[0]);
        
        pnl_Iatras.add(lbl_id[1]);
        pnl_Iatras.add(lbl_nombre[1]);
        pnl_Iatras.add(lbl_artista[1]);
        pnl_Iatras.add(lbl_album[1]);
        pnl_Iatras.add(lbl_genero[1]);
        pnl_Iatras.add(tf_id[1]);
        pnl_Iatras.add(tf_nom[1]);
        pnl_Iatras.add(tf_art[1]);
        pnl_Iatras.add(tf_alb[1]);
        pnl_Iatras.add(tf_gen[1]);
        pnl_Iatras.add(btn_aceptar[1]);
        pnl_Iatras.add(btn_cancelar[1]);
        
        fondo.add(pnl_imp);
        fondo.add(pnl_Iadelante);  
        fondo.add(pnl_Iatras);
        //card.show(fondo, "1");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean ingr = false;
    	if(e.getSource()== jmi_vacio) {
            if(this.lista.isVacio())
                JOptionPane.showMessageDialog(null,"La lista esta vacía");
            else
                JOptionPane.showMessageDialog(null,"La lista no esta vacía");
        }
        else if(e.getSource()==jmi_Iadelante) {
        	pnl_imp.setVisible(false);
        	pnl_Iadelante.setVisible(true);
        	pnl_Iatras.setVisible(false);

        	/*InsAdelante ib = new InsAdelante();
        	ib.setVisible(true);*/
        }
        else if(e.getSource()==jmi_imprimir) {
            pnl_imp.setVisible(true);
            pnl_Iadelante.setVisible(false);
            pnl_Iatras.setVisible(false);           
            String imp = this.lista.imprimir().toString();
            ta_res.setText(imp);
            
        } else if(e.getSource() == jmi_Iatras) {
        	pnl_Iatras.setVisible(true);
        	pnl_imp.setVisible(false);
            pnl_Iadelante.setVisible(false);
        } else if(e.getSource()==jmi_ePrim) {
        	if(this.lista.isVacio())
        		JOptionPane.showMessageDialog(null, "No hay nodo que eliminar");
        	else {
        		int res = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el primer nodo?", "Atencion!", JOptionPane.INFORMATION_MESSAGE);
        		if(res==0) {
        			this.lista.eliminarPrimero();
        			JOptionPane.showMessageDialog(null, "Nodo eliminado");
        			String imp = this.lista.imprimir().toString();
        			ta_res.setText(imp);
        			pnl_Iatras.setVisible(false);
        			pnl_imp.setVisible(true);
        			pnl_Iadelante.setVisible(false);
        		}
        	}
        	
        	
        	
        } else if(e.getSource() == jmi_salir)
        	System.exit(0);
        
        
        if(e.getSource()==btn_cancelar[0]) {
        	pnl_Iadelante.setVisible(false);
        }
        else if(e.getSource()==btn_aceptar[0]) {
        	Musica mus = new Musica();
        	pnl_Iadelante.setVisible(false);
        	
        	id = tf_id[0].getText();
            cancion = tf_nom[0].getText();
            artista = tf_art[0].getText();
            album = tf_alb[0].getText();
            genero = tf_gen[0].getText();
            
            mus.setId(id);
            mus.setCancion(cancion);
            mus.setArtista(artista);
            mus.setAlbum(album);
            mus.setGenero(genero);
            
            if(this.lista.insertarAdelante(mus))
            	JOptionPane.showMessageDialog(null,"Se ingresaron los datos", "Atención",JOptionPane.INFORMATION_MESSAGE);
            //pnl_Iadelante.setVisible(false);
            tf_gen[0].setText("");
            tf_alb[0].setText("");
            tf_art[0].setText("");
            tf_nom[0].setText("");
            tf_id[0].setText("");
        }
        else if(e.getSource()==btn_aceptar[1]) {
        	Musica mus = new Musica();
        	pnl_Iatras.setVisible(false);
        	id = tf_id[1].getText();
            cancion = tf_nom[1].getText();
            artista = tf_art[1].getText();
            album = tf_alb[1].getText();
            genero = tf_gen[1].getText();
            
            mus.setId(id);
            mus.setCancion(cancion);
            mus.setArtista(artista);
            mus.setAlbum(album);
            mus.setGenero(genero);
            
            if(this.lista.insertarAntes(mus))
            	JOptionPane.showMessageDialog(null,"Se ingresaron los datos", "Atención",JOptionPane.INFORMATION_MESSAGE);
            
            tf_gen[1].setText("");
            tf_alb[1].setText("");
            tf_art[1].setText("");
            tf_nom[1].setText("");
            tf_id[1].setText("");
        }
        
    }

	public static void main(String[] args) {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeCoffeeSkin");
		
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	/*try {
            		UIManager.setLookAndFeel(new SubstanceMarinerLookAndFeel());
                  } catch (Exception e) {
                    System.out.println("Substance Graphite failed to initialize");
                  }
            	
            	*/
            	Principal pr = new Principal();
                pr.setVisible(true);
            }
        });
    }
}
