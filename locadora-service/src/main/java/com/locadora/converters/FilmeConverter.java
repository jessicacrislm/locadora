package com.locadora.converters;

import org.springframework.beans.BeanUtils;

import com.locadora.dto.FilmeDTO;
import com.locadora.entities.Filme;

public class FilmeConverter implements Converter<Filme, FilmeDTO> {

	@Override
	public Filme convertToEntity(FilmeDTO dto) {
		// TO DO: LOMBOK contructor
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
