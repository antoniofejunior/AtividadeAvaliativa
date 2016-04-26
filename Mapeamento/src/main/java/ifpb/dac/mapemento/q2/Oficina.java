/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.mapemento.q2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Antonio Junior
 */
@Entity
public class Oficina implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    
    @Embedded
    private Endereco endereco;
    
    private double saldo;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Conserto> consertos;

    public Oficina() {
        this.funcionarios = new ArrayList<>();
        this.consertos = new ArrayList<>();
    }

    public Oficina(Endereco endereco, double saldo, List<Funcionario> funcionarios, List<Conserto> consertos) {
        this();
        this.endereco = endereco;
        this.saldo = saldo;
        this.funcionarios = funcionarios;
        this.consertos = consertos;
    }

    @Override
    public String toString() {
        return "Oficina{" + endereco + ", saldo=" + saldo + ", funcionarios=" + funcionarios + ", consertos=" + consertos + '}';
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
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the funcionarios
     */
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /**     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    /**
     * @return the consertos
     */
    public List<Conserto> getConsertos() {
        return consertos;
    }

    /**
     * @param consertos the consertos to set
     */
    public void setConsertos(List<Conserto> consertos) {
        this.consertos = consertos;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    public void addFuncionario(Funcionario funcionario){
        this.getFuncionarios().add(funcionario);
    }
    
    public void remFunionario(Funcionario funcionario){
        this.getFuncionarios().remove(funcionario);
    }
    
    public  void addConserto(Conserto conserto){
        this.getConsertos().add(conserto);
    }
    
    public  void remConserto(Conserto conserto){
        this.getConsertos().remove(conserto);
    }
    
    
}
