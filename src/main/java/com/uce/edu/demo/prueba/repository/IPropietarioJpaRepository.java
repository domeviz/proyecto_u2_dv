package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.modelo.Propietario;

public interface IPropietarioJpaRepository {

	public void insertar(Propietario propietario);
	
	public void eliminar(String cedula);

	public Propietario buscar(String cedula);
	
}
