package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase de utilidad para la gestión de la persistencia JPA.
 * Se encarga de centralizar la creación y el acceso al EntityManagerFactory,
 * permitiendo obtener instancias de EntityManager para interactuar con la
 * base de datos ObjectDB.
 * @author Alejandro Andrade Morales
 * @since 11/05/20260
 */
public class JPAUtil {

    /**
     * Factoría de gestores de entidades. Se carga una sola vez al iniciar la aplicación
     * utilizando la unidad de persistencia definida en persistence.xml.
     */
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("PE9streaming");

    /**
     * Proporciona un nuevo gestor de entidades (EntityManager).
     * Cada vez que se llama a este método, se genera una nueva conexión o sesión
     * para realizar operaciones de lectura o escritura.
     * @return Una instancia de {@link EntityManager} lista para ser utilizada.
     */
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
