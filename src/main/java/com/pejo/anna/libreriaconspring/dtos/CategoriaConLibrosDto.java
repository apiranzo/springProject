package com.pejo.anna.libreriaconspring.dtos;

import java.util.Set;

public record CategoriaConLibrosDto(Long id, String nombre, Set<LibroDto> libros) {

}
