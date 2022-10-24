package com.mizael.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.mizael.bookstore.domain.Livro;



@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
    List<Livro> findAllByCategorial(@PathVariable (value = "id_cat")Integer id_cat);
    
}
