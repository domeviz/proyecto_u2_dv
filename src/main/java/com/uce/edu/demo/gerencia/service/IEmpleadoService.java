package com.uce.edu.demo.gerencia.service;

import com.uce.edu.demo.gerencia.modelo.Empleados;

public interface IEmpleadoService {

	public void insertar(Empleados empleado);
	public Empleados buscar(Integer id);
	public void actualizar(Empleados empleado);
	public void eliminar (Integer id);
}
