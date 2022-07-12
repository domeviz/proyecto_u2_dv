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

		// Insertar
		Persona p = new Persona();
		p.setNombre("Daniel");
		p.setApellido("Velez");
		p.setGenero("M");
		p.setCedula("16654334");

		//this.iPersonaJpaService.guardar(p);

		// 1 TypedQuery
		Persona perTyped = this.iPersonaJpaService.buscarPorCedulaTyped("1223948");
		LOG.info("Persona Typed: " + perTyped);

		// 2 NamedQuery
		Persona perNamed = this.iPersonaJpaService.buscarPorCedulaNamed("1223948");
		LOG.info("Persona Named: " + perNamed);

		// 3 TypedQuery y NamedQuery
		Persona perTypedNamed = this.iPersonaJpaService.buscarPorCedulaTypedNamed("1223948");
		LOG.info("Persona TypedNamed: " + perTypedNamed);

		// 4 Varios NamedQuery
		List<Persona> listP = this.iPersonaJpaService.buscarPorNombreApellido("Daniel", "Velez");
		for(Persona item:listP) {
			LOG.info("Persona: " + item);
		}
		
	}

}
