/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.criteria.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Antônio
 */
@Entity
public class Faculdade implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String descricao;

    @OneToMany(mappedBy = "faculdade")
    private List<Empregado> empregados;

    public Faculdade() {
    }

    public Faculdade(String descricao) {
        this.descricao = descricao;
    }

    public void addEmpregado(Empregado empregado) {
        this.empregados.add(empregado);
    }

    public void delEmpregado(Empregado empregado) {
        this.empregados.remove(empregado);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the empregados
     */
    public List<Empregado> getEmpregados() {
        return empregados;
    }

    /**
     * @param empregados the empregados to set
     */
    public void setEmpregados(List<Empregado> empregados) {
        this.empregados = empregados;
    }

    @Override
    public String toString() {
        return "Faculdade{" + "id=" + id + ", descricao=" + descricao + '}';
    }

}
