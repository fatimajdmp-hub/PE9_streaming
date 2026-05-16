package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Episodio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private String titulo;
    private int duracionMinutos;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    public Episodio() {}

    public Episodio(int numero, String titulo, int duracionMinutos, Serie serie) {
        this.numero = numero;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.serie = serie;
    }

    public Long getId() { return id; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public Serie getSerie() { return serie; }
    public void setSerie(Serie serie) { this.serie = serie; }
}

