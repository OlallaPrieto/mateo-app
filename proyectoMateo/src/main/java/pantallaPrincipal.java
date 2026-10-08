import java.awt.*;
import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class pantallaPrincipal extends JPanel implements ActionListener{
    private pantallaDentro dentro;

    private JPanel panelNorte;
    private JPanel panelCentro;

    private JButton botonRimas;
    private JButton botonJuegos;
    private JButton botonRetahilas;

    private JLabel tituloSaludo;

    public pantallaPrincipal(pantallaDentro dentro){
        this.dentro = dentro;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initComponents();
    }

    public void initComponents(){
        configPaneles();

        //panel norte
        tituloSaludo = new JLabel("Hola, ----!");  //la idea es aqui llamar a la base datos y sacar el nombre
        tituloSaludo.setFont(new Font("Comic Sans", Font.BOLD, 24));
        tituloSaludo.setForeground(Color.BLACK);

        panelNorte.add(tituloSaludo);

        //panel centro
        botonRetahilas = crearBotonAzul("Retahílas", panelCentro);
        botonRimas = crearBotonAzul("Rimas", panelCentro);
        botonJuegos = crearBotonAzul("Juegos", panelCentro);

        //añadir paneles a pantalla
        add(panelNorte,BorderLayout.NORTH);
        add(panelCentro,BorderLayout.CENTER);
    }

    public void configPaneles(){
        //panel norte - imagen + titulo
        panelNorte=new JPanel(new BorderLayout());
        panelNorte.setBackground(Color.WHITE);
        panelNorte.setPreferredSize(new Dimension(390,140));

        //panel centro - tres botones grandes
        panelCentro = new JPanel();
        panelCentro.setBackground(Color.WHITE);
        panelCentro.setLayout(new GridLayout(3,1,0,20));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));
    }

    public JButton crearBoton(String texto, JPanel panel){
        JButton boton= new JButton(texto);
        boton.addActionListener(this);
        panel.add(boton);
        return boton;
    }

    public JButton crearBotonAzul(String texto, JPanel panel){
        JButton boton= new JButton(texto);
        boton.addActionListener(this);
        boton.setBackground(new Color(181,199,235));
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        panel.add(boton);
        return boton;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == botonRimas){
            dentro.cambiarSeccion("rimas");
        }if (e.getSource() == botonJuegos){
            dentro.cambiarSeccion("juegos");
        }if (e.getSource() == botonRetahilas){
            dentro.cambiarSeccion("retahilas");
        }
    }
}
