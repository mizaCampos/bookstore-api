package com.mizael.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mizael.bookstore.domain.Livro;
import com.mizael.bookstore.exception.ObjectNotFoundException;
import com.mizael.bookstore.repositories.LivroRepository;

@Service
public class LivroService {
    
    @Autowired
    LivroRepository livroRepository;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id  + " Tipo: " + Livro.class.getName()));
    }
}
