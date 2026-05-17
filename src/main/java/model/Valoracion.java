package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
public class Valoracion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Puntuación del 1 al 5 */
    private int puntuacion;
    private String comentario;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "contenido_id")
    private Contenido contenido;

    public Valoracion() {}

    public Valoracion(int puntuacion, String comentario, LocalDate fecha,
                      Usuario usuario, Contenido contenido) {
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fecha = fecha;
        this.usuario = usuario;
        this.contenido = contenido;
    }

    public Long getId() { return id; }
    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Contenido getContenido() { return contenido; }
    public void setContenido(Contenido contenido) { this.contenido = contenido; }
}
