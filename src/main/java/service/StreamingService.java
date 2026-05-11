package service;



import model.Pelicula;
import model.Serie;
import repository.StreamingRepository;

import java.util.List;

/**
 * Capa de servicio encargada de gestionar la lógica de negocio de la plataforma de streaming.
 * Actúa como intermediaria entre la interfaz de usuario (Main) y la capa de datos (Repository),
 * aplicando validaciones y reglas de control antes de persistir la información.
 * @author Alejandro Andrade Morales
 * @since 11/05/20260
 */
public class StreamingService {

    /**
     * Instancia del repositorio para la comunicación con la base de datos ObjectDB.
     */
    private StreamingRepository repository = new StreamingRepository();

    /**
     * Registra una nueva serie en el sistema tras validar los datos de entrada.
     * @param titulo El nombre de la serie. No puede ser nulo ni estar vacío.
     * @param temporadas Cantidad de temporadas de la serie.
     * @param genero Categoría temática de la serie.
     */
    public void registrarSerie(String titulo, int temporadas, String genero) {
        // Validación de lógica de negocio: el título es obligatorio
        if (titulo == null || titulo.isEmpty()) {
            System.out.println("Error: El título no puede estar vacío.");
            return;
        }

        Serie nuevaSerie = new Serie(titulo, temporadas, genero);
        repository.guardarSerie(nuevaSerie);
    }

    /**
     * Obtiene el listado completo de series disponibles en la plataforma.
     * @return List de objetos Serie.
     */
    public List<Serie> obtenerTodasLasSeries() {
        return repository.listarSeries();
    }

    /**
     * Registra una nueva película en la base de datos.
     * @param titulo Nombre de la película.
     * @param duracion Duración en minutos o número de partes.
     * @param director Género o director asociado a la película.
     */
    public void registrarPelicula(String titulo, int duracion, String director) {
        Pelicula peli = new Pelicula(titulo, duracion, director);
        repository.guardarPelicula(peli);
    }

    /**
     * Recupera el catálogo completo de películas almacenadas.
     * @return List de objetos Pelicula.
     */
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return repository.listarPelicula();
    }
}
