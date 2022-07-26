package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.ILibroRepository;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private ILibroRepository iLibroRepository;

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.iLibroRepository.insertar(libro);
	}

	
	
	
}
