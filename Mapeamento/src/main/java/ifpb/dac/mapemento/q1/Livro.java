/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.mapemento.q1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Antonio Junior
 */
@Entity
public class Livro implements Serializable{
    
    @Id
    private int id;
    
    private String titulo;
    
    private String isbn;
    private LocalDate lancamento;
    @ManyToMany
    private List<Autor> autores;

    public Livro() {
    }

    public Livro(int id, String titulo, String isbn, LocalDate lancamento) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.lancamento = lancamento;
        this.autores = new ArrayList<>();
    }

    public void adicionarAutor(Autor autor){
        this.autores.add(autor);
    }
    
    public void removerAutor(Autor autor){
        this.autores.remove(autor);
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the lancamento
     */
    public LocalDate getLancamento() {
        return lancamento;
    }

    /**
     * @param lancamento the lancamento to set
     */
    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    /**
     * @return the autores
     */
    public List<Autor> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    
    
}
