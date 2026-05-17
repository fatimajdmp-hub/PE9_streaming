package service;


import model.*;
import repository.StreamingRepository;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

/**
 * Capa de servicio encargada de gestionar la lógica de negocio de la plataforma de streaming.
 * Actúa como intermediaria entre la interfaz de usuario (Main) y la capa de datos (Repository),
 * aplicando validaciones y reglas de control antes de persistir la información.
 *
 * @author Alejandro Andrade Morales
 * @since 11/05/20260
 */
public class StreamingService {

    /**
     * Instancia del repositorio para la comunicación con la base de datos ObjectDB.
     */
    private StreamingRepository repository = new StreamingRepository();

    /**
     * Metodo que registra la serie con su constructor
     *
     * @param titulo          titulo de la serie
     * @param genero          genero de la serie
     * @param anioEstreno     año de estreno
     * @param duracionMinutos duracion en minutos
     * @param sinopsis        Sinopsis
     */
    public void registrarSerie(String titulo, String genero, int anioEstreno, int duracionMinutos, String sinopsis) {
        // Validación de lógica de negocio: el título es obligatorio
        if (titulo == null || titulo.isEmpty()) {
            System.out.println("Error: El título no puede estar vacío.");
            return;
        }

        Serie nuevaSerie = new Serie(titulo, genero, anioEstreno, duracionMinutos, sinopsis);
        repository.guardarSerie(nuevaSerie);
    }

    /**
     * Obtiene el listado completo de series disponibles en la plataforma.
     *
     * @return List de objetos Serie.
     */
    public List<Serie> obtenerTodasLasSeries() {
        return repository.listarSeries();
    }

    /**
     * Registra una nueva película en la base de datos.
     *
     * @param titulo          Nombre de la película.
     * @param duracionMinutos Duración en minutos o número de partes.
     * @param genero          Genero de la pelicula
     * @param anioEstreno     Año de estreno de la pelicula
     * @param sinopsis        Sinopsis de la pelicula
     */
    public void registrarPelicula(String titulo, String genero, int anioEstreno, int duracionMinutos, String sinopsis) {
        Pelicula peli = new Pelicula(titulo, genero, anioEstreno, duracionMinutos, sinopsis);
        repository.guardarPelicula(peli);
    }

    /**
     * Recupera el catálogo completo de películas almacenadas.
     *
     * @return List de objetos Pelicula.
     */
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return repository.listarPelicula();
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

    /**
     * Busca un usuario por su ID.
     *
     * @param id ID del usuario
     * @return Objeto Usuario o null si no existe.
     */
    public Usuario buscarUsuarioPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Registra una suscripción para un usuario existente.
     *
     * @param plan        Plan de suscripción (BASICO, ESTANDAR, PREMIUM)
     * @param fechaInicio Fecha de inicio
     * @param fechaFin    Fecha de fin
     * @param usuarioId   ID del usuario
     */
    public void registrarSuscripcion(String plan, LocalDate fechaInicio, LocalDate fechaFin, Long usuarioId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Usuario usuario = em.find(Usuario.class, usuarioId);
            if (usuario == null) {
                System.out.println("Error: Usuario no encontrado.");
                return;
            }
            em.getTransaction().begin();
            em.persist(new Subscripcion(plan, fechaInicio, fechaFin, usuario));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /**
     * Registra un perfil para un usuario existente.
     *
     * @param nombre    Nombre del perfil
     * @param infantil  Si es perfil infantil
     * @param usuarioId ID del usuario
     */
    public void registrarPerfil(String nombre, boolean infantil, Long usuarioId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Usuario usuario = em.find(Usuario.class, usuarioId);
            if (usuario == null) {
                System.out.println("Error: Usuario no encontrado.");
                return;
            }
            em.getTransaction().begin();
            em.persist(new Perfil(nombre, infantil, usuario));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el listado completo de valoraciones registradas.
     *
     * @return List de objetos Valoracion.
     */
    public List<Valoracion> obtenerTodasLasValoraciones() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT v FROM Valoracion v", Valoracion.class).getResultList();
        } finally {
            em.close();
        }
    }
}
