package com.locadora.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.locadora.dto.FilmeDTO;
import com.locadora.entities.Filme;

@Component
public class FilmeConverter implements Converter<Filme, FilmeDTO> {

	@Override
	public Filme convertToEntity(FilmeDTO dto) {
		Filme entity = new Filme();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public FilmeDTO convertToDTO(Filme entity) {
		FilmeDTO dto = new FilmeDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
