package com.pejo.anna.libreriaconspring.servicios;

import com.pejo.anna.libreriaconspring.dtos.CategoriaConLibrosDto;
import com.pejo.anna.libreriaconspring.entidades.Categoria;
import com.pejo.anna.libreriaconspring.entidades.Libro;

public interface UsuarioNegocio {
	Iterable<Libro> obtenerLibros();
	Iterable<Categoria> obtenerCategorias();
	Categoria obtenerCategoriaPorId(Long id);
	
	Iterable<CategoriaConLibrosDto> obtenerCantidadLibrosCategoria();

}
