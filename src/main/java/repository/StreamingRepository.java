package repository;


import model.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Esta clase es una clase de acceso a datos (DAO) para la gestión de contenidos de streaming.
 * @author Alejandro Andrade Morales
 * @since 11/05/20260
 */
public class StreamingRepository {

    /**
     * Guarda una instancia de Serie en la base de datos.
     * @param serie Objeto de tipo Serie que se desea almacenar.
     */
    public void guardarSerie(Serie serie) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(serie);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /**
     * Recupera todas las series almacenadas en la base de datos.
     * @return Una lista (List) con todos los objetos Serie encontrados.
     */
    public List<Serie> listarSeries() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Serie s", Serie.class).getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Guarda una instancia de Pelicula en la base de datos.
     * @param pelicula Objeto de tipo Pelicula que se desea almacenar.
     */
    public void guardarPelicula(Pelicula pelicula) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pelicula);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /**
     * Recupera todas las películas almacenadas en la base de datos.
     * @return Una lista (List) con todos los objetos Pelicula encontrados.
     */
    public List<Pelicula> listarPelicula() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Se utiliza la consulta JPQL para obtener todas las entidades de tipo Pelicula
            return em.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param nombre   Nombre del usuario
     * @param email    Email del usuario
     * @param password Contraseña del usuario
     */
    public void registrarUsuario(String nombre, String email, String password) {
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new Usuario(nombre, email, password));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void guardarUsuario(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Usuario buscarUsuarioPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public void guardarSuscripcion(Subscripcion suscripcion) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(suscripcion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void guardarPerfil(Perfil perfil) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(perfil);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


    public void guardarValoracion(Valoracion valoracion) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(valoracion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Valoracion> listarValoraciones() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT v FROM Valoracion v", Valoracion.class).getResultList();
        } finally {
            em.close();
        }
    }


    public void guardarReproduccion(Reproduccion reproduccion) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reproduccion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
