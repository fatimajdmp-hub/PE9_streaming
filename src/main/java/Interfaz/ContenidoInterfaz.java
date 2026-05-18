package Interfaz;

import model.Episodio;
import model.Pelicula;
import model.Serie;
import service.StreamingService;

import java.util.List;
import java.util.Scanner;

public class ContenidoInterfaz {

    private final StreamingService service;
    private final Scanner scanner;

    public ContenidoInterfaz(StreamingService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void registrarSerie() {
        System.out.println("--- REGISTRAR SERIE ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine().trim();
        System.out.print("Genero: ");
        String genero = scanner.nextLine().trim();
        int anio = Utils.leerEntero(scanner, "Anio de estreno: ");
        int duracion = Utils.leerEntero(scanner, "Duracion (min): ");
        System.out.print("Sinopsis: ");
        String sinopsis = scanner.nextLine().trim();

        service.registrarSerie(titulo, genero, anio, duracion, sinopsis);
        System.out.println("Serie registrada.");
    }

    public void registrarPelicula() {
        System.out.println("--- REGISTRAR PELICULA ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine().trim();
        System.out.print("Genero: ");
        String genero = scanner.nextLine().trim();
        int anio = Utils.leerEntero(scanner, "Anio de estreno: ");
        int duracion = Utils.leerEntero(scanner, "Duracion (min): ");
        System.out.print("Sinopsis: ");
        String sinopsis = scanner.nextLine().trim();

        service.registrarPelicula(titulo, genero, anio, duracion, sinopsis);
        System.out.println("Pelicula registrada.");
    }

    public void listarSeries() {
        List<Serie> series = service.obtenerTodasLasSeries();
        System.out.println("--- SERIES (" + series.size() + ") ---");

        if (series.isEmpty()) {
            System.out.println("No hay series registradas.");
            return;
        }

        for (Serie s : series) {
            System.out.println("[" + s.getId() + "] " + s.getTitulo() + " | " + s.getGenero()
                    + " | " + s.getAnioEstreno() + " | " + s.getDuracionMinutos() + " min");
            System.out.println("Sinopsis: " + s.getSinopsis());

            List<Episodio> episodios = s.getEpisodios();
            if (episodios != null && !episodios.isEmpty()) {
                System.out.println("Episodios:");
                for (Episodio e : episodios) {
                    System.out.println("  Ep." + e.getNumero() + " - " + e.getTitulo()
                            + " (" + e.getDuracionMinutos() + " min)");
                }
            }
        }
    }

    public void listarPeliculas() {
        List<Pelicula> peliculas = service.obtenerTodasLasPeliculas();
        System.out.println("--- PELICULAS (" + peliculas.size() + ") ---");

        if (peliculas.isEmpty()) {
            System.out.println("No hay peliculas registradas.");
            return;
        }

        for (Pelicula p : peliculas) {
            System.out.println("[" + p.getId() + "] " + p.getTitulo() + " | " + p.getGenero()
                    + " | " + p.getAnioEstreno() + " | " + p.getDuracionMinutos() + " min");
            System.out.println("  Sinopsis: " + p.getSinopsis());
        }
    }

}
