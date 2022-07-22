package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanoRepository;
import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepository iCiudadanoRepository;
	
	@Override
	public void guardarCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.insertarCiudadano(ciudadano);
	}

	@Override
	public void guardarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.insertarEmpleado(empleado);
	}

}
