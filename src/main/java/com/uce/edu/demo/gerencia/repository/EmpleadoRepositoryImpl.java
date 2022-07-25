package com.uce.edu.demo.gerencia.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.gerencia.modelo.Empleados;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Empleados empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

	@Override
	public Empleados buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleados.class, id);
	}

	@Override
	public void actualizar(Empleados empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}
	
	

}
