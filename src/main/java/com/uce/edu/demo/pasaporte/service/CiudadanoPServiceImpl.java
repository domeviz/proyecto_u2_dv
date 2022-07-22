package com.uce.edu.demo.pasaporte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uce.edu.demo.pasaporte.modelo.CiudadanoP;
import com.uce.edu.demo.pasaporte.repository.ICiudadanoPRepository;

@Service
public class CiudadanoPServiceImpl implements ICiudadanoPService {

	@Autowired
	private ICiudadanoPRepository iCiudadanoRepository;

	@Override
	public void insertar(CiudadanoP ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.insertar(ciudadano);
	}

	@Override
	public CiudadanoP buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(CiudadanoP ciudadano) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iCiudadanoRepository.eliminar(id);
	}
	

}
