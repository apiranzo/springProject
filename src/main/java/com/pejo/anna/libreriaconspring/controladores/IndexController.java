package com.pejo.anna.libreriaconspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pejo.anna.libreriaconspring.dtos.CategoriaConLibrosDto;
import com.pejo.anna.libreriaconspring.entidades.Categoria;
import com.pejo.anna.libreriaconspring.entidades.Libro;
import com.pejo.anna.libreriaconspring.servicios.AdminNegocio;
import com.pejo.anna.libreriaconspring.servicios.UsuarioNegocio;

import jakarta.validation.Valid;

//Anotación de controlador
@Controller
@RequestMapping("/") //Anotación del path
public class IndexController {
	
	// LLamada a la lógica de usuarioNegocio con la fábrica
	@Autowired
	private UsuarioNegocio usuarioNegocio;
	@Autowired
	private AdminNegocio adminusuarioNegocio;
	
	@GetMapping //solo si se recibe una petición Get 
//	@ResponseBody//Porpio contenido de la consulta
	public String index(Model modelo) {
		modelo.addAttribute("libros", usuarioNegocio.obtenerLibros());
		modelo.addAttribute("categorias", usuarioNegocio.obtenerCategorias());
		modelo.addAttribute("cantidesLibroCategoria", usuarioNegocio.obtenerCantidadLibrosCategoria());

		return "index"; //llamas directamente a una vista
	}
	
	@GetMapping("libros")
	@ResponseBody
	public Iterable<CategoriaConLibrosDto> categoria(Model modelo) {
		return usuarioNegocio.obtenerCantidadLibrosCategoria();
	}
	
	@GetMapping("categoria/{id}")
	public String categoria(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("categoria", usuarioNegocio.obtenerCategoriaPorId(id));
		
		return "categoria";
	}
	
	
	@GetMapping("/admin") //llamada a la url admin
	public String admin(Libro libro) {
		return "admin";
	}
	
	@PostMapping("/admin") //Recuperar los datos del formulario
	public String adminPost(@Valid Libro libro, BindingResult bindingResult) {
		//Forma de validar el objeto que nos han pasado
		if(bindingResult.hasErrors()) {
			return "admin";
		}
		adminusuarioNegocio.insertarLibro(libro);
		return "redirect:/";//Redirigir a la url indicada
		
	}

}
