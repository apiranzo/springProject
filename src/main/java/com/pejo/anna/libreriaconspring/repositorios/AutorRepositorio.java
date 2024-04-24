package com.pejo.anna.libreriaconspring.repositorios;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pejo.anna.libreriaconspring.entidades.Autor;
import com.pejo.anna.libreriaconspring.entidades.Libro;


public interface AutorRepositorio extends CrudRepository<Autor, Long>{

	
	Iterable<Libro> findByFechaNacimientoBetween(LocalDate inicial, LocalDate pasada);
}
