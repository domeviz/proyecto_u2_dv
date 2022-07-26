package com.uce.edu.demo;

import java.util.HashSet;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);

	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Autor autor1 = new Autor();
		autor1.setNombre("Jane Austen");
		
		Autor autor2 = new Autor();
		autor2.setNombre("Emily Bronte");
		
		Set<Autor> autores = new HashSet<>();
		autores.add(autor1);
		autores.add(autor2);
		
		Libro libro1 =new Libro();
		libro1.setTitulo("Cumbres Borrascosas");
		libro1.setCantidadPaginas(500);
		libro1.setAutores(autores);
		
		this.iLibroService.insertar(libro1);
		
		
		
	}

}
