import model.Episodio;
import model.Pelicula;
import model.Serie;
import model.Valoracion;
import service.StreamingService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final StreamingService service = new StreamingService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== PLATAFORMA DE STREAMING =====");
            System.out.println("--- Contenido ---");
            System.out.println("1. Registrar Serie");
            System.out.println("2. Registrar Película");
            System.out.println("3. Listar Series");
            System.out.println("4. Listar Películas");
            System.out.println("--- Usuarios ---");
            System.out.println("5. Registrar Usuario");
            System.out.println("6. Registrar Suscripción");
            System.out.println("7. Registrar Perfil");
            System.out.println("--- Valoraciones ---");
            System.out.println("8. Listar Valoraciones");
            System.out.println("-------------------");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1" -> registrarSerie();
                case "2" -> registrarPelicula();
                case "3" -> listarSeries();
                case "4" -> listarPeliculas();
                case "5" -> registrarUsuario();
                case "6" -> registrarSuscripcion();
                case "7" -> registrarPerfil();
                case "8" -> listarValoraciones();
                case "0" -> salir = true;
                default  -> System.out.println("Opción no válida.");
            }
        }

        System.out.println("Cerrando el programa...");
        scanner.close();
    }

    private static void registrarSerie() {
        System.out.println("\n--- REGISTRAR SERIE ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();
        System.out.print("Género: ");
        String genero = scanner.nextLine().trim();
        int anio = leerEntero("Año de estreno: ");
        int duracion = leerEntero("Duración (min): ");
        System.out.print("Sinopsis: ");
        String sinopsis = scanner.nextLine().trim();

        service.registrarSerie(titulo, genero, anio, duracion, sinopsis);
        System.out.println("✔ Serie registrada correctamente.");
    }

    private static void registrarPelicula() {
        System.out.println("\n--- REGISTRAR PELÍCULA ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();
        System.out.print("Género: ");
        String genero = scanner.nextLine().trim();
        int anio = leerEntero("Año de estreno: ");
        int duracion = leerEntero("Duración (min): ");
        System.out.print("Sinopsis: ");
        String sinopsis = scanner.nextLine().trim();

        service.registrarPelicula(titulo, genero, anio, duracion, sinopsis);
        System.out.println("✔ Película registrada correctamente.");
    }

    private static void listarSeries() {
        List<Serie> series = service.obtenerTodasLasSeries();
        System.out.println("\n--- SERIES (" + series.size() + ") ---");
        if (series.isEmpty()) {
            System.out.println("No hay series registradas.");
            return;
        }
        for (Serie s : series) {
            System.out.println("[" + s.getId() + "] " + s.getTitulo() + " | " + s.getGenero() + " | "
                    + s.getAnioEstreno() + " | " + s.getDuracionMinutos() + " min");
            System.out.println("    Sinopsis: " + s.getSinopsis());
            List<Episodio> eps = s.getEpisodios();
            if (eps != null && !eps.isEmpty()) {
                System.out.println("    Episodios:");
                for (Episodio e : eps) {
                    System.out.println("      Ep." + e.getNumero() + " - " + e.getTitulo() + " (" + e.getDuracionMinutos() + " min)");
                }
            }
        }
    }

    private static void listarPeliculas() {
        List<Pelicula> peliculas = service.obtenerTodasLasPeliculas();
        System.out.println("\n--- PELÍCULAS (" + peliculas.size() + ") ---");
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
            return;
        }
        for (Pelicula p : peliculas) {
            System.out.println("[" + p.getId() + "] " + p.getTitulo() + " | " + p.getGenero() + " | "
                    + p.getAnioEstreno() + " | " + p.getDuracionMinutos() + " min");
            System.out.println("    Sinopsis: " + p.getSinopsis());
        }
    }

    private static void registrarUsuario() {
        System.out.println("\n--- REGISTRAR USUARIO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        service.registrarUsuario(nombre, email, password);
        System.out.println("Usuario registrado correctamente.");
    }

    private static void registrarSuscripcion() {
        System.out.println("--- REGISTRAR SUSCRIPCIÓN ---");
        long usuarioId = leerEntero("ID de usuario: ");
        System.out.print("Plan (BASICO / ESTANDAR / PREMIUM): ");
        String plan = scanner.nextLine().trim().toUpperCase();
        LocalDate inicio = leerFecha("Fecha inicio (AAAA-MM-DD): ");
        LocalDate fin    = leerFecha("Fecha fin (AAAA-MM-DD): ");

        service.registrarSuscripcion(plan, inicio, fin, usuarioId);
        System.out.println("Suscripción registrada correctamente.");
    }

    private static void registrarPerfil() {
        System.out.println("\n--- REGISTRAR PERFIL ---");
        long usuarioId = leerEntero("ID de usuario: ");
        System.out.print("Nombre del perfil: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("¿Es perfil infantil? (s/n): ");
        boolean infantil = scanner.nextLine().trim().equalsIgnoreCase("s");

        service.registrarPerfil(nombre, infantil, usuarioId);
        System.out.println("Perfil registrado correctamente.");
    }


    private static void listarValoraciones() {
        List<Valoracion> valoraciones = service.obtenerTodasLasValoraciones();
        System.out.println("\n--- VALORACIONES (" + valoraciones.size() + ") ---");
        if (valoraciones.isEmpty()) {
            System.out.println("No hay valoraciones registradas.");
            return;
        }
        for (Valoracion v : valoraciones) {
            System.out.println("[" + v.getId() + "] " + (v.getUsuario() != null ? v.getUsuario().getNombre() : "?") + " → " + (v.getContenido() != null ? v.getContenido().getTitulo() : "?") + " | Puntuación: " + v.getPuntuacion() + "/5 | " + v.getFecha());
            if (v.getComentario() != null && !v.getComentario().isEmpty()) {
                System.out.println("    Comentario: " + v.getComentario());
            }
        }
    }

    private static int leerEntero(String leer) {
        while (true) {
            System.out.print(leer);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número entero.");
            }
        }
    }

    private static LocalDate leerFecha(String leer) {
        while (true) {
            System.out.print(leer);
            try {
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Formato inválido. Usa AAAA-MM-DD.");
            }
        }
    }
}
