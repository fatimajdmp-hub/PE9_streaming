package service;



import model.Pelicula;
import model.Serie;
import repository.StreamingRepository;

import java.util.List;

/**
 *
 */

public class StreamingService {

    // El servicio utiliza el repositorio para acceder a los datos
    private StreamingRepository repository = new StreamingRepository();

    // Lógica para Series
    public void registrarSerie(String titulo, int temporadas, String genero) {
        // Aquí podrías añadir validaciones (ej. que el título no esté vacío)
        if (titulo == null || titulo.isEmpty()) {
            System.out.println("Error: El título no puede estar vacío.");
            return;
        }

        Serie nuevaSerie = new Serie(titulo, temporadas, genero);
        repository.guardarSerie(nuevaSerie);
    }

    public List<Serie> obtenerTodasLasSeries() {
        return repository.listarSeries();
    }


    public void registrarPelicula(String titulo, int duracion, String director) {
        Pelicula peli = new Pelicula(titulo, duracion, director);
        repository.guardarPelicula(peli);
    }

    public List<Pelicula> obtenerTodasLasPeliculas() {
        return repository.listarPelicula();
    }
}
