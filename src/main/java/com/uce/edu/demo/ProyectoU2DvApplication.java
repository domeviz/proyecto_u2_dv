package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	
	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Estudiante estDinamica=this.iEstudianteJpaService.buscarDinamicamentePorApellidoEdadGeneroCriteriaAPI("Vizcarra", "21", "F");
		LOG.info(" 1 Estudiante: " + estDinamica);
		
		List<Estudiante> listDinamica=this.iEstudianteJpaService.buscarDinamicamentePorApellidoCursoGeneroCriteriaAPI("Martinez", "1", "M");
		for (Estudiante item : listDinamica) {
			LOG.info(" 2 Estudiante: " + item);
		}
		
		List<Estudiante> listDinamica2=this.iEstudianteJpaService.buscarDinamicamentePorApellidoCursoGeneroCriteriaAPI("Martinez", "1", "F");
		for (Estudiante item : listDinamica2) {
			LOG.info(" 3 Estudiante: " + item);
		}

	}

}
