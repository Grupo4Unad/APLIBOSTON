package coleg.ejerc.colegioboston.modelo;

public class Noticia {
    private String titulo;
    private String contenido;
    private String url;

    public Noticia(String titulo, String contenido, String url) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
