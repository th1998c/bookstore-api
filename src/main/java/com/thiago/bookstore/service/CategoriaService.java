package com.thiago.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.bookstore.domain.Categoria;
import com.thiago.bookstore.repositories.CategoriaRepository;
import com.thiago.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(""
				+ "Objeto não encontrado! Id:" + id + ", Tipo: "+ Categoria.class.getName()));
	}
}
