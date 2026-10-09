package icai.dtc.isw.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class pantallaInicial extends JPanel implements ActionListener{
    private JVentana ventana;

    private JButton botonRegistrar;
    private JButton botonIniciar;

    private JPanel panelNorte;
    private JPanel panelSur;

    private Image logo;

    public pantallaInicial(JVentana ventana){
        this.ventana=ventana;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initComponents();
    }

    public void initComponents(){
        configPaneles();
        logo=new ImageIcon(getClass().getResource("/images/logo.png")).getImage();;
        botonIniciar=crearBoton("Iniciar Sesion",panelSur);
        botonRegistrar=crearBoton("Registrarse",panelSur);
        add(panelNorte,BorderLayout.NORTH);
        add(panelSur,BorderLayout.CENTER);
    }

    public void configPaneles(){
        panelNorte=new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(logo,45,150,300,250,this);
            }
        };
        panelNorte.setBackground(Color.WHITE);
        panelNorte.setPreferredSize(new Dimension(ventana.getAncho(),550));
        panelSur=new JPanel();
        panelSur.setBackground(Color.WHITE);
    }

    public JButton crearBoton(String texto, JPanel panel){
        JButton boton= new JButton(texto);
        boton.addActionListener(this);
        panel.add(boton);
        return boton;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == botonIniciar) {
            ventana.cambiarPantalla("login");
        }if (e.getSource() == botonRegistrar) {
            ventana.cambiarPantalla("registro");
        }
    }
}
