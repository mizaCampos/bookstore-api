package com.mizael.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mizael.bookstore.domain.Categoria;
import com.mizael.bookstore.dtos.CategoriaDTO;
import com.mizael.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria>findByid(@PathVariable Integer id){
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);

    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>>findAll(){
        List<Categoria>list = categoriaService.findAll();
        //convertendo a lista Para uma lista DTO
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);

    }
    
}

//localhost:8080/categorias/endpoint


