package com.pejo.anna.libreriaconspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pejo.anna.libreriaconspring.repositorios.AutorRepositorio;

//Anotaciones de Spring 
/**
 * Controlador permite gestionar todas las 
 * peticiones de CRUD
 * 
 * RequestMapping es el parametro que se 
 * le añade a la url para poder acceder a los datos
 * el usuario
 * 	//http:localhost:8080/autores
 */
@Controller
public class AutorController {
	
	//Instanciar interface de tipo Autor
	/*Autowired se esta refiriendo en inyeccion del objeto como fabrica 
	 * Esto nos permite no tener que ir creando distintas new Autor para 
	 * cada una de las instancias*/
	@Autowired
	private AutorRepositorio autorRepo;
	
	//Anotación de que tipo de Petición va a responder
	@GetMapping(value = "/autores")
	//Method que va a mostrar los autores
	public String home() {
		return "autores";
	}

}
