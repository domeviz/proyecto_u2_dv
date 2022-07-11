package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.IPropietarioJpaRepository;

@Service
public class PropietarioJpaServiceImpl implements IPropietarioJpaService{

	@Autowired
	private IPropietarioJpaRepository iPropietarioRepository;
	
	@Override
	public void crearPropietario(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.insertar(propietario);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.eliminar(cedula);
	}

}
