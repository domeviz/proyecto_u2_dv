package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.gerencia.modelo.Empleados;
import com.uce.edu.demo.gerencia.modelo.Gerente;
import com.uce.edu.demo.gerencia.service.IEmpleadoService;
import com.uce.edu.demo.gerencia.service.IGerenteService;
import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);

	@Autowired
	private IGerenteService iGerenteService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Gerente g = new Gerente();
		g.setNombre("Domenica");
		g.setApellido("Vizcarra");
		g.setSucursal("Norte");
		
		Empleados e=new Empleados();
		e.setNombre("Mateo");
		e.setApellido("Ruiz");
		e.setGerente(g);
		
		Empleados e1=new Empleados();
		e1.setNombre("Carolina");
		e1.setApellido("Montero");
		e1.setGerente(g);
		
		this.iGerenteService.insertar(g);
		
		Gerente g2 = new Gerente();
		g2.setNombre("Luis");
		g2.setApellido("Torres");
		g2.setSucursal("Sur");
		
		Empleados e2=new Empleados();
		e2.setNombre("Mateo");
		e2.setApellido("Ruiz");
		e2.setGerente(g2);
		
		this.iGerenteService.insertar(g2);
		
		LOG.info("Se ha insertado al gerente " + g);
		LOG.info("Se ha insertado al gerente " + g2);
		
		Gerente g1 = new Gerente();
		g1.setId(3);
		g1.setNombre("Fernando");
		g1.setApellido("Torres");
		g1.setSucursal("Centro");

		this.iGerenteService.actualizar(g1);
		
		LOG.info("Se ha actualizado al gerente " + g1);
		
		LOG.info("Se ha encontrado al gerente " + this.iGerenteService.buscar(6));
		
		this.iGerenteService.eliminar(4);
		
	}

}
