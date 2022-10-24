package com.mizael.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mizael.bookstore.domain.Categoria;
import com.mizael.bookstore.domain.Livro;
import com.mizael.bookstore.exception.ObjectNotFoundException;
import com.mizael.bookstore.repositories.LivroRepository;

@Service
public class LivroService {
    
    @Autowired
    LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id  + " Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findAll();
        return livroRepository.findAllByCategorial(id_cat);
    }

    public Livro update(Integer id, Livro obj){
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return livroRepository.save(newObj);
    }

    public void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());
    }

    public Livro create(Integer id_cat, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findById(id_cat);
        obj.setCategoria(cat);
        return livroRepository.save(obj);
    }

    public void delete(Integer id) {
        Livro obj = findById(id);
        livroRepository.delete(obj);
    }
}
