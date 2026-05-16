package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa una Película en el sistema de streaming.
 * Esta clase hereda de Contenido
 * @author Hugo Rodriguez Vigueras
 * @since 16/05/2026
 */
@Entity
@DiscriminatorValue("PELICULA")
public class Pelicula extends Contenido implements Serializable {
    /**
     * Constructor por defecto de la clase Pelicula
     */
    public Pelicula() {}

    /**
     * Constructor de pelicula con parametros
     *
     * @param titulo Titulo de la pelicula
     * @param genero Genero de la pelicula
     * @param anioEstreno Año de estreno
     * @param duracionMinutos Duracion en minutos
     * @param sinopsis Sinopsis
     */
    public Pelicula(String titulo, String genero, int anioEstreno, int duracionMinutos, String sinopsis) {
        super(titulo, genero, anioEstreno, duracionMinutos, sinopsis);
    }
}