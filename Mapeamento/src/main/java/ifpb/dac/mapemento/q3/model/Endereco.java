/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.mapemento.q3.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Junior
 */
@Embeddable
public class Endereco implements Serializable {

    private String ruaNumero;
    private String bairro;
    private String cidade;

    public Endereco() {
    }

    public Endereco(String ruaNumero, String bairro, String cidade) {
        this.ruaNumero = ruaNumero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    /**
     * @return the ruaNumero
     */
    public String getRuaNumero() {
        return ruaNumero;
    }

    /**
     * @param ruaNumero the ruaNumero to set
     */
    public void setRuaNumero(String ruaNumero) {
        this.ruaNumero = ruaNumero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + ruaNumero + ", bairro=" + bairro + ", cidade=" + cidade + '}';
    }

}
