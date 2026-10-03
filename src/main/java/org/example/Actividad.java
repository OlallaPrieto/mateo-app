package org.example;

public class Actividad {
    private final String titulo;
    private final String tipo; // juego, rima, actividad
    private final int edadMinMeses;
    private final int edadMaxMeses;

    public Actividad(String titulo, String tipo, int edadMinMeses, int edadMaxMeses) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.edadMinMeses = edadMinMeses;
        this.edadMaxMeses = edadMaxMeses;
    }

    public String getTitulo() { return titulo; }
    public String getTipo() { return tipo; }

    public boolean esAptaParaEdad(int meses) {
        return meses >= edadMinMeses && meses <= edadMaxMeses;
    }
}