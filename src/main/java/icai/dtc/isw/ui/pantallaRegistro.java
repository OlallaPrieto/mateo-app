package icai.dtc.isw.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.HashMap;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.configuration.Seguridad;

public class pantallaRegistro extends JPanel implements ActionListener{

    private JVentana ventana;

    private JPanel panelNorte; //para titulo "inicio de sesion"
    private JPanel panelCentro; //para textfields
    private JPanel panelSur; //para boton continuar

    private JButton continuar;
    private JButton volver;

    private JTextField nombre;
    private JTextField mail;
    private JPasswordField contrasena;
    private JPasswordField confirmarContrasena;

    public pantallaRegistro(JVentana ventana) {
        this.ventana = ventana;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initComponents();
    }

    public void initComponents(){
        configPaneles();

        //campos del login
        nombre = new JTextField(20);
        panelCentro.add(new JLabel("Nombre:"));
        panelCentro.add(nombre);

        mail = new JTextField(20);
        panelCentro.add(new JLabel("Correo electrónico:"));
        panelCentro.add(mail);

        contrasena = new JPasswordField(20);
        panelCentro.add(new JLabel("Contraseña:"));
        panelCentro.add(contrasena);

        confirmarContrasena = new JPasswordField(20);
        panelCentro.add(new JLabel("Confirmar contraseña:"));
        panelCentro.add(confirmarContrasena);

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

        JLabel titulo = new JLabel("REGISTRARSE");
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(Color.BLACK);

        panelNorte.add(titulo);

        //panel centro - nombre, email y contraseña
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
            if (nombre.getText().isBlank() || mail.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "Rellena el nombre y el correo");
            }else if (!comprobacionesRegistroValido()){
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
            }else if (registrar()){
                JOptionPane.showMessageDialog(this, "Registro completado. Ya puedes iniciar sesión");
                ventana.cambiarPantalla("login");
            }else{
                JOptionPane.showMessageDialog(this, "No se ha podido registrar: ese correo ya existe");
            }
        }if (e.getSource() == volver) {
            ventana.cambiarPantalla("inicial");
        }
    }

    public boolean comprobarIgualdadContrasenas(){
        char[] psswd1 = contrasena.getPassword();
        char[] psswd2 = confirmarContrasena.getPassword();
        return contrasenasIguales(psswd1, psswd2);
    }

    // con == se comparan los objetos, no el texto: hay que usar Arrays.equals
    public static boolean contrasenasIguales(char[] psswd1, char[] psswd2){
        return psswd1.length > 0 && Arrays.equals(psswd1, psswd2);
    }

    // manda el usuario al servidor, que lo guarda en la tabla usuarios
    public boolean registrar(){
        Client cliente = new Client();
        HashMap<String,Object> session = new HashMap<>();
        session.put("nombre", nombre.getText().trim());
        session.put("correo", mail.getText().trim());
        session.put("contrasena", Seguridad.cifrar(new String(contrasena.getPassword())));
        session = cliente.sentMessage("/registrar", session);
        return Boolean.TRUE.equals(session.get("ok"));
    }

    public boolean comprobacionesRegistroValido(){
        boolean check1 =comprobarIgualdadContrasenas();
        // añadir los checks necesarios: mail no usado antes...
        if (check1){  //aqui comprobar todos los checks true
            return true;
        }else{
            return false;
        }
    }
}
