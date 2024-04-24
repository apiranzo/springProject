package com.pejo.anna.libreriaconspring.entidades;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
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

//Anotaciones persistence
@Entity
@Table(name = "libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Anotaciones Validator
	@NotBlank (message = "El nombre debe ser rellenado")
	@NotNull
	@Size(min = 1, max = 100)
	
	//Anotaciones Persistence
	@Column(name = "titulo")	
	private String titulo;
	
	@NotNull
	@Min(0)
	@Positive
	@Digits(integer = 7, fraction = 2)
	@Column(name = "precio")
	private BigDecimal precio;
	
	@Past
	@Column(name = "fecha_publicacion")
	private LocalDate fechaPublicacion;
	
	//VAlor por defecto para Builder
	@Builder.Default
	@Column(name = "autor")
	private String autor = "Anónimo";
	
	@Min(0)
	@Positive
	@Column(name = "stock")
	private Integer stock;
	
	@Size(min = 11, max = 11)
	@Column(name = "isbn")
	private String isbn;
	
	
	
}