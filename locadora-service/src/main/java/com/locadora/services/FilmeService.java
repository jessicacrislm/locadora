package com.locadora.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.locadora.converters.Converter;
import com.locadora.converters.FilmeConverter;
import com.locadora.dto.FilmeDTO;
import com.locadora.entities.Filme;
import com.locadora.repositories.FilmeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FilmeService extends AbstractService<Filme, FilmeDTO, Long> {

	@Autowired
	private FilmeRepository repository;
	
	@Autowired
	private FilmeConverter converter;

	@Override
	protected JpaRepository<Filme, Long> getRepository() {
		return repository;
	}

	@Override
	protected Converter<Filme, FilmeDTO> getConverter() {
		return this.converter;
	}
	
}
