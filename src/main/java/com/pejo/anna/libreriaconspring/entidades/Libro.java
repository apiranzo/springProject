package com.pejo.anna.libreriaconspring.entidades;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
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
	
	//Valor por defecto para Builder
	@Builder.Default
	private String autor = "anónimo";
	
	@Min(0)
	@Positive
	@Column(name = "stock")
	private Integer stock;
	
	@Pattern(regexp = "^\\d{11}$", message = "Debe ser un código de 11 dígitos")
	@Column(name = "isbn", columnDefinition = "CHAR(11)")
	private String isbn;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	
	
}