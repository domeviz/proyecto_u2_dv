package com.uce.edu.demo.gerencia.service;

import com.uce.edu.demo.gerencia.modelo.Gerente;

public interface IGerenteService {

	public void insertar(Gerente gerente);
	public Gerente buscar(Integer id);
	public void actualizar(Gerente gerente);
	public void eliminar (Integer id);
}
