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

		//NativeQuery
		//Buscar por apellido y edad
		List<Estudiante> listNative = this.iEstudianteJpaService.buscarPorApellidoEdadNativeNamed("Vizcarra", "21");
		for (Estudiante item : listNative) {
			LOG.info(" 1 Native Estudiante: " + item);
		}
		
		//Buscar por cedula, nombre y apellido
		Estudiante estNative= this.iEstudianteJpaService.buscarPorCedulaNombreApellidoNative("4356721", "Angelica", "Cruz");
		LOG.info(" 2 Native Estudiante: " + estNative);
		
		//NativeNamedQuery
		//Buscar por edad
		List<Estudiante> listNativeNamed = this.iEstudianteJpaService.buscarPorEdadNative("25");
		for (Estudiante item : listNativeNamed) {
			LOG.info(" 1 Native Named Estudiante: " + item);
		}
		
		//Buscar por cedula
		Estudiante estNativeNamed= this.iEstudianteJpaService.buscarPorCedulaNativeNamed("1444255");
		LOG.info(" 2 Native Named Estudiante: " + estNativeNamed);

	}

}
