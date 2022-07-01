package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.to.EstudianteTo;

public interface IEstudianteJdbcRepository {

	public EstudianteTo buscarPorId(int id);
	
	public void insertar(EstudianteTo estudiante);
	
	public void actualizar(EstudianteTo estudiante);
	
	public void eliminar (int id);
	
}
