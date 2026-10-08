import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JVentana extends JFrame{
    private static final int ancho=390;
    private static final int alto=700;
    private JButton botonRegistrar;
    private JButton botonIniciar;
    private JPanel panelNorte;
    private JPanel panelSur;
    private Image logo;

    private JVentana(){
        setTitle("Proyecto Mateo");
        setSize(ancho,alto);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(new pantallaInicial(this)); //Establece pantallaIncial en ventana
        setVisible(true);
    }

    public int getAncho(){
        return this.ancho;
    }

    public static void main (String[] args){
        SwingUtilities.invokeLater(() -> new JVentana());
    }

}
