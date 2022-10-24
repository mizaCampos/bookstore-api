package com.mizael.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.mizael.bookstore.domain.Livro;
import com.mizael.bookstore.dtos.LivroDTO;
import com.mizael.bookstore.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroResource {

    @Autowired
    LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<Livro>findById(@PathVariable Integer id){
        Livro obj = livroService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>>findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
        List<Livro> list = livroService.findAll(id_cat);
        List<LivroDTO>listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
        //localhost:8090/livros?categoria=1
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable  Integer id, @RequestBody Livro obj){
        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.status(HttpStatus.OK).body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable  Integer id, @RequestBody Livro obj){
        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.status(HttpStatus.OK).body(newObj);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestParam (value = "categoria", defaultValue = "0") Integer id_cat,
           @RequestBody Livro obj){
        Livro newObj = livroService.create(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Integer id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
    
