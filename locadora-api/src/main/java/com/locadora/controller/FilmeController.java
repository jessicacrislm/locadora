package com.locadora.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.dto.FilmeDTO;
import com.locadora.entities.Filme;
import com.locadora.services.AbstractService;
import com.locadora.services.FilmeService;
import com.locadora.utils.LocadoraStringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/filme")
public class FilmeController extends AbstractController<Filme, FilmeDTO, Long> {
	
	@Autowired
	private FilmeService service;

	@Override
	protected AbstractService<Filme, FilmeDTO, Long> getService() {
		return this.service;
	}
	
	@GetMapping("/findAllByFilter")
	public List<FilmeDTO> findAllByFilter(@RequestParam("filter") String filter) {
		String tipoFiltro = validarFiltro(filter);
		List<FilmeDTO> dtos = new ArrayList<>();
		log.debug(">> findAllByFilter [filter={}] ", filter);
		if ("ANO".equals(tipoFiltro)) {
			dtos.addAll(service.findAllByAno(Integer.valueOf(filter.trim())));
		} else if ("DESCRICAO".equals(tipoFiltro)) {
			dtos.addAll(service.findAllByTitulo(filter.toLowerCase(), true));
			dtos.addAll(service.findAllByDiretor(filter.toLowerCase(), true));
			
			//dtos.addAll(service.findAllByGenero());
		} else if ("INICIAL".equals(tipoFiltro)) {
			dtos.addAll(service.findAllByTitulo(filter.toLowerCase(), false));
			dtos.addAll(service.findAllByDiretor(filter.toLowerCase(), false));
			//dtos.addAll(service.findAllByGenero(LocadoraStringUtils.normalize(filter).toLowerCase().concat("%")));
		}
		log.debug("<< findAllByFilter [filter={}, dtos={}] ", filter, dtos);
		return dtos;
	}
	
	public String validarFiltro(String filtro) {
		String result = "";
		
		if (LocadoraStringUtils.isFiltroAno(filtro)) {
			result = "ANO";
		} else if (LocadoraStringUtils.isNomeOuDescricao(filtro)) {
			result = "DESCRICAO";
		} else if (LocadoraStringUtils.isFiltroInicial(filtro)) {
			result = "INICIAL";
		}
		
		return result;
	}

}
