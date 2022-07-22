package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;

public interface ICiudadanoRepository {

	public void insertarCiudadano(Ciudadano ciudadano);
	public void insertarEmpleado(Empleado empleado);
	
}
