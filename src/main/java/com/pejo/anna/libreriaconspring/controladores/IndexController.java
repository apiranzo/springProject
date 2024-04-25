package com.pejo.anna.libreriaconspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pejo.anna.libreriaconspring.entidades.Libro;
import com.pejo.anna.libreriaconspring.servicios.AdminNegocio;
import com.pejo.anna.libreriaconspring.servicios.UsuarioNegocio;

import jakarta.validation.Valid;

//Anotación de controlador
@Controller
@RequestMapping("/") //Anotación del path
public class IndexController {
	
	// LLamada a la lógica de negocio con la fábrica
	@Autowired
	private UsuarioNegocio negocio;
	@Autowired
	private AdminNegocio adminNegocio;
	
	@GetMapping //solo si se recibe una petición Get 
//	@ResponseBody//Porpio contenido de la consulta
	public String index(Model modelo) {
		modelo.addAttribute("libros", negocio.obtenerLibros());
		return "index"; //llamas directamente a una vista
		
	}
	
	@GetMapping("/admin") //llamada a la url admin
	public String admin() {
		return "admin";
	}
	
	@PostMapping("/admin") //Recuperar los datos del formulario
	public String adminPost(@Valid Libro libro, BindingResult bindingResult) {
		//Forma de validar el objeto que nos han pasado
		if(bindingResult.hasErrors()) {
			return "admin";
		}
		adminNegocio.insertarLibro(libro);
		return "redirect:/";//Redirigir a la url indicada
		
	}

}
