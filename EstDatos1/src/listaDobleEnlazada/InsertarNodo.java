package listaDobleEnlazada;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertarNodo extends JFrame implements ActionListener {

	private ListaDoble lista;
	private int opcion;
	
	private JTextField tf_id, tf_nom, tf_art, tf_alb, tf_gen;
	private JLabel lbl_id, lbl_nom, lbl_art, lbl_alb, lbl_gen;
	private JButton btn_aceptar, btn_cancelar;
	
    private Font fuente = new Font("Calibri", Font.PLAIN, 16);
    private Font f2 = new Font("Calibri",Font.PLAIN,14);
    private Font fLog = new Font("",Font.PLAIN,14);
	
	public InsertarNodo(ListaDoble lis, int res) {
		this.lista=lis;
		this.opcion=res;
		
		setTitle("Insertar nodo adelante");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		lbl_id= new JLabel("ID:");
		lbl_id.setFont(fuente);
		lbl_id.setBounds(50, 50, 150, 25);
		
		lbl_nom = new JLabel("Cancion:");
		lbl_nom.setFont(fuente);
		lbl_nom.setBounds(50, 100, 150, 25);
		
		lbl_art = new JLabel("Artista:");
		lbl_art.setFont(fuente);
		lbl_art.setBounds(50, 150, 150, 25);
		
		lbl_alb = new JLabel("Álbum:");
		lbl_alb.setFont(fuente);
		lbl_alb.setBounds(50, 200, 150, 25);
		
		lbl_gen = new JLabel("Género:");
		lbl_gen.setFont(fuente);
		lbl_gen.setBounds(50, 250, 150, 25);
		
		add(lbl_id);
		add(lbl_nom);
		add(lbl_art);
		add(lbl_alb);
		add(lbl_gen);
		
		tf_id = new JTextField();
		tf_id.setFont(f2);
		tf_id.setBounds(200, 50, 220, 25);
		
		tf_nom = new JTextField();
		tf_nom.setFont(f2);
		tf_nom.setBounds(200, 100, 220, 25);
		
		tf_art = new JTextField();
		tf_art.setFont(f2);
		tf_art.setBounds(200, 150, 220, 25);
		
		tf_alb = new JTextField();
		tf_alb.setFont(f2);
		tf_alb.setBounds(200, 200, 220, 25);
		
		tf_gen = new JTextField();
		tf_gen.setFont(f2);
		tf_gen.setBounds(200, 250, 220, 25);
		
		add(tf_id);
		add(tf_nom);
		add(tf_art);
		add(tf_alb);
		add(tf_gen);
		
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setFont(f2);
		btn_aceptar.setBounds(125, 350, 100, 25);
		btn_aceptar.addActionListener(this);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setFont(f2);
		btn_cancelar.setBounds(250, 350, 100, 25);
		btn_cancelar.addActionListener(this);
		
		add(btn_aceptar);
		add(btn_cancelar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_aceptar) {
			Musica mus = new Musica();
			mus.setId(tf_id.getText());
			mus.setCancion(tf_nom.getText());
			mus.setArtista(tf_art.getText());
			mus.setAlbum(tf_alb.getText());
			mus.setGenero(tf_gen.getText());
			if(opcion ==1) {
				if(lista.insertarAdelante(mus)) {
					JOptionPane.showMessageDialog(null, "Nodo insertado", "Atencion", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			} else {
				if(lista.insertarAtras(mus)) {
					JOptionPane.showMessageDialog(null, "Nodo insertado", "Atencion", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
		}
	}

}
