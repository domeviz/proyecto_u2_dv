package com.uce.edu.demo;

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

		Persona perAPI= this.iPersonaJpaService.buscarPorCedulaCriteriaApi("123");
		LOG.info(" Criteria API Persona: " + perAPI);
		
		LOG.info("Dinamica  : ");	
		Persona perDinamica= this.iPersonaJpaService.buscarDinamicamente("Daniel", "Velez", "M");
		LOG.info(" 1 Persona: " + perDinamica);
		
		Persona perDinamica1=this.iPersonaJpaService.buscarDinamicamente("Diana", "Mancero", "F");
		LOG.info(" 2 Persona: " + perDinamica1);
		
		Persona perDinamica2=this.iPersonaJpaService.buscarDinamicamentePredicados("Daniel", "Velez", "M");
		LOG.info(" 3 Persona: " + perDinamica2);

	}

}
