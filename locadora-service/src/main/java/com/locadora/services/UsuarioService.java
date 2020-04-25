package com.locadora.services;

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

}