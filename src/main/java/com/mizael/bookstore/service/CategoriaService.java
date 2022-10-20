package com.mizael.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mizael.bookstore.domain.Categoria;
import com.mizael.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id){
        Optional<Categoria>categorial  = categoriaRepository.findById(id);
        return categorial.orElse(null);
    }
    
}
