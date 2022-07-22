package com.uce.edu.demo.pasaporte.service;

import com.uce.edu.demo.pasaporte.modelo.CiudadanoP;

public interface ICiudadanoPService {

	public void insertar(CiudadanoP ciudadano);
	
	public CiudadanoP buscarPorId(Integer id);
	
	public void actualizar(CiudadanoP ciudadano);

	public void eliminar(Integer id);
}
