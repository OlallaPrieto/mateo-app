package icai.dtc.isw.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pantallaDentro extends JPanel implements ActionListener{

    private JVentana ventana;
    private CardLayout cardContenido;

    private JButton botonInicio;
    private JButton botonAprender;
    private JButton botonAvisos;
    private JButton botonPerfil;

    private JPanel panelContenido;
    private JPanel panelSur;

    public pantallaDentro(JVentana ventana){
        this.ventana = ventana;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initComponents();
        cambiarSeccion("principal");

    }

    public void initComponents(){
        configPaneles();
        panelContenido.add(new pantallaPrincipal(this), "principal");

        //botones de barra fija
        botonInicio = crearBotonAmarillo("Inicio", panelSur);
        botonAprender = crearBotonAmarillo("Aprender", panelSur);
        botonAvisos = crearBotonAmarillo("Avisos", panelSur);
        botonPerfil = crearBotonAmarillo("Perfil", panelSur);

        //añadir paneles
        add(panelContenido, BorderLayout.CENTER);
        add(panelSur,BorderLayout.SOUTH);
    }

    public void configPaneles(){
        cardContenido = new CardLayout();
        panelContenido = new JPanel(cardContenido);

        //barra sur fija
        panelSur=new JPanel();
        panelSur.setBackground(Color.WHITE);
        panelSur.setPreferredSize(new Dimension(390, 90));
        panelSur.setLayout(new GridLayout(1,4,0,0));
    }

    public JButton crearBotonAmarillo(String texto, JPanel panel){
        JButton boton= new JButton(texto);
        boton.addActionListener(this);
        boton.setBackground(new Color(255,238,140));
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        panel.add(boton);
        return boton;
    }

    public void cambiarSeccion(String nombre) {
        cardContenido.show(panelContenido, nombre);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonInicio) {
            cambiarSeccion("principal");
        }
    }
}
