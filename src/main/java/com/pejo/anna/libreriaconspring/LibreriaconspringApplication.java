package com.pejo.anna.libreriaconspring;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pejo.anna.libreriaconspring.entidades.Libro;
import com.pejo.anna.libreriaconspring.repositorios.LibroRepositorio;

@SpringBootApplication
public class LibreriaconspringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaconspringApplication.class, args);
	}

	// Dependencias de Clase - pedida por la fabrica
	@Autowired
	private LibroRepositorio repo;

	@Override
	public void run(String... args) throws Exception {

		repo.save(Libro.builder().titulo("Libro ").precio(new BigDecimal(4)).stock(5).build());

		for (var l : repo.findAll()) {
			System.out.println(l);
		}
		
		repo.findByTituloContains("L");
		
		repo.findById(1L);
		
		repo.findByPrecioBetween(new BigDecimal(2), new BigDecimal(5));
	}

}
