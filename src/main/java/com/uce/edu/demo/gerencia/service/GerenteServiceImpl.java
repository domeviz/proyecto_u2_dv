package com.uce.edu.demo.gerencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.gerencia.modelo.Gerente;
import com.uce.edu.demo.gerencia.repository.IGerenteRepository;

@Service
public class GerenteServiceImpl implements IGerenteService {

	@Autowired
	private IGerenteRepository iGerenteRepository;

	@Override
	public void insertar(Gerente gerente) {
		// TODO Auto-generated method stub
		this.iGerenteRepository.insertar(gerente);
	}

	@Override
	public Gerente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iGerenteRepository.buscar(id);
	}

	@Override
	public void actualizar(Gerente gerente) {
		// TODO Auto-generated method stub
		this.iGerenteRepository.actualizar(gerente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iGerenteRepository.eliminar(id);
	}
	
	
}
