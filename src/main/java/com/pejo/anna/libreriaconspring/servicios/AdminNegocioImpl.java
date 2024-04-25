package com.pejo.anna.libreriaconspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pejo.anna.libreriaconspring.entidades.Libro;
import com.pejo.anna.libreriaconspring.repositorios.LibroRepositorio;

import lombok.extern.java.Log;

//Anotación de Mensajes de información
@Log
@Service
@Primary
public class AdminNegocioImpl extends UsuarioNegocioImpl implements AdminNegocio {

	// Llamada al repositorio que se crea automaticamente con la fabrica
	@Autowired
	private LibroRepositorio libroRepo;

	@Override
	public Libro insertarLibro(Libro libro) {
		log.info("Insertar el libro " + libro);
		return libroRepo.save(libro);
	}

}
