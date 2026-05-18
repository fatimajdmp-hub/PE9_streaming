package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Reproduccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora;
    /** Minuto en el que se quedó el usuario */
    private int minutoParada;
    /** Si terminó de ver el contenido */
    private boolean completada;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "contenido_id")
    private Contenido contenido;

    public Reproduccion() {}

    public Reproduccion(LocalDateTime fechaHora, int minutoParada, boolean completada,
                        Perfil perfil, Contenido contenido) {
        this.fechaHora = fechaHora;
        this.minutoParada = minutoParada;
        this.completada = completada;
        this.perfil = perfil;
        this.contenido = contenido;
    }

    public Long getId() { return id; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public int getMinutoParada() { return minutoParada; }
    public void setMinutoParada(int minutoParada) { this.minutoParada = minutoParada; }
    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }
    public Perfil getPerfil() { return perfil; }
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }
    public Contenido getContenido() { return contenido; }
    public void setContenido(Contenido contenido) { this.contenido = contenido; }
}
