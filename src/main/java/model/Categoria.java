package model;

import javax.persistence.*;
import java.util.List;

/**
 * Representa una Categoría temática (ej: Terror, Comedia).
 * Relación muchos a muchos con Contenido.
 *
 * @author Hugo Rodriguez Vigueras
 * @since 16/05/2026
 */

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * Nombre de la categoria
     */
    private String nombre;
    /**
     * Descripcion de la categoria
     */
    private String descripcion;
    /**
     * La relación la hace Contenido.
     * No hace tabla extra aqui, la hace en Contenido.
     */
    @ManyToMany(mappedBy = "categorias")
    private List<Contenido> contenidos;

    /**
     * Constructor vacio de categoria
     */
    public Categoria() {
    }

    /**
     * Constructor con parametros
     *
     * @param nombre      Nombre de la Categoria
     * @param descripcion Descripcion de la Categoria
     */
    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Getters y Setters
     */
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }
}
