package com.locadora.services;

import java.util.List;
import java.util.stream.Collectors;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	/**
	 * Buscar lista de filmes por filtro de titulo
	 * @param filter string que filtra a pesquisa
	 * @return lista de filmes filtrada por titulo
	 */
	public List<FilmeDTO> findAllByTitulo(String titulo, boolean isDescricao) {
		List<Filme> entities = isDescricao ? repository.findAllByTitulo(titulo) : repository.findAllByInicialTitulo(titulo);
		log.debug(">> findAllByTitulo [entities={}] ", entities);
		List<FilmeDTO> dtos = entities.parallelStream().map(entity -> converter.convertToDTO(entity)).collect(Collectors.toList());
		log.debug(">> findAllByTitulo [dtos={}] ", dtos);
		return dtos;
	}
	
	/**
	 * Buscar lista de filmes por filtro de genero
	 * @param filter string que filtra a pesquisa
	 * @return lista de filmes filtrada por genero
	 */
	public List<FilmeDTO> findAllByGenero(String genero) {
		List<Filme> entities = repository.findAllByGenero(genero);
		log.debug(">> findAllByGenero [entities={}] ", entities);
		List<FilmeDTO> dtos = entities.parallelStream().map(entity -> converter.convertToDTO(entity)).collect(Collectors.toList());
		log.debug(">> findAllByGenero [dtos={}] ", dtos);
		return dtos;
	}
	
	/**
	 * Buscar lista de filmes por filtro de diretor
	 * @param filter string que filtra a pesquisa
	 * @return lista de filmes filtrada por diretor
	 */
	public List<FilmeDTO> findAllByDiretor(String diretor, boolean isDescricao) {
		List<Filme> entities = isDescricao ? repository.findAllByDiretor(diretor) : repository.findAllByInicialDiretor(diretor);
		log.debug(">> findAllByDiretor [entities={}] ", entities);
		List<FilmeDTO> dtos = entities.parallelStream().map(entity -> converter.convertToDTO(entity)).collect(Collectors.toList());
		log.debug(">> findAllByDiretor [dtos={}] ", dtos);
		return dtos;
	}
	/**
	 * Buscar lista de filmes por filtro de ano
	 * @param filter string que filtra a pesquisa
	 * @return lista de filmes filtrada por ano
	 */
	public List<FilmeDTO> findAllByAno(int ano) {
		List<Filme> entities = repository.findAllByAno(ano);
		log.debug(">> findAllByAno [entities={}] ", entities);
		List<FilmeDTO> dtos = entities.parallelStream().map(entity -> converter.convertToDTO(entity)).collect(Collectors.toList());
		log.debug(">> findAllByAno [dtos={}] ", dtos);
		return dtos;
	}

}
