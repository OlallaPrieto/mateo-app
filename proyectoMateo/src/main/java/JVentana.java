import javax.swing.*;
import java.awt.*;

public class JVentana extends JFrame{

    private static final int ANCHO=390;
    private static final int ALTO=700;

    private CardLayout cardLayout;
    private JPanel contenedor;

    private JVentana(){
        setTitle("Proyecto Mateo");
        setSize(ANCHO,ALTO);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        //Layout para cambiar entre pantallas
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        //Crear pantallas
        contenedor.add(new pantallaInicial(this), "inicial");
        contenedor.add(new pantallaLogin(this), "login");
        contenedor.add(new pantallaRegistro(this), "registro");

        //mas tarde metemos la principal
        setContentPane(contenedor);
        cardLayout.show(contenedor,"inicial");

        setVisible(true);
    }

    public int getAncho(){
        return this.ANCHO;
    }

    public void cambiarPantalla(String nombre){
        cardLayout.show(contenedor, nombre);
    }

    public static void main (String[] args){
        SwingUtilities.invokeLater(() -> new JVentana());
    }

}
