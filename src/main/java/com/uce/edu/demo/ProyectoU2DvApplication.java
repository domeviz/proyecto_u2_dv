package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);

	@Autowired
	private IHotelService iHotelService;
	
	@Autowired
	private IHabitacionService iHabitacionService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		Hotel h1=new Hotel();
//		h1.setNombre("Hilton Colon GUY");
//		h1.setDireccion("Malecon");
//		this.iHotelService.insertar(h1);
		
		Hotel hote = new Hotel();
		hote.setId(1);
		
		Habitacion habi1 = new Habitacion();
		habi1.setNumero("A1234");
		habi1.setPiso("10");
		habi1.setTipo("Familiar");
		
		habi1.setHotel(hote);
	
		Habitacion habi2 = new Habitacion();
		habi2.setNumero("A123456");
		habi2.setPiso("1");
		habi2.setTipo("Matrimonial");
		
		habi2.setHotel(hote);
		this.iHabitacionService.insertar(habi1);
		this.iHabitacionService.insertar(habi2);

	}

}
