package com.mizael.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mizael.bookstore.domain.Categoria;
import com.mizael.bookstore.domain.Livro;
import com.mizael.bookstore.repositories.CategoriaRepository;
import com.mizael.bookstore.repositories.LivroRepository;

@Service
public class Dbservice {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

    public void instanciaBaseDeDados(){

        Categoria cat1 = new Categoria("Informatica", "Livros de TI");
        Categoria cat2 = new Categoria("Ficção Cientifica", "Ficção Cientifica");
		Categoria cat3 = new Categoria("Biografias", "Livros de Biografias" );

		Livro l1 = new Livro("Clean code","Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro("Engenhanria de software","Louis V.", "Lorem ipsum", cat1);
		Livro l3 = new Livro("The times Machine","H.G. Welss", "Lorem ipsum", cat2);
		Livro l4 = new Livro("The war of the Wordls","H.G. WElls", "Lorem ipsum", cat2);
		Livro l5 = new Livro("I, Robot","Isaac Asiimov", "Lorem ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

    }
    
}
