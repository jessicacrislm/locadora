package com.locadora.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.converters.LocacaoConverter;
import com.locadora.dto.LocacaoDTO;
import com.locadora.entities.Filme;
import com.locadora.entities.Locacao;
import com.locadora.entities.Usuario;
import com.locadora.enumerators.StatusLocacao;
import com.locadora.repositories.LocacaoRepository;
import com.locadora.services.AbstractService;
import com.locadora.services.LocacaoService;
import com.locadora.utils.ValidatorUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/locacao")
public class LocacaoController extends AbstractController<Locacao, LocacaoDTO, Long> {

	private static final String OK = "OK";

	@Autowired
	private LocacaoService service;

	@Autowired
	private LocacaoRepository repository;

	@Autowired
	private LocacaoConverter converter;

	@Override
	protected AbstractService<Locacao, LocacaoDTO, Long> getService() {
		return this.service;
	}

	@Override
	@PostMapping(value = "/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@Valid LocacaoDTO entity) {
		Locacao locacao = converter.convertToEntity(entity);
		if (OK.equals(validarLocacao(locacao).getBody())) {
			log.debug(" >> create entity {} ", entity);
			entity = getService().save(entity);
			log.debug(" << create entity {} ", entity);
		}
	}
	
	public void renovar(@Valid LocacaoDTO entity) {
		Locacao locacao = converter.convertToEntity(entity);
		if (OK.equals(validarRenovacao(locacao).getBody())) {
			Locacao renovacao = new Locacao();
			renovacao.setLocacaoPrincipal(locacao.getId());
			renovacao.setFilme(locacao.getFilme());
			renovacao.setUsuario(locacao.getUsuario());
			renovacao.setDataLocacao(new Date());
			renovacao.setDataDevolucao(DateUtils.addDays(new Date(),(locacao.getFilme().getTipo().getTipoDuracao().getDias())));
			renovacao.setStatus(StatusLocacao.RENOVADO);
			LocacaoDTO renovacaoDTO = converter.convertToDTO(renovacao);
			create(renovacaoDTO);
		}
	}
	
	@GetMapping(value = "/filme/{id}")
	public List<LocacaoDTO> getAllByFilme(@PathVariable Long id) {
		log.debug(">> getAll {}");
		List<LocacaoDTO> entities = service.findAllByFilme(id);
		log.debug("<< getAll [entities={}] ", entities);
		return entities;
	}
	
	@GetMapping(value = "/usuario/{id}")
	public List<LocacaoDTO> getAllByUsuario(@PathVariable Long id) {
		log.debug(">> getAll {}");
		List<LocacaoDTO> entities = service.findAllByUsuario(id);
		log.debug("<< getAll [entities={}] ", entities);
		return entities;
	}
	
	public ResponseEntity<String> validarRenovacao(Locacao locacao) {
		String control = OK;
		List<Locacao> locacoes = repository.findRenovacoesByLocacao(locacao.getId());
		if (CollectionUtils.size(locacoes) == 2) {
			return ResponseEntity.badRequest().body("Limite de renovações já atingido.");
		}
		return ResponseEntity.ok().body(control);
	}
	
	public ResponseEntity<String> validarLocacao(Locacao locacao) {
		String control = OK;
		if (!ValidatorUtils.validaDataDevolucao(locacao.getDataDevolucao())) {
			return ResponseEntity.badRequest().body("Escolha uma data de devolução a partir de amanhã.");
		}
		if (getQuantidadeDisponiveis(locacao.getFilme()) == 0) {
			return ResponseEntity.badRequest().body("Todos exemplares deste filme estão alugados.");
		}
		if (getQuantidadeLocados(locacao.getUsuario()) >= 5) {
			return ResponseEntity.badRequest().body("O usuário já possui atualmente 5 filmes alugados.");
		}
		return ResponseEntity.ok().body(control);
	}

	public int getQuantidadeLocados(Usuario usuario) {
		return repository.countByUsuario(usuario).size();
	}

	public int getQuantidadeDisponiveis(Filme filme) {
		int locados = repository.countByFilme(filme).size();
		int estoque = filme.getQuantidade();
		return estoque - locados;
	}

}
