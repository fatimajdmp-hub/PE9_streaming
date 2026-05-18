package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

public class Subscripcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Tipo de plan: BASICO, ESTANDAR, PREMIUM */
    private String plan;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean activa;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Subscripcion() {}

    public Subscripcion(String plan, LocalDate fechaInicio, LocalDate fechaFin, Usuario usuario) {
        this.plan = plan;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activa = true;
        this.usuario = usuario;
    }

    public Long getId() { return id; }

    public String getPlan() { return plan; }

    public void setPlan(String plan) { this.plan = plan; }

    public LocalDate getFechaInicio() { return fechaInicio; }

    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }

    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public boolean isActiva() { return activa; }

    public void setActiva(boolean activa) { this.activa = activa; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
