package com.mizael.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mizael.bookstore.domain.Categoria;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "O campo NOME é requerido")
    @Length(min = 3, max = 100, message = "o campo NOME deve ter entre 3 e 100 caracteres")
    private String nome;
    
    @NotEmpty(message = "O campo NOME é requerido")
    @Length(min = 3, max = 100, message = "o campo NOME deve ter entre 3 e 100 caracteres")
    private String descricao;
    
    public CategoriaDTO(){}

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    
    
}
