package com.thiago.bookstore.repositories;
/*
 * CTRL + SHIFT + F -> Substituição de palavras
 */
import com.thiago.bookstore.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Sobre o uso do repository: 
 * Estamos basicamente indicando para nosso projeto que essa classe será uma interface de repositório
 */
@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
