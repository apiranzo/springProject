package com.pejo.anna.libreriaconspring.servicios;

import com.pejo.anna.libreriaconspring.entidades.Categoria;
import com.pejo.anna.libreriaconspring.entidades.Libro;

public interface AdminNegocio {
	public Libro insertarLibro(Libro libro);
	public Categoria insertarCategoria(Categoria categoria);
}
