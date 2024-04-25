package com.pejo.anna.libreriaconspring.servicios;

import com.pejo.anna.libreriaconspring.entidades.Libro;

public interface UsuarioNegocio {
	public Iterable<Libro> obtenerLibros();

}
