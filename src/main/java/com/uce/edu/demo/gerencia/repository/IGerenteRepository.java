package com.uce.edu.demo.gerencia.repository;

import com.uce.edu.demo.gerencia.modelo.Gerente;

public interface IGerenteRepository {

	public void insertar(Gerente gerente);
	public Gerente buscar(Integer id);
	public void actualizar(Gerente gerente);
	public void eliminar (Integer id);
	
}
