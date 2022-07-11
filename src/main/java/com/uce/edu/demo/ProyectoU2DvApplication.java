package com.uce.edu.demo;

import java.math.BigDecimal;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba.service.IPropietarioJpaService;
import com.uce.edu.demo.prueba.service.IVehiculoJpaService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);

	@Autowired
	private IVehiculoJpaService iVehiculoJpaService;
	
	@Autowired
	private IPropietarioJpaService iPropietarioJpaService;
	
//	@Autowired
//	private IMatriculaGestorService iMatriculaGestorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//Crear Propietario
		Propietario p=new Propietario();
		p.setCedula("1234567");
		p.setNombre("Domenica");
		p.setApellido("Vizcarra");
		
		this.iPropietarioJpaService.crearPropietario(p);
		
		LOG.info("Se ha creado el propietario: "+p);
		
		//Crear Vehiculo
		Vehiculo v=new Vehiculo();
		v.setMarca("Nissan");
		v.setModelo("12344");
		v.setPlaca("ABC123");
		v.setTipo("L");
		v.setPrecio(new BigDecimal(200000));
		
		this.iVehiculoJpaService.insertar(v);
		
		LOG.info("Se ha creado el vehiculo: "+v);
		
		//Actualizar Vehiculo
		v.setMarca("Chevrolet");
		
		this.iVehiculoJpaService.actualizar(v);
		
		LOG.info("Se ha actualizado el vehiculo: "+v);
		
		//Crear matricula
//		this.iMatriculaGestorService.generar("1234567", "ABC123");
//		LOG.info("Se ha creado la matricula");
		
	}

}
