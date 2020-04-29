package com.locadora.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.locadora.converters.Converter;
import com.locadora.converters.UsuarioConverter;
import com.locadora.dto.UsuarioDTO;
import com.locadora.entities.Usuario;
import com.locadora.repositories.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioService  extends AbstractService<Usuario, UsuarioDTO, Long> {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioConverter converter;
	
	@Override
	protected JpaRepository<Usuario, Long> getRepository() {
		return repository;
	}
	
	@Override
	protected Converter<Usuario, UsuarioDTO> getConverter() {
		return this.converter;
	}
	
	/**
	 * Buscar lista de usuários por filtro de nome
	 * @param nome string que filtra a pesquisa
	 * @return lista de usuários filtrada por nome
	 */
	public List<UsuarioDTO> findAllByNome(String nome) {
		List<Usuario> entities = repository.findAllByNome(nome);
		log.debug(">> findAllByNome [entities={}] ", entities);
		List<UsuarioDTO> dtos = entities.parallelStream().map(entity -> converter.convertToDTO(entity)).collect(Collectors.toList());
		log.debug(">> findAllByNome [dtos={}] ", dtos);
		return dtos;
	}
	
	/**
	 * Buscar usuário por cpf
	 * @param cpf string que filtra a pesquisa  por cpf
	 * @return usuario filtrado
	 */
	public UsuarioDTO findUsuarioByCpf (String cpf) {
		log.debug(">> findUsuarioByCpf [cpf={}] ", cpf);
		Usuario entity = repository.findUsuarioByCpf(cpf);
		log.debug("<< findUsuarioByCpf [cpf={}, entity={}] ", cpf, entity);
		UsuarioDTO dto = Objects.nonNull(entity) ? converter.convertToDTO(entity) : new UsuarioDTO();
		log.debug("<< findUsuarioByCpf [cpf={}, entity={}, UsuarioDTO={}] ", cpf, entity, dto);
		return dto;
	}

}