package Interfaz;

import java.time.LocalDate;
import java.util.Scanner;

public class Utils {
    public static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero valido.");
            }
        }
    }

    public static LocalDate leerFecha(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Formato invalido. Usa AAAA-MM-DD.");
            }
            }
        }
}
