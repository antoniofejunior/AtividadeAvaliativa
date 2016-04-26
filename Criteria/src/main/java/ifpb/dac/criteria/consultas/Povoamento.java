/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.criteria.consultas;

import ifpb.dac.criteria.pojos.Dependente;
import ifpb.dac.criteria.pojos.Empregado;
import ifpb.dac.criteria.pojos.Endereco;
import ifpb.dac.criteria.pojos.Faculdade;
import ifpb.dac.criteria.pojos.Projeto;

/**
 *
 * @author Antônio
 */
public class Povoamento {
    public static void main(String[] args) {
        DaoJpa banco = new DaoJpa();
        
        // povoar questao 1 e 2
        Faculdade faculdade = new Faculdade("IFPB");
        Projeto projeto = new Projeto("DAC-criteria");
//        banco.salvar(new Empregado("Ricardo Job", new Endereco("rua", "bairro"),faculdade,projeto,null));
//        banco.salvar(new Empregado("Antonio", new Endereco("rua", "bairro"),faculdade,projeto,null));
//        banco.salvar(new Empregado("Wellingtom", new Endereco("rua", "bairro"),faculdade,projeto,null));
//        banco.salvar(new Empregado("Dijalma", new Endereco("rua", "bairro"),faculdade,projeto,null));
        banco.salvar(new Empregado("Junior", new Endereco("rua", "bairro"),faculdade,projeto,new Dependente("dependente")));
//        
        // povoar questao 3
        // povoar questao 4
        // povoar questao 5
        // povoar questao 6
        // povoar questao 7
        // povoar questao 8
        // povoar questao 9
        // povoar questao 10
        // povoar questao 11
        // povoar questao 12
        // povoar questao 13
        // povoar questao 14
        // povoar questao 15
        // povoar questao 16
        // povoar questao 17
        // povoar questao 18
        // povoar questao 19
        // povoar questao 20
        
    }
}
