package com.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.dto.LocacaoDTO;
import com.locadora.entities.Locacao;
import com.locadora.services.AbstractService;
import com.locadora.services.LocacaoService;

@RestController
@RequestMapping("/locacao")
public class LocacaoController extends AbstractController<Locacao, LocacaoDTO, Long> {

	@Autowired
	private LocacaoService service;

	@Override
	protected AbstractService<Locacao, LocacaoDTO, Long> getService() {
		return this.service;

	}

}
