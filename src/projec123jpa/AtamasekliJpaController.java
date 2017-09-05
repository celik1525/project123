/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projec123jpa;

import entities.Atamasekli;
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
public class AtamasekliJpaController implements Serializable {

    public AtamasekliJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Atamasekli atamasekli) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(atamasekli);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAtamasekli(atamasekli.getId()) != null) {
                throw new PreexistingEntityException("Atamasekli " + atamasekli + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Atamasekli atamasekli) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            atamasekli = em.merge(atamasekli);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = atamasekli.getId();
                if (findAtamasekli(id) == null) {
                    throw new NonexistentEntityException("The atamasekli with id " + id + " no longer exists.");
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
            Atamasekli atamasekli;
            try {
                atamasekli = em.getReference(Atamasekli.class, id);
                atamasekli.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The atamasekli with id " + id + " no longer exists.", enfe);
            }
            em.remove(atamasekli);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Atamasekli> findAtamasekliEntities() {
        return findAtamasekliEntities(true, -1, -1);
    }

    public List<Atamasekli> findAtamasekliEntities(int maxResults, int firstResult) {
        return findAtamasekliEntities(false, maxResults, firstResult);
    }

    private List<Atamasekli> findAtamasekliEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Atamasekli.class));
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

    public Atamasekli findAtamasekli(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Atamasekli.class, id);
        } finally {
            em.close();
        }
    }

    public int getAtamasekliCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Atamasekli> rt = cq.from(Atamasekli.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
