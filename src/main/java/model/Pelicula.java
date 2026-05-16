package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa una Película en el sistema de streaming.
 * Esta clase hereda de Contenido
 * @author Hugo Rodriguez Vigueras
 * @since 11/05/2026
 */
@Entity
@DiscriminatorValue("PELICULA")
public class Pelicula extends Contenido implements Serializable {
    public Pelicula() {}
    public Pelicula(String titulo, String genero, int anioEstreno, int duracionMinutos, String sinopsis) {
        super(titulo, genero, anioEstreno, duracionMinutos, sinopsis);
    }
}