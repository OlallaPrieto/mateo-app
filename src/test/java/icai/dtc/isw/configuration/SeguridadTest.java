package icai.dtc.isw.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeguridadTest {

    @Test
    public void testCifrarDaElSha256Conocido() {
        // Valor de referencia de SHA-256 para "abc"
        assertEquals("ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad",
                Seguridad.cifrar("abc"));
    }

    @Test
    public void testCifrarNoGuardaLaContrasenaEnClaro() {
        String cifrada = Seguridad.cifrar("hola1234");
        assertNotEquals("hola1234", cifrada);
        assertEquals(64, cifrada.length());
    }

    @Test
    public void testCifrarMismaContrasenaDaMismoResultado() {
        assertEquals(Seguridad.cifrar("hola1234"), Seguridad.cifrar("hola1234"));
    }
}
