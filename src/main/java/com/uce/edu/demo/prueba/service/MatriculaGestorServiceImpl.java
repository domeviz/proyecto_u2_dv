package com.uce.edu.demo.prueba.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.modelo.Matricula;
import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.repository.IMatriculaJpaRepository;
import com.uce.edu.demo.prueba.repository.IPropietarioJpaRepository;
import com.uce.edu.demo.prueba.repository.IVehiculoJpaRepository;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService {

	@Autowired
	private IPropietarioJpaRepository iPropietarioRepository;
	
	@Autowired
	private IVehiculoJpaRepository iVehiculoRepository;
	
	@Autowired
	private IMatriculaJpaRepository iMatriculaRepository;
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaJpaService matriculaServiceLiviano;
	
	@Autowired
	@Qualifier("pesado")
	private IMatriculaJpaService matriculaServicePesado;

	@Override
	public void generar(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario pro=this.iPropietarioRepository.buscar(cedula);
		Vehiculo v=this.iVehiculoRepository.buscar(placa);
		String tipo=v.getTipo();
		BigDecimal valorMatricula;
		if(tipo.equals("L")) {
			valorMatricula=this.matriculaServiceLiviano.calcular(v.getPrecio());
		}else {
			valorMatricula=this.matriculaServicePesado.calcular(v.getPrecio());
		}
		if(valorMatricula.compareTo(new BigDecimal(2000))>0) {
			BigDecimal valorDescuento=valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			valorMatricula=valorMatricula.subtract(valorDescuento);
		}
		Matricula matricula=new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setValorMatricula(valorMatricula);
		matricula.setPropietario(pro);
		matricula.setVehiculo(v);
		
		this.iMatriculaRepository.insertar(matricula);
	}

}
