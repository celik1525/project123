/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projec123jpa;

import entities.KimlikTablo;
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
public class KimlikTabloJpaController implements Serializable {

    public KimlikTabloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(KimlikTablo kimlikTablo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(kimlikTablo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findKimlikTablo(kimlikTablo.getSicil()) != null) {
                throw new PreexistingEntityException("KimlikTablo " + kimlikTablo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(KimlikTablo kimlikTablo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            kimlikTablo = em.merge(kimlikTablo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = kimlikTablo.getSicil();
                if (findKimlikTablo(id) == null) {
                    throw new NonexistentEntityException("The kimlikTablo with id " + id + " no longer exists.");
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
            KimlikTablo kimlikTablo;
            try {
                kimlikTablo = em.getReference(KimlikTablo.class, id);
                kimlikTablo.getSicil();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The kimlikTablo with id " + id + " no longer exists.", enfe);
            }
            em.remove(kimlikTablo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<KimlikTablo> findKimlikTabloEntities() {
        return findKimlikTabloEntities(true, -1, -1);
    }

    public List<KimlikTablo> findKimlikTabloEntities(int maxResults, int firstResult) {
        return findKimlikTabloEntities(false, maxResults, firstResult);
    }

    private List<KimlikTablo> findKimlikTabloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(KimlikTablo.class));
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

    public KimlikTablo findKimlikTablo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(KimlikTablo.class, id);
        } finally {
            em.close();
        }
    }

    public int getKimlikTabloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<KimlikTablo> rt = cq.from(KimlikTablo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
