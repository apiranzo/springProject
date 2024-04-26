package com.pejo.anna.libreriaconspring.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pejo.anna.libreriaconspring.dtos.CategoriaConLibrosDto;
import com.pejo.anna.libreriaconspring.entidades.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	
	@Query("from Categoria c join fetch c.libros where c.id=:id")
	Categoria obtenerCategoriaPorIdConProductos(@Param("id") Long id);
	
	
//	@Query(value = "select count(l.id) Libros, l.categoria_id, c.nombre from libreria_spring.libros l inner join libreria_spring.categorias c on l.categoria_id = c.id group by c.id", nativeQuery = true)
//	@Query("select count(l.id), l.categoria, c.nombre from Libro l join fetch Categoria c group by c.id")
//	@Query("select new CategoriaConLibrosDto(c.id, c.nombre, l.id, l.stock) from Categoria c, Libro l where c.libro = l.id")
	Iterable<CategoriaConLibrosDto> obtenerCantidadLibrosCategoria();
}
