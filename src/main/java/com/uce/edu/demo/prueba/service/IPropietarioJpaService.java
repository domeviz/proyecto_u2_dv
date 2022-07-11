package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.modelo.Propietario;

public interface IPropietarioJpaService {

	public void crearPropietario(Propietario propietario);
	
	public void eliminar(String cedula);
}
