package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    /** Indica si es perfil infantil (contenido restringido) */
    private boolean infantil;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
    private List<Reproduccion> reproducciones;

    public Perfil() {}

    public Perfil(String nombre, boolean infantil, Usuario usuario) {
        this.nombre = nombre;
        this.infantil = infantil;
        this.usuario = usuario;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public boolean isInfantil() { return infantil; }
    public void setInfantil(boolean infantil) { this.infantil = infantil; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public List<Reproduccion> getReproducciones() { return reproducciones; }
    public void setReproducciones(List<Reproduccion> reproducciones) { this.reproducciones = reproducciones; }
}
