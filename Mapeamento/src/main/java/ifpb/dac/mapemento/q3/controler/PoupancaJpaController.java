package ifpb.dac.mapemento.q3.controler;

import ifpb.dac.mapemento.q3.controler.exceptions.NonexistentEntityException;
import ifpb.dac.mapemento.q3.model.Poupanca;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Document   PoupancaJpaController
 * @Date  26/04/2016 @Time 17:29:31
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class PoupancaJpaController implements Serializable {

    public PoupancaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Poupanca poupanca) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(poupanca);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Poupanca poupanca) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            poupanca = em.merge(poupanca);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = poupanca.getCodigo();
                if (findPoupanca(id) == null) {
                    throw new NonexistentEntityException("The poupanca with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Poupanca poupanca;
            try {
                poupanca = em.getReference(Poupanca.class, id);
                poupanca.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The poupanca with id " + id + " no longer exists.", enfe);
            }
            em.remove(poupanca);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Poupanca> findPoupancaEntities() {
        return findPoupancaEntities(true, -1, -1);
    }

    public List<Poupanca> findPoupancaEntities(int maxResults, int firstResult) {
        return findPoupancaEntities(false, maxResults, firstResult);
    }

    private List<Poupanca> findPoupancaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Poupanca.class));
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

    public Poupanca findPoupanca(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Poupanca.class, id);
        } finally {
            em.close();
        }
    }

    public int getPoupancaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Poupanca> rt = cq.from(Poupanca.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}