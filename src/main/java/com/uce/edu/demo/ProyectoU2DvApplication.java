package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//Buscar
		//LOG.info("Dato con JPA: "+this.iPersonaJpaService.buscarPorId(4));
		
		// Insertar
		Persona p = new Persona();
		//p.setId(8);
		p.setNombre("Pepito12");
		p.setApellido("Perez");

		this.iPersonaJpaService.guardar(p);

		// Actualizar
		Persona p1 = new Persona();
		p1.setId(4);
		p1.setNombre("AndreaA");
		p1.setApellido("SolizA");

		//this.iPersonaJpaService.actualizar(p1);

		// Eliminar
		//this.iPersonaJpaService.eliminar(1);
		//this.iPersonaJpaService.eliminar(7);

	}

}
