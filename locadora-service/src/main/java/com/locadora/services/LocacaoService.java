package com.locadora.services;

import java.util.List;
import java.util.stream.Collectors;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	/**
	 * Historico de locacoes de um determinado filme
	 * @param id o id do filme a ser pesquisado
	 * @return lista de locacoes de um filme
	 */
	public List<LocacaoDTO> findAllByFilme(Long id) {	
		List<Locacao> entities = repository.findAllByFilme(id);
		log.debug(">> findAllByFilme [entities={}] ", entities);
		List<LocacaoDTO> dtos = entities.parallelStream().map(entity -> getConverter().convertToDTO(entity)).collect(Collectors.toList());
		log.debug("<< findAllByFilme [entities={}] ", entities);
		return dtos;
	}

	/**
	 * Historico de locacoes de um determinado usuario
	 * @param id o id do usuario a ser pesquisado
	 * @return lista de locacoes de um usuario
	 */
	public List<LocacaoDTO> findAllByUsuario(Long id) {
		List<Locacao> entities = repository.findAllByUsuario(id);
		log.debug(">> findAllByUsuario [entities={}] ", entities);
		List<LocacaoDTO> dtos = entities.parallelStream().map(entity -> getConverter().convertToDTO(entity)).collect(Collectors.toList());
		log.debug("<< findAllByUsuario [entities={}] ", entities);
		return dtos;
	}

}
