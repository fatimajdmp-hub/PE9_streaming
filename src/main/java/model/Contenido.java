package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Clase base abstracta que representa un Contenido en la plataforma de streaming.
 * Pelicula y Serie heredan de esta clase.
 * Usa herencia SINGLE_TABLE: una sola tabla en BD para los tres tipos.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Contenido implements Serializable {
    /**
     * ID único generado automáticamente por JPA
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Titulo del contenido
     */
    private String titulo;
    /**
     * Genero del contenido
     */
    private String genero;
    /**
     * Año de estreno del contenido
     */
    private int anioEstreno;
    /**
     * Duracion en minutos
     */
    private int duracionMinutos;
    /**
     * Sinopsis del contenido
     */
    private String sinopsis;
    /**
     * Relacion de mucho a muchos con la clase categoria
     */
    @ManyToMany
    private List<Categoria> categorias;

    /**
     * Constructor vacio de Contenido, obligatorio para la JPA
     */
    public Contenido() {
    }

    /**
     * Constructor de la clase contenido
     *
     * @param titulo          Titulo del contenido
     * @param genero          Genero del contenido
     * @param anioEstreno     Año del contenido
     * @param duracionMinutos Duracion en minutos
     * @param sinopsis        Sinopsis
     */
    public Contenido(String titulo, String genero, int anioEstreno, int duracionMinutos, String sinopsis) {
        this.titulo = titulo;
        this.genero = genero;
        this.anioEstreno = anioEstreno;
        this.duracionMinutos = duracionMinutos;
        this.sinopsis = sinopsis;
    }

    /**
     * Getters y Setters
     */
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
