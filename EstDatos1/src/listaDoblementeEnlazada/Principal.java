package listaDoblementeEnlazada;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.event.KeyEvent;

public class Principal extends JFrame implements ActionListener {
    public ListaDoble getLista() {
        return lista;
    }

    public void setLista(ListaDoble lista) {
        this.lista = lista;
    }

    private ListaDoble lista = new ListaDoble();

    private JMenuBar jmb;
    private JMenu jm_insertar,jm_eliminar, jm_recorrido, jm_opc;
    private JMenuItem jmi_Iadelante, jmi_Iatras, jmi_imprimir, jmi_salir, jmi_vacio;
    private JLabel fondo;
    private JLabel lbl_res;
    private JTextArea ta_res;

    private Font fuente = new Font("Tahoma", Font.PLAIN, 16);
    private Font f2 = new Font("Tahoma",Font.PLAIN,14);
    private Font fLog = new Font("",Font.PLAIN,14);

    public Principal() {
        setTitle("Listas");
        setBounds(400,200,500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fondo = new JLabel();
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

        jmi_vacio = new JMenuItem("¿Lista vacia? (1)");
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

        lbl_res = new JLabel("Lista Actual:");
        lbl_res.setBounds(50,50,200,25);
        lbl_res.setFont(f2);
        lbl_res.setVisible(false);
        fondo.add(lbl_res);

        ta_res = new JTextArea();
        ta_res.setFont(f2);
        ta_res.setBounds(0,0,400,325);
        ta_res.setVisible(false);
        ta_res.setEnabled(false);

        JScrollBar js = new JScrollBar();
        js.setBounds(50,75,400,325);
        js.add(ta_res);
        fondo.add(js);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Principal tld = new Principal();
        if(e.getSource()== jmi_vacio) {
            if(tld.lista.isVacio())
                JOptionPane.showMessageDialog(null,"La lista esta vacía");
            else
                JOptionPane.showMessageDialog(null,"La lista no esta vacía");
        }
        else if(e.getSource()==jmi_Iadelante) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InsAdelante ina = new InsAdelante(tld,tld.getLista());
                    ina.setVisible(true);
                }
            });
        }
        else if(e.getSource()==jmi_imprimir) {
            lbl_res.setVisible(true);
            String imp = tld.lista.imprimir().toString();
            ta_res.setText(imp);
            ta_res.setVisible(true);
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
