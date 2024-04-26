package com.pejo.anna.libreriaconspring.entidades;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El nombre es obligatorio")
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "nombre")
	private String nombre;
	
	@Lob //Lob = objeto de texto muy largo implica que ese elemento se almacena a parte y no ocupa espacio en fila
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "categoria")
	private Set<Libro> libros;

}
