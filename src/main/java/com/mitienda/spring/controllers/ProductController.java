package com.mitienda.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mitienda.spring.models.Categoria;
import com.mitienda.spring.models.Producto;
import com.mitienda.spring.repositories.ProductosRepository;

public class ProductController {

	private static ProductController instance;
	
	private ProductController() {
	}

	public static ProductController getInstance() {
		if (instance == null) {
			instance = new ProductController();
		}
		return instance;
	}
	
	@Autowired
	private ProductosRepository repository;
	
	public Producto save(Producto cat) {
		return repository.save(cat);
	}
	
	public long count() {
		return repository.count();
	}
	
	public List<Producto> list() { 
		ArrayList<Producto> ret = new ArrayList<>();
	    for(Producto t : repository.findAll()) {
	        ret.add(t);
	    }
	    return ret;
	}
	
}
