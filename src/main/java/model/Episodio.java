package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Representa un Episodio perteneciente a una Serie.
 *
 * @author Hugo Rodriguez Vigueras
 * @since 16/05/2026
 */
@Entity
public class Episodio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Indica el numero de episodio que es
     */
    private int numero;
    /**
     * Indica su titulo
     */
    private String titulo;
    /**
     * Duracion en minutos
     */
    private int duracionMinutos;
    /**
     * Relación muchos a uno con Serie.
     * Muchos episodios pertenecen a una sola serie.
     */
    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    /**
     * Constructor por defecto de la clase Episodio
     */
    public Episodio() {
    }

    /**
     * Constructor por parametros de la clase Episodio
     *
     * @param numero          Indica el numero de episodio que es
     * @param titulo          Indica su titulo
     * @param duracionMinutos Duracion en minutos
     * @param serie           Indica la serie que es
     */
    public Episodio(int numero, String titulo, int duracionMinutos, Serie serie) {
        this.numero = numero;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.serie = serie;
    }

    /**
     * Getters y Setters
     */
    public Long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}

