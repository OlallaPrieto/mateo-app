import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLOutput;

public class pantallaLogin extends JPanel implements ActionListener{

    private JVentana ventana;

    private JPanel panelNorte; //para titulo "inicio de sesion"
    private JPanel panelCentro; //para textfields
    private JPanel panelSur; //para boton continuar

    private JButton olvidoContrasena;

    private JButton continuar;
    private JButton volver;

    private JTextField mail;
    private JPasswordField contrasena;

    public pantallaLogin(JVentana ventana) {
        this.ventana = ventana;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initComponents();
    }

    public void initComponents(){
        configPaneles();

        //campos del login
        mail = new JTextField(20);
        panelCentro.add(new JLabel("Correo electrónico"));
        panelCentro.add(mail);

        contrasena = new JPasswordField(20);
        panelCentro.add(new JLabel("Contraseña"));
        panelCentro.add(contrasena);

        olvidoContrasena = crearBoton("Has olvidado tu contraseña?",panelCentro);

        continuar = crearBoton("Continuar",panelSur);
        volver = crearBoton("Volver", panelSur);

        //añadir paneles a pantalla
        add(panelNorte,BorderLayout.NORTH);
        add(panelCentro,BorderLayout.CENTER);
        add(panelSur,BorderLayout.SOUTH);
    }

    public void configPaneles(){
        //panel norte - titulo
        panelNorte=new JPanel();
        panelNorte.setBackground(Color.WHITE);
        panelNorte.setPreferredSize(new Dimension(390,180));
        panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER,0,60));

        JLabel titulo = new JLabel("INICIAR SESIÓN");
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(Color.BLACK);

        panelNorte.add(titulo);

        //panel centro - mail y contraseña
        panelCentro = new JPanel();
        panelCentro.setBackground(Color.WHITE);
        panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER));

        //panel sur - continuar o volver
        panelSur=new JPanel();
        panelSur.setBackground(Color.WHITE);
        panelSur.setPreferredSize(new Dimension(390, 150));
        panelSur.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    public JButton crearBoton(String texto, JPanel panel){
        JButton boton= new JButton(texto);
        boton.addActionListener(this);
        panel.add(boton);
        return boton;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == continuar){
            //hay que chequear que coincide mail con contraseña en BD
            //cambiariamos a pantalla principal si esta bien sino ERROR TRY AGAIN
            System.out.println("Contunar");
        }if (e.getSource() == volver) {
            ventana.cambiarPantalla("inicial");
            System.out.println("volver a inicio");
        }if (e.getSource() == olvidoContrasena){
            //todavia no se como gestionar esto, mandar un mail al que han escrito y que confirme desde ahi pero se nos va de las manos
        }
    }
}
