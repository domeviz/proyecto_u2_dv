package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.modelo.EstudianteContadorEdad;
import com.uce.edu.demo.estudiante.modelo.EstudianteSencillo;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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

		List<EstudianteSencillo> listaEstudiante=this.iEstudianteJpaService.buscarPorCursoSencillo("6");
		for(EstudianteSencillo item: listaEstudiante) {
			LOG.info(" Estudiantes del curso: " + item);
		}
		
		List<EstudianteContadorEdad> mylistaEstudiante=this.iEstudianteJpaService.buscarCantidadPorEdad();
		for(EstudianteContadorEdad item: mylistaEstudiante) {
			LOG.info(" Edad: " + item);
		}
	}

}
