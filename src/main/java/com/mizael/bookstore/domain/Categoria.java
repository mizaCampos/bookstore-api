package com.mizael.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class Categoria {

    private Integer id;
    private String nome;
    private String descricao;

    private List<Livro> livros = new ArrayList<>();

    
}
