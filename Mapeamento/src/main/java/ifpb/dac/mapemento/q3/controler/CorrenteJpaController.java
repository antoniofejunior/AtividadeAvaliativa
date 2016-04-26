package ifpb.dac.mapemento.q3.controler;

import ifpb.dac.mapemento.q3.controler.exceptions.NonexistentEntityException;
import ifpb.dac.mapemento.q3.model.Corrente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Document   CorrenteJpaController
 * @Date  26/04/2016 @Time 13:01:34
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class CorrenteJpaController implements Serializable {

    public CorrenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Corrente corrente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(corrente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Corrente corrente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            corrente = em.merge(corrente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = corrente.getCodigo();
                if (findCorrente(id) == null) {
                    throw new NonexistentEntityException("The corrente with id " + id + " no longer exists.");
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
            Corrente corrente;
            try {
                corrente = em.getReference(Corrente.class, id);
                corrente.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The corrente with id " + id + " no longer exists.", enfe);
            }
            em.remove(corrente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Corrente> findCorrenteEntities() {
        return findCorrenteEntities(true, -1, -1);
    }

    public List<Corrente> findCorrenteEntities(int maxResults, int firstResult) {
        return findCorrenteEntities(false, maxResults, firstResult);
    }

    private List<Corrente> findCorrenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Corrente.class));
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

    public Corrente findCorrente(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Corrente.class, id);
        } finally {
            em.close();
        }
    }

    public int getCorrenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Corrente> rt = cq.from(Corrente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}