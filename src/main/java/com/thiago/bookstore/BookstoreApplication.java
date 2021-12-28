/*
 * Nossa aplicação até então segue funcionando, o erro padrão do spring está em aberto lá no navegador
 */
package com.thiago.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thiago.bookstore.domain.Categoria;
import com.thiago.bookstore.domain.Livro;
import com.thiago.bookstore.repositories.CategoriaRepository;
import com.thiago.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository; 
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	//Método
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Inglês", "Livros de Inglês");
		
		Livro l1 = new Livro(null, "Codigo limpo", "Robert Cecil", "Lorem ipsum dolor", cat1);
		
		/* Sobre esta linha:
		 * Com esta linha fizemos a categoria conhecer os seus livros e os livros conhecerem as categorias.
		 * Agora precisamos informar a nossa aplicação que ela precisa salvar isso no banco de dados.
		 */
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}
}

