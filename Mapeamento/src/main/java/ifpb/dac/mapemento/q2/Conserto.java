/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.mapemento.q2;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Antonio Junior
 */
@Entity
public class Conserto implements Serializable {

    @Id
    @GeneratedValue()
    private long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Funcionario funcionario;

    private double valor;

//    @Convert(converter = ConvertLocalDateForDate.class)
//    @Temporal(TemporalType.DATE)
    private LocalDate dataDoServico;

    public Conserto() {
    }

    public Conserto(Funcionario funcionario, double valor, LocalDate dataDoServico) {
        this.funcionario = funcionario;
        this.valor = valor;
        this.dataDoServico = dataDoServico;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the dataDoServico
     */
    public LocalDate getDataDoServico() {
        return dataDoServico;
    }

    /**
     * @param dataDoServico the dataDoServico to set
     */
    public void setDataDoServico(LocalDate dataDoServico) {
        this.dataDoServico = dataDoServico;
    }

    @Override
    public String toString() {
        return "Conserto{" + "funcionario: " + funcionario + ", valor = " + valor + ", dataDoServico: " + dataDoServico + '}';
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

}
