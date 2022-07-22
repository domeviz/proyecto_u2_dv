package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.pasaporte.modelo.CiudadanoP;
import com.uce.edu.demo.pasaporte.modelo.Pasaporte;
import com.uce.edu.demo.pasaporte.service.ICiudadanoPService;
import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);

	@Autowired
	private ICiudadanoService iCiudadanoService;

	@Autowired
	private ICiudadanoPService iCiudadanoPService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Tarea 22
		// INSERCIONES
		CiudadanoP c1 = new CiudadanoP();
		c1.setCedula("1234567");
		c1.setNombre("Domenica");
		c1.setApellido("Vizcarra");
		c1.setFechaNacimiento(LocalDateTime.of(2000, 5, 12, 12, 10));

		Pasaporte p1 = new Pasaporte();
		p1.setNumero("123");
		p1.setFechaEmision(LocalDateTime.now());
		p1.setFechaCaducidad(LocalDateTime.of(2030, 5, 12, 12, 10));

		c1.setPasaporte(p1);

		this.iCiudadanoPService.insertar(c1);

		CiudadanoP c2 = new CiudadanoP();
		c2.setCedula("7483838");
		c2.setNombre("Adriana");
		c2.setApellido("Carvajal");
		c2.setFechaNacimiento(LocalDateTime.of(2002, 4, 11, 4, 20));

		Pasaporte p2 = new Pasaporte();
		p2.setNumero("456");
		p2.setFechaEmision(LocalDateTime.now());
		p2.setFechaCaducidad(LocalDateTime.of(2030, 5, 12, 12, 10));

		c2.setPasaporte(p2);

		this.iCiudadanoPService.insertar(c2);

		CiudadanoP c3 = new CiudadanoP();
		c3.setCedula("6473773");
		c3.setNombre("Rosa");
		c3.setApellido("Villa");
		c3.setFechaNacimiento(LocalDateTime.of(2001, 8, 12, 2, 1));

		Pasaporte p3 = new Pasaporte();
		p3.setNumero("789");
		p3.setFechaEmision(LocalDateTime.now());
		p3.setFechaCaducidad(LocalDateTime.of(2030, 5, 12, 12, 10));

		c3.setPasaporte(p3);

		this.iCiudadanoPService.insertar(c3);

		LOG.info("Se ha insertado al ciudadano " + c1);
		LOG.info("Se ha insertado al ciudadano " + c2);
		LOG.info("Se ha insertado al ciudadano " + c3);

		LOG.info("Se ha insertado el pasaporte " + p1);
		LOG.info("Se ha insertado el pasaporte " + p2);
		LOG.info("Se ha insertado el pasaporte " + p3);

		// ACTUALIZACIONES
		CiudadanoP c = new CiudadanoP();
		c.setId(4);
		c.setCedula("66732211");
		c.setNombre("Amanda");
		c.setApellido("Carrillo");
		c.setFechaNacimiento(LocalDateTime.of(1990, 4, 11, 4, 20));
		this.iCiudadanoPService.actualizar(c);
		LOG.info("Se ha actualizado al ciudadano " + c);

		// BUSQUEDA

		LOG.info("Se ha encontrado al ciudadano " + this.iCiudadanoPService.buscarPorId(9));

		// ELIMINACIONES
		this.iCiudadanoPService.eliminar(31);

		LOG.info("Se ha eliminado al ciudadano " + c3);

		// Ejercicio en clase
		// Guardando por ciudadano
		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("Domenica");
		ciu1.setApellido("Vizcarra");

		Empleado empl1 = new Empleado();
		empl1.setCodigoIess("12121");
		empl1.setSalario(new BigDecimal(100));
		empl1.setCiudadano(ciu1);

		ciu1.setEmpleado(empl1);

		this.iCiudadanoService.guardarCiudadano(ciu1);

		// Guardando por Empleado
		Ciudadano ciu2 = new Ciudadano();
		ciu2.setNombre("Alison");
		ciu2.setApellido("Vizcarra");

		Empleado empl2 = new Empleado();
		empl2.setCodigoIess("43434");
		empl2.setSalario(new BigDecimal(500));
		empl2.setCiudadano(ciu2);

		// Insertar empleado
		this.iCiudadanoService.guardarEmpleado(empl2);

	}

}
