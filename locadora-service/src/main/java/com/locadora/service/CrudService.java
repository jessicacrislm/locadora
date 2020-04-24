package com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public abstract class CrudService<T> {
	@Autowired
	private JpaRepository<T, Long> repository;

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
