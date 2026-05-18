package Interfaz;

import service.StreamingService;

import java.time.LocalDate;
import java.util.Scanner;

public class UsuarioInterfaz {
    private final StreamingService service;
    private final Scanner scanner;

    public UsuarioInterfaz(StreamingService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void registrarUsuario() {
        System.out.println("--- REGISTRAR USUARIO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contrasena: ");
        String password = scanner.nextLine();

        service.registrarUsuario(nombre, email, password);
        System.out.println("Usuario registrado.");
    }

    public void registrarSuscripcion() {
        System.out.println("--- REGISTRAR SUSCRIPCION ---");
        long usuarioId = Utils.leerEntero(scanner, "ID de usuario: ");
        System.out.print("Plan (BASICO / ESTANDAR / PREMIUM): ");
        String plan = scanner.nextLine().trim().toUpperCase();
        LocalDate inicio = Utils.leerFecha(scanner, "Fecha inicio (AAAA-MM-DD): ");
        LocalDate fin = Utils.leerFecha(scanner, "Fecha fin (AAAA-MM-DD): ");

        service.registrarSuscripcion(plan, inicio, fin, usuarioId);
        System.out.println("Suscripcion registrada.");
    }

    public void registrarPerfil() {
        System.out.println("--- REGISTRAR PERFIL ---");
        long usuarioId = Utils.leerEntero(scanner, "ID de usuario: ");
        System.out.print("Nombre del perfil: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Es perfil infantil? (s/n): ");
        boolean infantil = scanner.nextLine().trim().equalsIgnoreCase("s");

        service.registrarPerfil(nombre, infantil, usuarioId);
        System.out.println("Perfil registrado.");
    }
}

