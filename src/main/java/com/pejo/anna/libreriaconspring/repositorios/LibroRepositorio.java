package com.pejo.anna.libreriaconspring.repositorios;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pejo.anna.libreriaconspring.entidades.Libro;


public interface LibroRepositorio extends CrudRepository<Libro, Long>{
	//La crea Spring de forma embevida 
	//De forma automática CrudRepository es el DAO<T> que hacíamos con operaciones básicas
	//Cuando arranca spring se crea el codigo en tiempo real. 
	
	//Find by - es un prefijo que hace una select
	//Titulo es el nombre de nuestro campo
	//Contains es la accion que hace que es buscar los resultados que contengan ese titulo
	Iterable<Libro> findByTituloContains(String titulo);
	
	//Between busca los resultados que se encuentren entre los parametros
	Iterable<Libro> findByPrecioBetween(BigDecimal minimo, BigDecimal maximo);

}
