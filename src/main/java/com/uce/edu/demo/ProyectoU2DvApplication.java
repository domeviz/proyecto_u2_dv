package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2DvApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU2DvApplication.class);

	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Factura f= this.iFacturaService.consultar(1);
		LOG.info("Numero: "+ f.getNumero());
		LOG.info("Fecha: "+ f.getFecha());
		LOG.info("Cliente: "+ f.getCliente().getCiudadano().getNombre());
		LOG.info("Tarjeta: "+ f.getCliente().getNumeroTarjeta());
		
		List<DetalleFactura> detalles=f.getDetalles();
		
		for(DetalleFactura deta:detalles) {
			LOG.info("Detalle: "+deta);
		}
//		// 1 libro que tiene 2 autores
//		Libro2 l = new Libro2();
//		l.setTitulo("Bellas durmientes");
//		l.setCantidadPaginas(496);
//
//		this.iLibro2Service.insertar(l);
//
//		Autor2 a1 = new Autor2();
//		a1.setNombre("Stephen King");
//
//		Autor2 a2 = new Autor2();
//		a2.setNombre("Owen King");
//
//		this.iAutor2Service.insertar(a1);
//		this.iAutor2Service.insertar(a2);
//
//		Libro2Autor2 la1 = new Libro2Autor2();
//		la1.setLibro2(l);
//		la1.setAutor2(a1);
//
//		Libro2Autor2 la2 = new Libro2Autor2();
//		la2.setLibro2(l);
//		la2.setAutor2(a2);
//
//		this.iLibro2Autor2Service.insertar(la1);
//		this.iLibro2Autor2Service.insertar(la2);
//
//		LOG.info("Se ha insertado " + l);
//		LOG.info("Se ha insertado " + a1);
//		LOG.info("Se ha insertado " + a2);
//		LOG.info("Se ha insertado " + la1);
//		LOG.info("Se ha insertado " + la2);
//
//		// 1 autor que escribio 2 libros
//		Autor2 a = new Autor2();
//		a.setNombre("Jane Austen");
//
//		this.iAutor2Service.insertar(a);
//
//		Libro2 l1 = new Libro2();
//		l1.setTitulo("Emma");
//		l1.setCantidadPaginas(560);
//
//		Libro2 l2 = new Libro2();
//		l2.setTitulo("Orgullo y Prejuicio");
//		l2.setCantidadPaginas(384);
//
//		this.iLibro2Service.insertar(l1);
//		this.iLibro2Service.insertar(l2);
//
//		Libro2Autor2 la3 = new Libro2Autor2();
//		la3.setAutor2(a);
//		la3.setLibro2(l1);
//
//		Libro2Autor2 la4 = new Libro2Autor2();
//		la4.setAutor2(a);
//		la4.setLibro2(l2);
//
//		this.iLibro2Autor2Service.insertar(la3);
//		this.iLibro2Autor2Service.insertar(la4);
//
//		LOG.info("Se ha insertado " + a);
//		LOG.info("Se ha insertado " + l1);
//		LOG.info("Se ha insertado " + l2);
//		LOG.info("Se ha insertado " + la3);
//		LOG.info("Se ha insertado " + la4);

	}

}
