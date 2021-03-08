package coleg.ejerc.colegioboston.modelo;

public class Estudiante {

    public Estudiante(String documento_estudiante) {
        this.documento_estudiante = documento_estudiante;
      //  this.nombres = nombres;
      //  this.apellidos = apellidos;
    }

    public String getDocumento_estudiante() {
        return documento_estudiante;
    }

    public void setDocumento_estudiante(String documento_estudiante) {
        this.documento_estudiante = documento_estudiante;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    private String documento_estudiante;
    private String nombres;
    private String apellidos;

}
