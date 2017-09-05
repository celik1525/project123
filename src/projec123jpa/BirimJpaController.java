/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projec123jpa;

import entities.Birim;
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
public class BirimJpaController implements Serializable {

    public BirimJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Birim birim) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(birim);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBirim(birim.getId()) != null) {
                throw new PreexistingEntityException("Birim " + birim + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Birim birim) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            birim = em.merge(birim);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = birim.getId();
                if (findBirim(id) == null) {
                    throw new NonexistentEntityException("The birim with id " + id + " no longer exists.");
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
            Birim birim;
            try {
                birim = em.getReference(Birim.class, id);
                birim.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The birim with id " + id + " no longer exists.", enfe);
            }
            em.remove(birim);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Birim> findBirimEntities() {
        return findBirimEntities(true, -1, -1);
    }

    public List<Birim> findBirimEntities(int maxResults, int firstResult) {
        return findBirimEntities(false, maxResults, firstResult);
    }

    private List<Birim> findBirimEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Birim.class));
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

    public Birim findBirim(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Birim.class, id);
        } finally {
            em.close();
        }
    }

    public int getBirimCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Birim> rt = cq.from(Birim.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
