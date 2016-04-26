/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.criteria.consultas;

import ifpb.dac.criteria.pojos.Dependente;
import ifpb.dac.criteria.pojos.Dependente_;
import ifpb.dac.criteria.pojos.Empregado;
import ifpb.dac.criteria.pojos.Empregado_;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Antônio
 */
public class Consultas {

    private EntityManager em = Persistence.createEntityManagerFactory("Criteria").createEntityManager();
    private CriteriaBuilder builder = em.getCriteriaBuilder();

    public static void main(String[] args) {
//        new Consultas().q1();
//        new Consultas().q2();
//        new Consultas().q3();
//        new Consultas().q4();
//        new Consultas().q5();
        new Consultas().q6();
//        new Consultas().q7();
//        new Consultas().q8();
//        new Consultas().q9();
//        new Consultas().q10();
//        new Consultas().q11();
//        new Consultas().q12();
//        new Consultas().q13();
//        new Consultas().q14();
//        new Consultas().q15();
//        new Consultas().q16();
//        new Consultas().q17();
//        new Consultas().q18();
//        new Consultas().q19();
//        new Consultas().q20();
    }

    private void imprimeListaEmpregado(CriteriaQuery consulta) {
        TypedQuery query = em.createQuery(consulta);
        query.getResultList().stream().forEach(System.out::println);
    }
//1.Listar todos os Empregados.

    public void q1() {
        CriteriaQuery<Empregado> criteria = builder.createQuery(Empregado.class);
        Root<Empregado> from = criteria.from(Empregado.class);
        imprimeListaEmpregado(criteria.select(from));
    }

//2. Listar o Empregado com ​ id​ igual a ​ 1​ e ​ nome​ igual ​ Ricardo Job​ .
    public void q2() {
        CriteriaQuery<Empregado> criteria = builder.createQuery(Empregado.class);
        Root<Empregado> from = criteria.from(Empregado.class);
        Predicate igualId = builder.equal(from.get(Empregado_.id), 1);
        Predicate igualNome = builder.equal(from.get(Empregado_.nome), "Ricardo Job");
        imprimeListaEmpregado(criteria.select(from).where(igualId, igualNome));
    }

//3. Listar de forma paginada todos os Empregados.
    public void q3() {
        CriteriaQuery<Empregado> criteria = builder.createQuery(Empregado.class);
        Root<Empregado> from = criteria.from(Empregado.class);
        TypedQuery<Empregado> query = em.createQuery(criteria.select(from));
        query.setMaxResults(2).setFirstResult(0).getResultList().stream().forEach(System.out::println);
    }

//4. Listar o nome de todos os Empregados.
    public void q4() {
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        Root<Empregado> from = criteria.from(Empregado.class);
        criteria.select(from.get(Empregado_.nome));
        TypedQuery<String> query;
        query = em.createQuery(criteria);
        query.getResultList().stream().forEach(System.out::println);
    }

//5. Listar o nome e id de todos os Empregados.
    public void q5() {
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Empregado> from = criteria.from(Empregado.class);
        criteria.multiselect(from.get(Empregado_.id),from.get(Empregado_.nome));
        TypedQuery<Object[]> query;
        query = em.createQuery(criteria);
        query.getResultList().stream().forEach((Object[] x) -> {
            System.out.println("id: " +x[0] +" nome: " + x[1]);
        });
    }

//6. Listar o nome de todos os Dependentes dos Empregados.
    public void q6() {
//        CriteriaQuery<String> criteria = builder.createQuery(String.class);
//        Root<Empregado> from;
//        from = criteria.from(Empregado.class).join(Empregado_.dependentes);
//        criteria.select(from.get(Dependente_.nome));
//        TypedQuery<String> query;
//        query = em.createQuery(criteria);
//        query.getResultList().stream().forEach(System.out::println);
    }

//7. Listar o nome dos Dependentes e dos Empregados, mesmo os Empregados
//que não possuem Dependentes.
    public void q7() {
    }
//8. Listar unicamente todos os Empregados que possuam Dependentes.
    public void q() {
    }
//9. Listar todos os Empregados que possuem id entre 1 e 10.
    public void q9() {
    }
//10. Listar todos os Empregados que frequentam a faculdade.
    public void q10() {
    }
//11. Listar todos os Empregados que possuem Dependentes.
    public void q11() {
    }
//12. Listar todos os Empregados que seus Dependentes possuam a letra ​ i como
//terceira letra do nome.
    public void q12() {
    }
//13. Listar todos os Empregados que seus Dependentes possuam a letra ​ a como
//segunda letra do nome. Considere que o nome do Dependente pode estar todo em
//maíusculo.
    public void q13() {
    }
//14. Listar o nome, em maíusculo, de todos os Empregados que possuem
//Dependentes.
    public void q14() {
    }
//15. Listar o número de Empregados que começam com a letra R.
    public void q15() {
    }
//16. Listar o nome e a quantidade de Dependentes de todos os Empregados,
//mesmo os que não possuem Dependentes.
    public void q16() {
    }
//17. Listar todos os Empregados que possuem id maior que a média dos ids de
//todos os Empregados.
    public void q17() {
    }
//18. Listar o nome dos Empregados que seus Dependentes possuem id maior que 2.
    public void q18() {
    }
//19. Listar todos os Empregados ordenados pelo nome.
    public void q19() {
    }
//20. Listar todos os Empregados que não possuam um determinado nome (será
//passado como parâmetro
    public void q20() {
    }

}
