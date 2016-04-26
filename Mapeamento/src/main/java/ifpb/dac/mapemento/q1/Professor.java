/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.mapemento.q1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Antonio Junior
 */
@Entity
public class Professor extends Pessoa{
    
    private double salario;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Telefone> telefones;

    public Professor() {
    }

    public Professor(double salario, Telefone telefone, Endereco endereco, String nome, String cpf, int idade, LocalDate dataNascimento) {
        super(endereco, nome, cpf, idade, dataNascimento);
        this.salario = salario;
        this.telefones = new ArrayList<>();
        this.addFone(telefone);
    }

    public void addFone(Telefone telefone){
        this.getTelefones().add(telefone);
    }
    
    public void delFone(Telefone telefone){
        this.getTelefones().remove(telefone);
    }
    
    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the telefones
     */
    public List<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
}
