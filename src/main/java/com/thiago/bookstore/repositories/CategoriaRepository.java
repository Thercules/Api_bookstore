package com.thiago.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiago.bookstore.domain.Categoria;
/* Sobre o uso do repository: 
 * Estamos basicamente indicando para nosso porojeto que essa classe será uma interface de repositório
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
