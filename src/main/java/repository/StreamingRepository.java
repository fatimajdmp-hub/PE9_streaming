package repository;


import model.Pelicula;
import model.Serie;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 */


public class StreamingRepository {

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

    public List<Serie> listarSeries() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Serie s", Serie.class).getResultList();
        } finally {
            em.close();
        }
    }

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

    public List<Pelicula> listarPelicula() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Pelicula s", Pelicula.class).getResultList();
        } finally {
            em.close();
        }
    }
}
