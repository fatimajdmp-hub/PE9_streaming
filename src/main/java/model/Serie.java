package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entidad que representa una Serie de televisión en la plataforma de streaming.
 * Esta clase define la estructura de datos que se almacenará en la base de datos ObjectDB.
 * @author Alejandro Andrade Morales
 * @since 11/05/2026
 */
@Entity
@DiscriminatorValue("SERIE")
public class Serie extends Contenido implements Serializable {

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Episodio> episodios;

    public Serie() {}
    public Serie(String titulo, String genero, int anioEstreno, int duracionMinutos, String sinopsis) {
        super(titulo, genero, anioEstreno, duracionMinutos, sinopsis);
    }
    public List<Episodio> getEpisodios() { return episodios; }
    public void setEpisodios(List<Episodio> episodios) { this.episodios = episodios; }
}