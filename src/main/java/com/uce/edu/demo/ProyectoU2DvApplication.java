package com.uce.edu.demo;

import java.math.BigDecimal;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);
	
	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;
	
	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Ciudadano ciu1=new Ciudadano();
		ciu1.setNombre("Domenica");
		ciu1.setApellido("Vizcarra");
		
		Empleado empl1=new Empleado();
		empl1.setCodigoIess("12121");
		empl1.setSalario(new BigDecimal(100));
		empl1.setCiudadano(ciu1);
		
		ciu1.setEmpleado(empl1);
		
		this.iCiudadanoService.guardarCiudadano(ciu1);
		
		Ciudadano ciu2=new Ciudadano();
		ciu2.setNombre("Alison");
		ciu2.setApellido("Vizcarra");
		
		Empleado empl2=new Empleado();
		empl2.setCodigoIess("43434");
		empl2.setSalario(new BigDecimal(500));
		empl2.setCiudadano(ciu2);
		
		//Insertar empleado
		//this.iCiudadanoService.guardarEmpleado(empl2);
		
	}

}
