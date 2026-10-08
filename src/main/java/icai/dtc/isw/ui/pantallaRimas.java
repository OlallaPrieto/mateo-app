package icai.dtc.isw.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pantallaRimas extends JPanel{
    private JVentana ventana;

    public pantallaRimas(JVentana ventana){
        this.ventana = ventana;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
    }
}
