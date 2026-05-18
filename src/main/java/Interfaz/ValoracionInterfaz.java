package Interfaz;

import model.Valoracion;
import service.StreamingService;

import java.util.List;
import java.util.Scanner;

public class ValoracionInterfaz {
    private final StreamingService service;
    private final Scanner scanner;

    public ValoracionInterfaz(StreamingService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void listarValoraciones() {
        List<Valoracion> valoraciones = service.obtenerTodasLasValoraciones();
        System.out.println("--- VALORACIONES (" + valoraciones.size() + ") ---");

        if (valoraciones.isEmpty()) {
            System.out.println("No hay valoraciones registradas.");
            return;
        }

        for (Valoracion v : valoraciones) {
            String usuario = v.getUsuario() != null ? v.getUsuario().getNombre() : "?";
            String contenido = v.getContenido() != null ? v.getContenido().getTitulo() : "?";
            System.out.println("[" + v.getId() + "] " + usuario + " -> " + contenido
                    + " | Puntuacion: " + v.getPuntuacion() + "/5 | " + v.getFecha());

            if (v.getComentario() != null && !v.getComentario().isEmpty()) {
                System.out.println("  Comentario: " + v.getComentario());
            }
        }
    }
}
