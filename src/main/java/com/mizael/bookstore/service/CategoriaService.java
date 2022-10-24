package com.mizael.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mizael.bookstore.domain.Categoria;
import com.mizael.bookstore.dtos.CategoriaDTO;
import com.mizael.bookstore.exception.ObjectNotFoundException;
import com.mizael.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id){
        Optional<Categoria>categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + " Tipo: " + Categoria.class.getName()));
        
    }

    public List<Categoria>findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDto) {

        Categoria obj = findById(id);
        obj.setNome(obj.getNome());
        obj.setDescricao(obj.getDescricao());
        return categoriaRepository.save(obj);
    }
    
}
