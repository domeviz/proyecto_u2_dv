package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);

	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// 1 TypedQuery
		
		// Buscar por Id
		Estudiante perTyped = this.iEstudianteJpaService.buscarPorId(4);
		LOG.info(" 1 Typed Estudiante: " + perTyped);

		// Buscar por Nombre
		List<Estudiante> listTyped = this.iEstudianteJpaService.buscarPorNombreTyped("Mateo");
		for (Estudiante item : listTyped) {
			LOG.info(" 2 Typed Estudiante: " + item);
		}

		// 2 NamedQuery
		
		// Buscar por Cedula
		Estudiante perNamed = this.iEstudianteJpaService.buscarPorCedulaNamed("1234567");
		LOG.info(" 1 Named Estudiante: " + perNamed);

		// Buscar por Apellido
		List<Estudiante> listNamed = this.iEstudianteJpaService.buscarPorApellidoNamed("Perez");
		for (Estudiante item : listNamed) {
			LOG.info(" 2 Named Estudiante: " + item);
		}

		// 3 TypedQuery y NamedQuery
		// Buscar por Cedula Apellido
		List<Estudiante> listTypedNamed = this.iEstudianteJpaService.buscarPorCedulaApellidoTypedNamed("7364521", "Pardo");
		for (Estudiante item : listTypedNamed) {
			LOG.info(" 1 TypedNamed Estudiante: " + item);
		}

		// Buscar por Edad
		List<Estudiante> listTypedNamed2 = this.iEstudianteJpaService.buscarPorEdadTypedNamed("25");
		for (Estudiante item : listTypedNamed2) {
			LOG.info(" 2 TypedNamed Estudiante: " + item);
		}

	}

}
