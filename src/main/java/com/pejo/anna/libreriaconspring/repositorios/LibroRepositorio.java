package com.pejo.anna.libreriaconspring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.pejo.anna.libreriaconspring.entidades.Libro;

public interface LibroRepositorio extends CrudRepository<Libro, Long>{
	//La crea Spring de forma embevida 
	//De forma automática CrudRepository es el DAO<T> que hacíamos con operaciones básicas
	//Cuando arranca spring se crea el codigo en tiempo real. 

}
