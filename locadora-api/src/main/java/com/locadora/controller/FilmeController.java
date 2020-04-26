package com.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.dto.FilmeDTO;
import com.locadora.entities.Filme;
import com.locadora.services.AbstractService;
import com.locadora.services.FilmeService;

@RestController
@RequestMapping("/api/filme")
public class FilmeController extends AbstractController<Filme, FilmeDTO, Long> {
	
	@Autowired
	private FilmeService service;

	@Override
	protected AbstractService<Filme, FilmeDTO, Long> getService() {
		return this.service;
	}
	

}
