package com.uce.edu.demo.jdbcestudiante.service;

import com.uce.edu.demo.jdbcestudiante.to.Estudiante;

public interface IEstudianteJdbcService {

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(int id);

	public Estudiante buscarPorId(int id);
	
}
