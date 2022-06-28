package com.uce.edu.demo;

//Tarea12
//import org.jboss.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.to.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	//Tarea12
	//private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);
	
	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2DvApplication.class);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Persona persona=new Persona();
		persona.setId(2);
		persona.setNombre("Pepito");
		persona.setApellido("PerezZ");
		
		//Insertar
		//this.iPersonaJdbcService.guardar(persona);
		
		Persona per1=new Persona();
		per1.setId(2);
		per1.setNombre("A");
		per1.setApellido("B");
		
		//Actualizar
		//this.iPersonaJdbcService.actualizar(per1);
		
		//Eliminar
		//this.iPersonaJdbcService.eliminar(4);
		
		//Bucar
		LOG.info(this.iPersonaJdbcService.buscarPorId(1).toString());
		
		//---------------------------------------------//
		
		//No se debe usar en aplicaciones empresariales
		//System.out.println("Hola Mundo");
		
		//Tarea12
		//LOG.info("Tarea 12");
		
		//Taller
		//Ejemplos de LOG
		//LOG.info("Hola mundo con slf4j");
		//LOG.error("Error el estudiante no existe");
		//LOG.debug("Antes de entrar al metodo");
		
	}

}
