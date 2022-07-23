package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;
import com.uce.edu.demo.repository.modelo.onetoone.Empleado;

public interface ICiudadanoService {

	public void guardarCiudadano(Ciudadano ciudadano);
	public void guardarEmpleado(Empleado empleado);
}
