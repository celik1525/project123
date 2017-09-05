/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projec123jpa;

import entities.Gorevsekli;
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
public class GorevsekliJpaController implements Serializable {

    public GorevsekliJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gorevsekli gorevsekli) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gorevsekli);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGorevsekli(gorevsekli.getId()) != null) {
                throw new PreexistingEntityException("Gorevsekli " + gorevsekli + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gorevsekli gorevsekli) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gorevsekli = em.merge(gorevsekli);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = gorevsekli.getId();
                if (findGorevsekli(id) == null) {
                    throw new NonexistentEntityException("The gorevsekli with id " + id + " no longer exists.");
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
            Gorevsekli gorevsekli;
            try {
                gorevsekli = em.getReference(Gorevsekli.class, id);
                gorevsekli.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gorevsekli with id " + id + " no longer exists.", enfe);
            }
            em.remove(gorevsekli);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gorevsekli> findGorevsekliEntities() {
        return findGorevsekliEntities(true, -1, -1);
    }

    public List<Gorevsekli> findGorevsekliEntities(int maxResults, int firstResult) {
        return findGorevsekliEntities(false, maxResults, firstResult);
    }

    private List<Gorevsekli> findGorevsekliEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gorevsekli.class));
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

    public Gorevsekli findGorevsekli(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gorevsekli.class, id);
        } finally {
            em.close();
        }
    }

    public int getGorevsekliCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gorevsekli> rt = cq.from(Gorevsekli.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
