/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projec123jpa;

import entities.Hizmetsinifi;
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
public class HizmetsinifiJpaController implements Serializable {

    public HizmetsinifiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Hizmetsinifi hizmetsinifi) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(hizmetsinifi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHizmetsinifi(hizmetsinifi.getId()) != null) {
                throw new PreexistingEntityException("Hizmetsinifi " + hizmetsinifi + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Hizmetsinifi hizmetsinifi) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            hizmetsinifi = em.merge(hizmetsinifi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = hizmetsinifi.getId();
                if (findHizmetsinifi(id) == null) {
                    throw new NonexistentEntityException("The hizmetsinifi with id " + id + " no longer exists.");
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
            Hizmetsinifi hizmetsinifi;
            try {
                hizmetsinifi = em.getReference(Hizmetsinifi.class, id);
                hizmetsinifi.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hizmetsinifi with id " + id + " no longer exists.", enfe);
            }
            em.remove(hizmetsinifi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Hizmetsinifi> findHizmetsinifiEntities() {
        return findHizmetsinifiEntities(true, -1, -1);
    }

    public List<Hizmetsinifi> findHizmetsinifiEntities(int maxResults, int firstResult) {
        return findHizmetsinifiEntities(false, maxResults, firstResult);
    }

    private List<Hizmetsinifi> findHizmetsinifiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Hizmetsinifi.class));
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

    public Hizmetsinifi findHizmetsinifi(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Hizmetsinifi.class, id);
        } finally {
            em.close();
        }
    }

    public int getHizmetsinifiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Hizmetsinifi> rt = cq.from(Hizmetsinifi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
