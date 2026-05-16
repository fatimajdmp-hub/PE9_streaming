package service;


import model.Pelicula;
import model.Serie;
import repository.StreamingRepository;

import java.util.List;

/**
 * Capa de servicio encargada de gestionar la lógica de negocio de la plataforma de streaming.
 * Actúa como intermediaria entre la interfaz de usuario (Main) y la capa de datos (Repository),
 * aplicando validaciones y reglas de control antes de persistir la información.
 *
 * @author Alejandro Andrade Morales
 * @since 11/05/20260
 */
public class StreamingService {

    /**
     * Instancia del repositorio para la comunicación con la base de datos ObjectDB.
     */
    private StreamingRepository repository = new StreamingRepository();

    /**
     * Metodo que registra la serie con su constructor
     *
     * @param titulo          titulo de la serie
     * @param genero          genero de la serie
     * @param anioEstreno     año de estreno
     * @param duracionMinutos duracion en minutos
     * @param sinopsis        Sinopsis
     */
    public void registrarSerie(String titulo, String genero, int anioEstreno, int duracionMinutos, String sinopsis) {
        // Validación de lógica de negocio: el título es obligatorio
        if (titulo == null || titulo.isEmpty()) {
            System.out.println("Error: El título no puede estar vacío.");
            return;
        }

        Serie nuevaSerie = new Serie(titulo, genero, anioEstreno, duracionMinutos, sinopsis);
        repository.guardarSerie(nuevaSerie);
    }

    /**
     * Obtiene el listado completo de series disponibles en la plataforma.
     *
     * @return List de objetos Serie.
     */
    public List<Serie> obtenerTodasLasSeries() {
        return repository.listarSeries();
    }

    /**
     * Registra una nueva película en la base de datos.
     *
     * @param titulo          Nombre de la película.
     * @param duracionMinutos Duración en minutos o número de partes.
     * @param genero          Genero de la pelicula
     * @param anioEstreno     Año de estreno de la pelicula
     * @param sinopsis        Sinopsis de la pelicula
     */
    public void registrarPelicula(String titulo, String genero, int anioEstreno, int duracionMinutos, String sinopsis) {
        Pelicula peli = new Pelicula(titulo, genero, anioEstreno, duracionMinutos, sinopsis);
        repository.guardarPelicula(peli);
    }

    /**
     * Recupera el catálogo completo de películas almacenadas.
     *
     * @return List de objetos Pelicula.
     */
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return repository.listarPelicula();
    }
}
