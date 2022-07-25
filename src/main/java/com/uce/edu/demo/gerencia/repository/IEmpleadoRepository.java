package com.uce.edu.demo.gerencia.repository;

import com.uce.edu.demo.gerencia.modelo.Empleados;

public interface IEmpleadoRepository {

	public void insertar(Empleados empleado);
	public Empleados buscar(Integer id);
	public void actualizar(Empleados empleado);
	public void eliminar (Integer id);
	
}
