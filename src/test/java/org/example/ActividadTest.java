package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ActividadTest {

    private static Actividad actividad;

    @BeforeAll
    static void setUp() {
        actividad = new Actividad("Palmas con rima", "rima", 6, 18);
    }

    @Test
    void getTitulo() {
        assertEquals("Palmas con rima", actividad.getTitulo());
    }

    @Test
    void getTipo() {
        assertEquals("rima", actividad.getTipo());
    }

    @Test
    void esAptaParaEdad() {
        assertTrue(actividad.esAptaParaEdad(12));
        assertFalse(actividad.esAptaParaEdad(30));
    }
}