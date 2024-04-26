package com.pejo.anna.libreriaconspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pejo.anna.libreriaconspring.dtos.CategoriaConLibrosDto;
import com.pejo.anna.libreriaconspring.entidades.Categoria;
import com.pejo.anna.libreriaconspring.entidades.Libro;
import com.pejo.anna.libreriaconspring.repositorios.CategoriaRepository;
import com.pejo.anna.libreriaconspring.repositorios.LibroRepository;

import lombok.extern.java.Log;

@Log
@Service
public class UsuarioNegocioImpl implements UsuarioNegocio{

	//Llamada al repositorio que se crea automaticamente con la fabrica
	@Autowired
	private LibroRepository libroRepo;
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Override
	public Iterable<Libro> obtenerLibros() {
		log.info("Libros encontrados");
		return libroRepo.findAll();
	}

	@Override
	public Iterable<Categoria> obtenerCategorias() {
		log.info("Categorias encontrados");
		return categoriaRepo.findAll();
	}

	@Override
	public Categoria obtenerCategoriaPorId(Long id) {
		log.info("Categoria por id " + id);
		//se puede establecer la opción de categoriaRepo.findById(id).orElse(null) o convertir el method en Opcional<Categoria>
		//return categoriaRepo.findById(id).orElse(null);
		return categoriaRepo.obtenerCategoriaPorIdConProductos(id);
	}

	@Override
	public Iterable<CategoriaConLibrosDto> obtenerCantidadLibrosCategoria() {
		log.info("Cantidades Libros por Categoria");
		return categoriaRepo.obtenerCantidadLibrosCategoria();
	}

}
