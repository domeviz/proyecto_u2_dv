package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;

public interface ICiudadanoService {

	public void guardarCiudadano(Ciudadano ciudadano);
	public void guardarEmpleado(Empleado empleado);
}
