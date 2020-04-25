package com.locadora.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.locadora.converters.Converter;
import com.locadora.converters.LocacaoConverter;
import com.locadora.dto.LocacaoDTO;
import com.locadora.entities.Locacao;
import com.locadora.repositories.LocacaoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LocacaoService extends AbstractService<Locacao, LocacaoDTO, Long> {
	
	@Autowired LocacaoRepository repository;
	
	@Autowired
	private LocacaoConverter converter;

	@Override
	protected JpaRepository<Locacao, Long> getRepository() {
		return repository;
	}

	@Override
	protected Converter<Locacao, LocacaoDTO> getConverter() {
		return this.converter;
	} 
	
	

}
