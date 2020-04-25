package com.locadora.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.locadora.dto.UsuarioDTO;
import com.locadora.entities.Usuario;

@Component
public class UsuarioConverter implements Converter<Usuario, UsuarioDTO> {

	@Override
	public Usuario convertToEntity(UsuarioDTO dto) {
		// TO DO: LOMBOK contructor
		Usuario entity = new Usuario();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public UsuarioDTO convertToDTO(Usuario entity) {
		UsuarioDTO dto = new UsuarioDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
