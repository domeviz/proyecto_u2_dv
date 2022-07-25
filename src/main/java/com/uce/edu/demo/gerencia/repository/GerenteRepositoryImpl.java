package com.uce.edu.demo.gerencia.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.gerencia.modelo.Gerente;

@Repository
@Transactional
public class GerenteRepositoryImpl implements IGerenteRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Gerente gerente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(gerente);
	}

	@Override
	public Gerente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Gerente.class, id);
	}

	@Override
	public void actualizar(Gerente gerente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(gerente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}
	
}
