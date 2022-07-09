package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		//Actualizar con JPQL
		int resultado=this.iPersonaJpaService.actualizarPorApellido("FE", "Perez");
		
		LOG.info("Cantidad de registros actualizados: "+resultado);
		
		//Eliminar por Genero
		int resultado2=this.iPersonaJpaService.eliminarPorGenero("M");
		
		LOG.info("Cantidad de registros eliminados: "+resultado2);
		
	}

}
