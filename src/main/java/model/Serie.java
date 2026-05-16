package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Representa una Serie. Hereda de Contenido y añade lista de episodios.
 *
 * @author Hugo Rodriguez Vigueras
 * @since 16/05/2026
 */
@Entity
@DiscriminatorValue("SERIE")
public class Serie extends Contenido implements Serializable {
    /**
     * Lista de episodios de la serie.
     * Si se borra la serie, se borran sus episodios.
     * La relación la gestiona Episodio.
     */
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Episodio> episodios;

    /**
     * Constructor por defecto de Serie
     */
    public Serie() {
    }

    /**
     * Constructor por parametros de Serie
     *
     * @param titulo          Titulo de la serie
     * @param genero          Genero de la serie
     * @param anioEstreno     Año de estreno
     * @param duracionMinutos Duracion en minutos
     * @param sinopsis        Sinopsis
     */
    public Serie(String titulo, String genero, int anioEstreno, int duracionMinutos, String sinopsis) {
        super(titulo, genero, anioEstreno, duracionMinutos, sinopsis);
    }

    /**
     * Getters y Setters
     */
    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }
}