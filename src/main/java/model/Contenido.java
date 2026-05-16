package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Contenido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private int anioEstreno;
    private int duracionMinutos;
    private String sinopsis;

    @ManyToMany
    private List<Categoria> categorias;

    public Contenido() {}

    /**
     * Constructor de la clase contenido
     *
     * @param titulo Titulo del contenido
     * @param genero Genero del contenido
     * @param anioEstreno Año del contenido
     * @param duracionMinutos Duracion en minutos
     * @param sinopsis Sinopsis
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
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public int getAnioEstreno() { return anioEstreno; }
    public void setAnioEstreno(int anioEstreno) { this.anioEstreno = anioEstreno; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
    public List<Categoria> getCategorias() { return categorias; }
    public void setCategorias(List<Categoria> categorias) { this.categorias = categorias; }
}
