/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projec123jpa;

import entities.Malihaklar;
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
public class MalihaklarJpaController implements Serializable {

    public MalihaklarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Malihaklar malihaklar) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(malihaklar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMalihaklar(malihaklar.getSicil()) != null) {
                throw new PreexistingEntityException("Malihaklar " + malihaklar + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Malihaklar malihaklar) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            malihaklar = em.merge(malihaklar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = malihaklar.getSicil();
                if (findMalihaklar(id) == null) {
                    throw new NonexistentEntityException("The malihaklar with id " + id + " no longer exists.");
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
            Malihaklar malihaklar;
            try {
                malihaklar = em.getReference(Malihaklar.class, id);
                malihaklar.getSicil();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The malihaklar with id " + id + " no longer exists.", enfe);
            }
            em.remove(malihaklar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Malihaklar> findMalihaklarEntities() {
        return findMalihaklarEntities(true, -1, -1);
    }

    public List<Malihaklar> findMalihaklarEntities(int maxResults, int firstResult) {
        return findMalihaklarEntities(false, maxResults, firstResult);
    }

    private List<Malihaklar> findMalihaklarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Malihaklar.class));
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

    public Malihaklar findMalihaklar(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Malihaklar.class, id);
        } finally {
            em.close();
        }
    }

    public int getMalihaklarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Malihaklar> rt = cq.from(Malihaklar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
