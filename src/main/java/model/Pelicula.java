package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa una Película en el sistema de streaming.
 * Esta clase está mapeada para su persistencia en la base de datos mediante JPA.
 * @author Alejandro Andrade Morales
 * @since 11/05/2026
 */
@Entity
public class Pelicula implements Serializable {

    /**
     * Identificador único de la película. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Título de la película.
     */
    private String titulo;

    /**
     * Duración o número de partes.
     */
    private int temporadas;

    /**
     * Género cinematográfico de la película.
     */
    private String genero;

    /**
     * Constructor por defecto requerido por JPA.
     */
    public Pelicula() {}

    /**
     * Constructor con parámetros para crear una nueva película.
     * @param titulo El nombre de la película.
     * @param temporadas El número de temporadas o partes.
     * @param genero El género de la película.
     */
    public Pelicula(String titulo, int temporadas, String genero) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.genero = genero;
    }

    /**
     * Obtiene el ID de la película.
     * @return El identificador de la entidad.
     */
    public Long getId() { return id; }

    /**
     * Obtiene el título de la película.
     * @return El título actual.
     */
    public String getTitulo() { return titulo; }

    /**
     * Establece el título de la película.
     * @param titulo El nuevo título a asignar.
     */
    public void setTitulo(String titulo) { this.titulo = titulo; }

    /**
     * Obtiene la cantidad de temporadas o partes.
     * @return Número de temporadas.
     */
    public int getTemporadas() { return temporadas; }

    /**
     * Establece la cantidad de temporadas o partes.
     * @param temporadas El número a asignar.
     */
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

    /**
     * Obtiene el género de la película.
     * @return El género actual.
     */
    public String getGenero() { return genero; }

    /**
     * Establece el género de la película.
     * @param genero El género a asignar.
     */
    public void setGenero(String genero) { this.genero = genero; }
}
