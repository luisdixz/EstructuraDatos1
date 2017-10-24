package listaDoblementeEnlazada;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;

import com.sun.glass.events.KeyEvent;

public class MenuPrincipal extends JFrame implements ActionListener {

	private ListaDoble lista = new ListaDoble();
	
	private JMenuBar jmb;
	private JMenu jm_opc, jm_ins, jm_elim, jm_rec;
	private JMenuItem jmi_vac, jmi_imp, jmi_sal, jmi_Iatras, jmi_Iadelante, jmi_Eprim, jmi_Eult, jmi_Radel, jmi_Ratr;
	private JPanel pnl_imp;
	private JButton btn_act1, btn_act2, btn_cambio1, btn_cambio2;
	private JTextArea ta_res;
	private JScrollPane js_imp;
	
	private static final String RAVEN = "org.pushingpixels.substance.api.skin.RavenSkin";
	private static final String CREME = "org.pushingpixels.substance.api.skin.CremeSkin";
	
    private Font fuente = new Font("Calibri", Font.PLAIN, 16);
    private Font f2 = new Font("Calibri",Font.PLAIN,14);
    private Font fLog = new Font("",Font.PLAIN,14);
	
	public MenuPrincipal() {
		setTitle("Listas doblemente enlazadas");
		setSize(620,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		jmb = new JMenuBar();
		setJMenuBar(jmb);
		
		jm_opc = new JMenu("Opciones");
		jm_opc.setMnemonic(KeyEvent.VK_O);
		jm_opc.setFont(fuente);
		
		jm_ins = new JMenu("Insertar");
		jm_ins.setMnemonic(KeyEvent.VK_I);
		jm_ins.setFont(fuente);
		
		jm_elim = new JMenu("Eliminar");
		jm_elim.setMnemonic(KeyEvent.VK_E);
		jm_elim.setFont(fuente);
		
		jm_rec = new JMenu("Recorrer");
		jm_rec.setMnemonic(KeyEvent.VK_E);
		jm_rec.setFont(fuente);
		
		jmb.add(jm_opc);
		jmb.add(jm_ins);
		jmb.add(jm_elim);
		jmb.add(jm_rec);
		//jmb.add(jm_imp);
		
		jmi_vac = new JMenuItem("¿Lista vacía? (1)");
		jmi_vac.setMnemonic(KeyEvent.VK_1);
		jmi_vac.setFont(f2);
		jmi_vac.addActionListener(this);
		
		/*jmi_imp = new JMenuItem("Imprimir lista (2)");
		jmi_imp.setMnemonic(KeyEvent.VK_2);
		jmi_imp.setFont(f2);
		jmi_imp.addActionListener(this);*/
		
		jmi_sal = new JMenuItem("Salir (2)");
		jmi_sal.setMnemonic(KeyEvent.VK_2);
		jmi_sal.setFont(f2);
		jmi_sal.addActionListener(this);
		
		jm_opc.add(jmi_vac);
		//jm_opc.add(jmi_imp);
		jm_opc.add(jmi_sal);
		
		jmi_Eprim = new JMenuItem("Primer nodo (1)");
		jmi_Eprim.setMnemonic(KeyEvent.VK_1);
		jmi_Eprim.setFont(f2);
		jmi_Eprim.addActionListener(this);
		
		jmi_Eult = new JMenuItem("Último nodo (2)");
		jmi_Eult.setMnemonic(KeyEvent.VK_2);
		jmi_Eult.setFont(f2);
		jmi_Eult.addActionListener(this);
		
		jm_elim.add(jmi_Eprim);
		jm_elim.add(jmi_Eult);
		
		
		jmi_Iadelante = new JMenuItem("Adelante (1)");
		jmi_Iadelante.setMnemonic(KeyEvent.VK_1);
		jmi_Iadelante.setFont(f2);
		jmi_Iadelante.addActionListener(this);
		
		jmi_Iatras = new JMenuItem("Atras(2)");
		jmi_Iatras.setMnemonic(KeyEvent.VK_2);
		jmi_Iatras.setFont(f2);
		jmi_Iatras.addActionListener(this);
		
		jm_ins.add(jmi_Iadelante);
		jm_ins.add(jmi_Iatras);
		
		jmi_Radel = new JMenuItem("Hacia adelante (1)");
		jmi_Radel.setMnemonic(KeyEvent.VK_1);
		jmi_Radel.setFont(f2);
		jmi_Radel.addActionListener(this);
		
		jmi_Ratr = new JMenuItem("Hacia atras (2)");
		jmi_Ratr.setMnemonic(KeyEvent.VK_2);
		jmi_Ratr.setFont(f2);
		jmi_Ratr.addActionListener(this);
		
		jm_rec.add(jmi_Radel);
		jm_rec.add(jmi_Ratr);
		
		pnl_imp = new JPanel();
		pnl_imp.setBorder(BorderFactory.createTitledBorder("Lista actual"));
		pnl_imp.setFont(f2);
		pnl_imp.setBounds(10, 10, 580, 415);
		pnl_imp.setLayout(null);
		pnl_imp.setVisible(false);
		add(pnl_imp);
		
		ta_res = new JTextArea();
		ta_res.setFont(f2);
		//ta_res.setBounds(10, 10, 500, 500);
		ta_res.setEditable(false);
		
		js_imp = new JScrollPane(ta_res);
		js_imp.setBounds(25, 50, 530, 340);
		pnl_imp.add(js_imp);
		
		btn_act1 = new JButton("Actualizar lista");
		btn_act1.setBounds(25, 25, 265, 25);
		btn_act1.setFont(f2);
		btn_act1.addActionListener(this);
		btn_act1.setVisible(false);
		pnl_imp.add(btn_act1);
		
		btn_act2 = new JButton("Actualizar lista");
		btn_act2.setBounds(25, 25, 265, 25);
		btn_act2.setFont(f2);
		btn_act2.addActionListener(this);
		btn_act2.setVisible(false);
		pnl_imp.add(btn_act2);
		
		btn_cambio1 = new JButton("Cambiar sentido (hacia atras)");
		btn_cambio1.setBounds(290, 25, 265, 25);
		btn_cambio1.setFont(f2);
		btn_cambio1.addActionListener(this);
		btn_cambio1.setVisible(false);
		pnl_imp.add(btn_cambio1);
		
		btn_cambio2 = new JButton("Cambiar sentido (hacia adelante)");
		btn_cambio2.setBounds(290, 25, 265, 25);
		btn_cambio2.setFont(f2);
		btn_cambio2.addActionListener(this);
		btn_cambio2.setVisible(false);
		pnl_imp.add(btn_cambio2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_act1) {
			String imp = this.lista.recAdelante().toString();
			ta_res.setText(imp);
			if(this.lista.isVacio()) 
				JOptionPane.showMessageDialog(null, "La lista esta vacía, no hay nada que imprimir", "Atencion", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==btn_act2) {
			String imp = this.lista.recAtras().toString();
			ta_res.setText(imp);
			if(this.lista.isVacio()) 
				JOptionPane.showMessageDialog(null, "La lista esta vacía, no hay nada que imprimir", "Atencion", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==btn_cambio1) {
			btn_cambio1.setVisible(false);
			btn_act1.setVisible(false);
			btn_cambio2.setVisible(true);
			btn_act2.setVisible(true);
			
			String imp = this.lista.recAtras().toString();
			ta_res.setText(imp);
			if(this.lista.isVacio()) 
				JOptionPane.showMessageDialog(null, "La lista esta vacía, no hay nada que imprimir", "Atencion", JOptionPane.INFORMATION_MESSAGE);
			
		}
		if(e.getSource()==btn_cambio2) {
			btn_cambio2.setVisible(false);
			btn_act2.setVisible(false);
			btn_cambio1.setVisible(true);
			btn_act1.setVisible(true);
			
			String imp = this.lista.recAdelante().toString();
			ta_res.setText(imp);
			if(this.lista.isVacio()) 
				JOptionPane.showMessageDialog(null, "La lista esta vacía, no hay nada que imprimir", "Atencion", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getSource()==jmi_Radel) {
			if(this.lista.isVacio()) 
				JOptionPane.showMessageDialog(null, "La lista esta vacía, no hay nada que imprimir", "Atencion", JOptionPane.INFORMATION_MESSAGE);
			else {
				btn_act1.setVisible(true);
				btn_act2.setVisible(false);
				btn_cambio1.setVisible(true);
				btn_cambio2.setVisible(false);
				String imp = this.lista.recAdelante().toString();
				ta_res.setText(imp);
				pnl_imp.setVisible(true);
			}
		}
		if(e.getSource()==jmi_Ratr) {
			if(this.lista.isVacio()) 
				JOptionPane.showMessageDialog(null, "La lista esta vacía, no hay nada que imprimir", "Atencion", JOptionPane.INFORMATION_MESSAGE);
			else {
				btn_act2.setVisible(true);
				btn_act1.setVisible(false);
				btn_cambio1.setVisible(false);
				btn_cambio2.setVisible(true);
				String imp = this.lista.recAtras().toString();
				ta_res.setText(imp);
				pnl_imp.setVisible(true);
			}
		}
		if(e.getSource()==jmi_vac) {
			if(this.lista.isVacio()) 
				JOptionPane.showMessageDialog(null, "La lista esta vacía", "Atención",JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "La lista no esta vacía", "Atención",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi_Iadelante) {
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					InsertarNodo iadel = new InsertarNodo(lista, 1);
					iadel.setVisible(true);
				}
			});
		}
		if(e.getSource()==jmi_Iatras) {
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					InsertarNodo iadel = new InsertarNodo(lista, 2);
					iadel.setVisible(true);
				}
			});
		}
		if(e.getSource()==jmi_Eprim) {
			if(this.lista.isVacio())
				JOptionPane.showMessageDialog(null, "La lista esta vacía, no hay nada que eliminar", "Lista vacía", JOptionPane.ERROR_MESSAGE);
			else {
				int res = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el siguiente nodo?\n" 
						, "Eliminar primer nodo", JOptionPane.WARNING_MESSAGE);
				if(this.lista.eliminarPrimero(res))
					JOptionPane.showMessageDialog(null, "Nodo eliminado", "Atencion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getSource()==jmi_Eult) {
			if(this.lista.isVacio())
				JOptionPane.showMessageDialog(null, "La lista esta vacía, no hay nada que eliminar", "Lista vacía", JOptionPane.ERROR_MESSAGE);
			else {
				int res = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el siguiente nodo?\n" 
						, "Eliminar ultimo nodo", JOptionPane.WARNING_MESSAGE);
				if(this.lista.eliminarUltimo(res))
					JOptionPane.showMessageDialog(null, "Nodo eliminado", "Atencion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if(e.getSource()==jmi_sal)
			System.exit(0);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				SubstanceLookAndFeel.setSkin(CREME);
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
			}
			
		});
	}

}
