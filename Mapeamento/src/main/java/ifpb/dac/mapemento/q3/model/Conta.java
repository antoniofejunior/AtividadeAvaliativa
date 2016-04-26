/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.mapemento.q3.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Junior
 */
@MappedSuperclass
public abstract class Conta implements Serializable{
    @Id
    @GeneratedValue
    private long codigo;
    private int numero;
    private int digito;
    @Embedded
    private Agencia agencia;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Cliente cliente;
    private double saldo;
    private int senha;

    public Conta() {
    }

    public Conta(int numero, int digito, Agencia agencia, Cliente cliente, double saldo, int senha) {
        this.numero = numero;
        this.digito = digito;
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = saldo;
        this.senha = senha;
    }
    
    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the digito
     */
    public int getDigito() {
        return digito;
    }

    /**
     * @param digito the digito to set
     */
    public void setDigito(int digito) {
        this.digito = digito;
    }

    /**
     * @return the agencia
     */
    public Agencia getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
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
     * @return the senha
     */
    public int getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    public abstract boolean debitar(double valor);

    public abstract boolean creditar(double valor);

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
