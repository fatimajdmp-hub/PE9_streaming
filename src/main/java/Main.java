import Interfaz.ContenidoInterfaz;
import Interfaz.UsuarioInterfaz;
import Interfaz.ValoracionInterfaz;
import service.StreamingService;

import java.util.Scanner;

public class Main {

    private static final StreamingService service = new StreamingService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ContenidoInterfaz contenido = new ContenidoInterfaz(service, scanner);
        UsuarioInterfaz usuario = new UsuarioInterfaz(service, scanner);
        ValoracionInterfaz valoracion = new ValoracionInterfaz(service, scanner);
        boolean salir = false;

        while (!salir) {
            System.out.println("===== PLATAFORMA DE STREAMING =====");
            System.out.println("--- Contenido ---");
            System.out.println("1. Registrar Serie");
            System.out.println("2. Registrar Pelicula");
            System.out.println("3. Listar Series");
            System.out.println("4. Listar Peliculas");
            System.out.println("--- Usuarios ---");
            System.out.println("5. Registrar Usuario");
            System.out.println("6. Registrar Suscripcion");
            System.out.println("7. Registrar Perfil");
            System.out.println("--- Valoraciones ---");
            System.out.println("8. Listar Valoraciones");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> contenido.registrarSerie();
                case "2" -> contenido.registrarPelicula();
                case "3" -> contenido.listarSeries();
                case "4" -> contenido.listarPeliculas();
                case "5" -> usuario.registrarUsuario();
                case "6" -> usuario.registrarSuscripcion();
                case "7" -> usuario.registrarPerfil();
                case "8" -> valoracion.listarValoraciones();
                case "0" -> salir = true;
                default  -> System.out.println("Opcion no valida.");
            }
        }

        System.out.println("Cerrando...");
        scanner.close();
    }
}