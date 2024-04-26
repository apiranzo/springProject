package com.pejo.anna.libreriaconspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pejo.anna.libreriaconspring.entidades.Categoria;
import com.pejo.anna.libreriaconspring.entidades.Libro;
import com.pejo.anna.libreriaconspring.repositorios.CategoriaRepository;
import com.pejo.anna.libreriaconspring.repositorios.LibroRepository;

import lombok.extern.java.Log;

//Anotación de Mensajes de información
@Log
@Service
@Primary
public class AdminNegocioImpl extends UsuarioNegocioImpl implements AdminNegocio {

	// Llamada al repositorio que se crea automaticamente con la fabrica
	@Autowired
	private LibroRepository libroRepo;
	@Autowired
	private CategoriaRepository categoriaRepo;

	@Override
	public Libro insertarLibro(Libro libro) {
		log.info("Insertar el libro " + libro);
		return libroRepo.save(libro);
	}

	@Override
	public Categoria insertarCategoria(Categoria categoria) {
		log.info("Insertar la categoria " + categoria);
		return categoriaRepo.save(categoria);
	}

}
