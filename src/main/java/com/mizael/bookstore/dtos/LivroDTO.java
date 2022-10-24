package com.mizael.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mizael.bookstore.domain.Livro;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class LivroDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "O campo TITULO é requerido")
    @Length(min = 3, max = 100, message = "o campo NOME deve ter entre 3 e 100 caracteres")
    private String titulo;

    public LivroDTO() {
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    

    
    
}
