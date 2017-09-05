/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projec123jpa;

import entities.Hizmetcetveli;
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
public class HizmetcetveliJpaController implements Serializable {

    public HizmetcetveliJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Hizmetcetveli hizmetcetveli) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(hizmetcetveli);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHizmetcetveli(hizmetcetveli.getId()) != null) {
                throw new PreexistingEntityException("Hizmetcetveli " + hizmetcetveli + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Hizmetcetveli hizmetcetveli) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            hizmetcetveli = em.merge(hizmetcetveli);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = hizmetcetveli.getId();
                if (findHizmetcetveli(id) == null) {
                    throw new NonexistentEntityException("The hizmetcetveli with id " + id + " no longer exists.");
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
            Hizmetcetveli hizmetcetveli;
            try {
                hizmetcetveli = em.getReference(Hizmetcetveli.class, id);
                hizmetcetveli.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hizmetcetveli with id " + id + " no longer exists.", enfe);
            }
            em.remove(hizmetcetveli);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Hizmetcetveli> findHizmetcetveliEntities() {
        return findHizmetcetveliEntities(true, -1, -1);
    }

    public List<Hizmetcetveli> findHizmetcetveliEntities(int maxResults, int firstResult) {
        return findHizmetcetveliEntities(false, maxResults, firstResult);
    }

    private List<Hizmetcetveli> findHizmetcetveliEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Hizmetcetveli.class));
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

    public Hizmetcetveli findHizmetcetveli(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Hizmetcetveli.class, id);
        } finally {
            em.close();
        }
    }

    public int getHizmetcetveliCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Hizmetcetveli> rt = cq.from(Hizmetcetveli.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
