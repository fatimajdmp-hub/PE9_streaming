package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa una Serie de televisión en la plataforma de streaming.
 * Esta clase define la estructura de datos que se almacenará en la base de datos ObjectDB.
 * @author Alejandro Andrade Morales
 * @since 11/05/2026
 */
@Entity
public class Serie implements Serializable {

    /**
     * Identificador único de la serie. Generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El título o nombre de la serie.
     */
    private String titulo;

    /**
     * Cantidad total de temporadas de las que dispone la serie.
     */
    private int temporadas;

    /**
     * Categoría o género temático de la serie (ej. Acción, Ciencia Ficción).
     */
    private String genero;

    /**
     * Constructor por defecto. Requerido por el estándar JPA para la creación de instancias.
     */
    public Serie() {}

    /**
     * Constructor completo para inicializar una nueva serie con sus datos principales.
     * @param titulo Nombre descriptivo de la serie.
     * @param temporadas Número entero de temporadas disponibles.
     * @param genero Categoría a la que pertenece la serie.
     */
    public Serie(String titulo, int temporadas, String genero) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.genero = genero;
    }

    /**
     * Recupera el identificador de la serie.
     * @return El ID numérico único.
     */
    public Long getId() { return id; }

    /**
     * Recupera el título de la serie.
     * @return Cadena de texto con el título.
     */
    public String getTitulo() { return titulo; }

    /**
     * Asigna un título a la serie.
     * @param titulo El nombre de la serie a establecer.
     */
    public void setTitulo(String titulo) { this.titulo = titulo; }

    /**
     * Obtiene el número de temporadas.
     * @return Cantidad de temporadas.
     */
    public int getTemporadas() { return temporadas; }

    /**
     * Actualiza el número de temporadas de la serie.
     * @param temporadas Nuevo número de temporadas.
     */
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

    /**
     * Obtiene el género de la serie.
     * @return Género actual.
     */
    public String getGenero() { return genero; }

    /**
     * Establece el género de la serie.
     * @param genero El género a asignar.
     */
    public void setGenero(String genero) { this.genero = genero; }
}
