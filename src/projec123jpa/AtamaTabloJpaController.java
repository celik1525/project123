/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projec123jpa;

import entities.AtamaTablo;
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
public class AtamaTabloJpaController implements Serializable {

    public AtamaTabloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public AtamaTabloJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AtamaTablo atamaTablo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(atamaTablo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAtamaTablo(atamaTablo.getSicil()) != null) {
                throw new PreexistingEntityException("AtamaTablo " + atamaTablo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AtamaTablo atamaTablo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            atamaTablo = em.merge(atamaTablo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = atamaTablo.getSicil();
                if (findAtamaTablo(id) == null) {
                    throw new NonexistentEntityException("The atamaTablo with id " + id + " no longer exists.");
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
            AtamaTablo atamaTablo;
            try {
                atamaTablo = em.getReference(AtamaTablo.class, id);
                atamaTablo.getSicil();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The atamaTablo with id " + id + " no longer exists.", enfe);
            }
            em.remove(atamaTablo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AtamaTablo> findAtamaTabloEntities() {
        return findAtamaTabloEntities(true, -1, -1);
    }

    public List<AtamaTablo> findAtamaTabloEntities(int maxResults, int firstResult) {
        return findAtamaTabloEntities(false, maxResults, firstResult);
    }

    private List<AtamaTablo> findAtamaTabloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AtamaTablo.class));
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

    public AtamaTablo findAtamaTablo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AtamaTablo.class, id);
        } finally {
            em.close();
        }
    }

    public int getAtamaTabloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AtamaTablo> rt = cq.from(AtamaTablo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
