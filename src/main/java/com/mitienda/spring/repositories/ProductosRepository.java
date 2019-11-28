package com.mitienda.spring.repositories;


import org.springframework.data.repository.CrudRepository;

import com.mitienda.spring.models.Producto;
public interface ProductosRepository extends CrudRepository<Producto, Long>{

}
