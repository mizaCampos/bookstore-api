package com.mizael.bookstore.dtos;

import java.io.Serializable;

import com.mizael.bookstore.domain.Categoria;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String descricao;
    
    public CategoriaDTO(){}

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    
    
}
