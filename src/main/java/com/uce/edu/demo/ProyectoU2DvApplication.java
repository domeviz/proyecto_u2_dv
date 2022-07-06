package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		// Buscar
		// LOG.info("Dato con JPA: "+this.iPersonaJpaService.buscarPorId(4));

		// Insertar
		Persona p = new Persona();
		// p.setId(8);
		p.setNombre("Pepito");
		p.setApellido("Vizcarra");
		p.setGenero("M");
		p.setCedula("123456789");

		this.iPersonaJpaService.guardar(p);

		// Actualizar
		Persona p1 = new Persona();
		p1.setId(16);
		p1.setNombre("Camila");
		p1.setApellido("Vizcarra");
		p1.setGenero("F");
		p1.setCedula("1234");

		//this.iPersonaJpaService.actualizar(p1);

		// Eliminar
		// this.iPersonaJpaService.eliminar(1);
		// this.iPersonaJpaService.eliminar(7);

		// Buscar por Cedula
		Persona per = this.iPersonaJpaService.buscarPorCedula("123");
		LOG.info("Persona encontrada: " + per);

		// Buscar por Apellido
		List<Persona> listP = this.iPersonaJpaService.buscarPorApellido("Vizcarra");
		for(Persona item:listP) {
			LOG.info("Persona: " + item);
		}
		

	}

}
