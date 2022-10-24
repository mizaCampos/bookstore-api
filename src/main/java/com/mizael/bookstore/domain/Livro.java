package com.mizael.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Livro{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty(message = "O campo TITULO é requerido")
    @Length(min = 3, max = 100, message = "o campo NOME deve ter entre 3 e 100 caracteres")
    private String titulo;
     
    @NotEmpty(message = "O campo NOME DO AUTOR é requerido")
    @Length(min = 3, max = 100, message = "o campo NOME deve ter entre 3 e 100 caracteres")
    private String nome_autor;
     
    @NotEmpty(message = "O campo TEXTO é requerido")
    @Length(min = 3, max = 20000000, message = "o campo NOME deve ter entre 3 e 100 caracteres")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro(){}

    public Livro(String titulo, String nome_autor, String texto, Categoria categoria){
        super();
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

}