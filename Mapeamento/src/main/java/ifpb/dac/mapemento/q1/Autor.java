/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.mapemento.q1;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Antonio Junior
 */
@Entity
public class Autor extends Pessoa {

    private String instituicao;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;

    public Autor() {
    }

    public Autor(String instituicao, Endereco endereco, String nome, String cpf, int idade, LocalDate dataNascimento) {
        super(endereco, nome, cpf, idade, dataNascimento);
        this.instituicao = instituicao;
    }

    public void adicionarLivro(Livro Livro) {
        this.livros.add(Livro);
    }

    public void removerLivro(Livro livro) {
        this.livros.remove(livro);
    }

    /**
     * @return the instituicao
     */
    public String getInstituicao() {
        return instituicao;
    }

    /**
     * @param instituicao the instituicao to set
     */
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    /**
     * @return the livros
     */
    public List<Livro> getLivros() {
        return livros;
    }

    /**
     * @param livros the livros to set
     */
    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
