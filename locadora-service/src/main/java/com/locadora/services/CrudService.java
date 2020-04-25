package com.locadora.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.locadora.repositories.AbstractRepository;

@Transactional(propagation = Propagation.REQUIRED)
public abstract class CrudService<T> {
	
	@Autowired
	private AbstractRepository<T, Long> repository;

	public T createOrUpdate(T entity) {
		if (entity != null) {
			return repository.save(entity);
		}
		return null;
	}

	public T findById(Long id) {
		if (id != null) {
			return repository.findById(id).orElse(null);
		}
		return null;
	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public void deleteById(Long id) {
		if (id != null) {
			repository.deleteById(id);
		}
	}

	public void delete(T entity) {
		if (entity != null) {
			repository.delete(entity);
		}
	}
}
