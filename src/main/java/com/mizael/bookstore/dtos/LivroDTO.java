package com.mizael.bookstore.dtos;

import java.io.Serializable;

import com.mizael.bookstore.domain.Livro;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class LivroDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;

    public LivroDTO() {
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    

    
    
}
