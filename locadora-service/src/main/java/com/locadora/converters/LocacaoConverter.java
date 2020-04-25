package com.locadora.converters;

import org.springframework.beans.BeanUtils;

import com.locadora.dto.LocacaoDTO;
import com.locadora.entities.Locacao;

public class LocacaoConverter implements Converter<Locacao, LocacaoDTO> {
	
	@Override
	public Locacao convertToEntity(LocacaoDTO dto) {
		// TO DO: LOMBOK contructor
		Locacao entity = new Locacao();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public LocacaoDTO convertToDTO(Locacao entity) {
		LocacaoDTO dto = new LocacaoDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}
