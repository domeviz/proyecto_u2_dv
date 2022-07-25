package com.uce.edu.demo.gerencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.gerencia.modelo.Empleados;
import com.uce.edu.demo.gerencia.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository iEmpleadoRepository;

	@Override
	public void insertar(Empleados empleado) {
		// TODO Auto-generated method stub
		this.iEmpleadoRepository.insertar(empleado);
	}

	@Override
	public Empleados buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iEmpleadoRepository.buscar(id);
	}

	@Override
	public void actualizar(Empleados empleado) {
		// TODO Auto-generated method stub
		this.iEmpleadoRepository.actualizar(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iEmpleadoRepository.eliminar(id);
	}
	

}
