package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */

@Entity
public class Serie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int temporadas;
    private String genero;

    public Serie() {}

    public Serie(String titulo, int temporadas, String genero) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.genero = genero;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}
