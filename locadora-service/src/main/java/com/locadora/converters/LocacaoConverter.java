package com.locadora.converters;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.locadora.dto.LocacaoDTO;
import com.locadora.entities.Filme;
import com.locadora.entities.Locacao;
import com.locadora.entities.Usuario;
import com.locadora.repositories.FilmeRepository;
import com.locadora.repositories.UsuarioRepository;

@Component
public class LocacaoConverter implements Converter<Locacao, LocacaoDTO> {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	@Autowired
	private FilmeConverter filmeConverter;
	
	@Autowired 
	private UsuarioConverter usuarioConverter;
	
	@Override
	public Locacao convertToEntity(LocacaoDTO dto) {
		Locacao entity = new Locacao();
		BeanUtils.copyProperties(dto, entity);
		Filme filme = filmeRepository.getOne(dto.getIdFilme());
		Usuario usuario = usuarioRepository.getOne(dto.getIdUsuario());
		entity.setFilme(filme);
		entity.setUsuario(usuario);
		return entity;
	}

	@Override
	public LocacaoDTO convertToDTO(Locacao entity) {
		LocacaoDTO dto = new LocacaoDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setIdFilme(filmeConverter.convertToDTO(entity.getFilme()).getId());
		dto.setIdUsuario(usuarioConverter.convertToDTO(entity.getUsuario()).getId());
		dto.setLocacoes(entity.getLocacoes().parallelStream().map(this::convertToDTO).collect(Collectors.toList()));
		return dto;
	}


}
