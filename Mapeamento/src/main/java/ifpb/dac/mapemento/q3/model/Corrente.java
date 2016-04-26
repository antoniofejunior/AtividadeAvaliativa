/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.mapemento.q3.model;

import javax.persistence.Entity;

/**
 *
 * @author Antônio
 */
@Entity
public class Corrente extends Conta {

    @Override
    public boolean debitar(double valor) {
        if ((valor > 0) && (getSaldo() > valor)) {
            setSaldo(getSaldo() - valor - 0.75);
            return true;
        }
        return false;
    }

    @Override
    public boolean creditar(double valor) {
        if ((valor > 0) && (getSaldo() > valor)) {
            setSaldo(getSaldo() + valor);
            return true;
        }
        return false;
    }
}
