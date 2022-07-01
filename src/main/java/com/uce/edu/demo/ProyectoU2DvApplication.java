package com.uce.edu.demo;

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

		// INSERCIONES
		Estudiante e1 = new Estudiante();
		e1.setId(1);
		e1.setCedula("1234567");
		e1.setNombre("Domenica");
		e1.setApellido("Vizcarra");
		e1.setEdad("21");

		Estudiante e2 = new Estudiante(2, "7654321", "Adriana", "Hernandez", "22");
		Estudiante e3 = new Estudiante(3, "4356721", "Camila", "Smith", "25");
		Estudiante e4 = new Estudiante(4, "7364521", "Rodrigo", "Carvajal", "22");
		Estudiante e5 = new Estudiante(5, "1627354", "Malcolm", "Villa", "19");

		this.iEstudianteJpaService.guardar(e1);
		this.iEstudianteJpaService.guardar(e2);
		this.iEstudianteJpaService.guardar(e3);
		this.iEstudianteJpaService.guardar(e4);
		this.iEstudianteJpaService.guardar(e5);

		LOG.info("Se ha insertado el estudiante " + e1);
		LOG.info("Se ha insertado el estudiante " + e2);
		LOG.info("Se ha insertado el estudiante " + e3);
		LOG.info("Se ha insertado el estudiante " + e4);
		LOG.info("Se ha insertado el estudiante " + e5);

		// ACTUALIZACIONES
		Estudiante e = new Estudiante();
		e.setId(3);
		e.setCedula("4356721");
		e.setNombre("Camila");
		e.setApellido("Perez");
		e.setEdad("25");
		this.iEstudianteJpaService.actualizar(e);
		LOG.info("Se ha actualizado el estudiante " + e);

		// BUSQUEDAS
		this.iEstudianteJpaService.buscarPorId(3);
		this.iEstudianteJpaService.buscarPorId(1);

		LOG.info("Se ha encontrado el estudiante " + this.iEstudianteJpaService.buscarPorId(3).toString());
		LOG.info("Se ha encontrado el estudiante " + this.iEstudianteJpaService.buscarPorId(1).toString());

		// ELIMINACIONES
		this.iEstudianteJpaService.eliminar(4);
		this.iEstudianteJpaService.eliminar(2);

		LOG.info("Se ha eliminado el estudiante " + e4);
		LOG.info("Se ha eliminado el estudiante " + e2);

	}

}
