package com.mizael.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    }

    
}
