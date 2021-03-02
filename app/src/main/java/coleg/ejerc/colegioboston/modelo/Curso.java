package coleg.ejerc.colegioboston.modelo;

import java.util.ArrayList;

public class Curso {

    private ArrayList<String> notas;
    private String nombre;

    public Curso(String nombre) {
        notas = new ArrayList<String>();
        this.nombre = nombre;
    }

    public void añadirNota(String nota) {
        notas.add(nota);
    }

    public ArrayList<String> getNotas() {
        return notas;
    }

    public String getNombre() {
        return nombre;
    }
}
