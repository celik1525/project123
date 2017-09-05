/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projec123jpa;

import entities.Ayrilmanedeni;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import projec123jpa.exceptions.NonexistentEntityException;
import projec123jpa.exceptions.PreexistingEntityException;

/**
 *
 * @author Ruhi ÇELİK
 */
public class AyrilmanedeniJpaController implements Serializable {

    public AyrilmanedeniJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ayrilmanedeni ayrilmanedeni) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ayrilmanedeni);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAyrilmanedeni(ayrilmanedeni.getId()) != null) {
                throw new PreexistingEntityException("Ayrilmanedeni " + ayrilmanedeni + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ayrilmanedeni ayrilmanedeni) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ayrilmanedeni = em.merge(ayrilmanedeni);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ayrilmanedeni.getId();
                if (findAyrilmanedeni(id) == null) {
                    throw new NonexistentEntityException("The ayrilmanedeni with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ayrilmanedeni ayrilmanedeni;
            try {
                ayrilmanedeni = em.getReference(Ayrilmanedeni.class, id);
                ayrilmanedeni.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ayrilmanedeni with id " + id + " no longer exists.", enfe);
            }
            em.remove(ayrilmanedeni);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ayrilmanedeni> findAyrilmanedeniEntities() {
        return findAyrilmanedeniEntities(true, -1, -1);
    }

    public List<Ayrilmanedeni> findAyrilmanedeniEntities(int maxResults, int firstResult) {
        return findAyrilmanedeniEntities(false, maxResults, firstResult);
    }

    private List<Ayrilmanedeni> findAyrilmanedeniEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ayrilmanedeni.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ayrilmanedeni findAyrilmanedeni(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ayrilmanedeni.class, id);
        } finally {
            em.close();
        }
    }

    public int getAyrilmanedeniCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ayrilmanedeni> rt = cq.from(Ayrilmanedeni.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
