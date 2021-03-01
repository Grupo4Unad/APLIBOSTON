package coleg.ejerc.colegioboston.modelo;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
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
    public Noticia(){

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
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("titulo", titulo);
        result.put("contenido", contenido);
        result.put("url", url);
        return result;
    }
}
