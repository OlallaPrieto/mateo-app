package icai.dtc.isw.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class pantallaRegistroTest {

    @Test
    public void testContrasenasIgualesConMismoTexto() {
        // Dos arrays distintos con el mismo contenido, como devuelve getPassword()
        assertTrue(pantallaRegistro.contrasenasIguales("hola1234".toCharArray(), "hola1234".toCharArray()));
    }

    @Test
    public void testContrasenasDistintas() {
        assertFalse(pantallaRegistro.contrasenasIguales("hola1234".toCharArray(), "hola9999".toCharArray()));
    }

    @Test
    public void testContrasenaVaciaNoVale() {
        assertFalse(pantallaRegistro.contrasenasIguales(new char[0], new char[0]));
    }
}
