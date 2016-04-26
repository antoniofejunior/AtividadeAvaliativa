/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.criteria.consultas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antônio
 */
public class DaoJpa {

    private UnidadeDePersistencia persistencia;
    private EntityManagerFactory emf;
    private EntityManager em;

    public DaoJpa(UnidadeDePersistencia udp) {
        this.persistencia = udp;
    }

    public DaoJpa() {
        this(UnidadeDePersistencia.Derby);
    }

    private void init() {
        emf = Persistence.createEntityManagerFactory(persistencia.getDescricao());
        em = emf.createEntityManager();
    }

    private void close() {
        em.close();
        emf.close();
    }

    public void salvar(Object objeto) {
        this.init();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        this.close();
    }

    public void remover(Object id, Class entityClass) {
        this.init();
        em.getTransaction().begin();
        em.remove(em.find(entityClass, id));
        em.getTransaction().commit();
        this.close();
    }
}
