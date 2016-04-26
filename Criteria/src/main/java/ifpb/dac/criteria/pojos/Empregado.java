/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.criteria.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Antônio
 */
@Entity
public class Empregado implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Endereco endereco;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Faculdade faculdade;
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Projeto> projetos;
    @OneToMany
    private List<Dependente> dependentes;
   
    public Empregado() {
        this.projetos = new ArrayList<>();
    }

    public Empregado(String nome, Endereco endereco, Faculdade faculdade, Projeto projeto,Dependente dependente) {
        this.nome = nome;
        this.endereco = endereco;
        this.faculdade = faculdade;
        this.projetos = new ArrayList<>();
        this.dependentes = new ArrayList<>();
        projetos.add(projeto);
        dependentes.add(dependente);
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the faculdade
     */
    public Faculdade getFaculdade() {
        return faculdade;
    }

    /**
     * @param faculdade the faculdade to set
     */
    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    /**
     * @return the projetos
     */
    public List<Projeto> getProjetos() {
        return projetos;
    }

    /**
     * @param projetos the projetos to set
     */
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    @Override
    public String toString() {
        return "Empregado{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", faculdade=" + faculdade + ", projetos=" + projetos + '}';
    }

    /**
     * @return the dependentes
     */
    public List<Dependente> getDependentes() {
        return dependentes;
    }

    /**
     * @param dependentes the dependentes to set
     */
    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }
    
    
}
