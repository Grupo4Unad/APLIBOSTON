package coleg.ejerc.colegioboston.modelo;

public class Notas {

    public String getDocumento_estudiante() {
        return documento_estudiante;
    }

    public void setDocumento_estudiante(String documento_estudiante) {
        this.documento_estudiante = documento_estudiante;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Notas(){

    }


    public Notas(Double nota) {
      //  this.documento_estudiante = documento_estudiante;
        this.nota = nota;
        //this.ciclo = ciclo;
        //this.curso = curso;
    }

    private String documento_estudiante;
    private Double nota;
    private String ciclo;
    private String curso;
}


