package com.pejo.anna.libreriaconspring.entidades;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Anotaciones Lombok
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

//Anotación de JPA
@Entity
@Table(name = "autores")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Anotaciones validator
	@NotBlank(message = "El nombre debe ser obligatorio")
	@NotNull
	@Size(min = 1, max = 100)
	//Anotaciones jpa
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@NotBlank(message = "La fecha de es obligatoria")
	@Past
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@OneToMany(mappedBy = "autor")
	private List<Libro> libros;
	

}
