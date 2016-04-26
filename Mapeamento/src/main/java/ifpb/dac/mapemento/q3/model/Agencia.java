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
 * @author Antônio
 */
@Embeddable
public class Agencia implements Serializable {

    private int numero;
    private int digito;

    public Agencia() {
    }

    public Agencia(int numero, int digito) {
        this.numero = numero;
        this.digito = digito;
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
}
