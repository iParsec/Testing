package com.crud.test.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

public abstract class __CrudService<T> {
	
	public abstract ResponseEntity<T> create(T object);

    public abstract ResponseEntity<T> update(T object,Long id);

    public abstract ResponseEntity<List<T>> findAll();

    public abstract ResponseEntity<T> findById(Long id);
    
    public abstract ResponseEntity<T> deleteById(Long id);
    
}
