/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Antonio Junior
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

    public boolean logar(String usario, String senha) {
        String jpql = "return c.login.senha from Cliente c where UPPER (c.lodin.usuario) like :usuario";
        this.init();
        TypedQuery<String> query = em.createNamedQuery(jpql, String.class);
        query.setParameter("usuario", usario);
        String retorno = query.getSingleResult();
        return (senha == null ? retorno == null : senha.equals(retorno));
    }
}
