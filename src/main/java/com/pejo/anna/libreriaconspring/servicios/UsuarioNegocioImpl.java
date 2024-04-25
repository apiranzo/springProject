package com.pejo.anna.libreriaconspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pejo.anna.libreriaconspring.entidades.Libro;
import com.pejo.anna.libreriaconspring.repositorios.LibroRepositorio;

@Service
public class UsuarioNegocioImpl implements UsuarioNegocio{

	//Llamada al repositorio que se crea automaticamente con la fabrica
	@Autowired
	private LibroRepositorio libroRepo;
	
	@Override
	public Iterable<Libro> obtenerLibros() {
		// TODO Auto-generated method stub
		return libroRepo.findAll();
	}

}
