package com.locadora.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.converters.UsuarioConverter;
import com.locadora.dto.UsuarioDTO;
import com.locadora.entities.Usuario;
import com.locadora.services.AbstractService;
import com.locadora.services.UsuarioService;
import com.locadora.utils.LocadoraStringUtils;
import com.locadora.utils.ValidatorUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends AbstractController<Usuario, UsuarioDTO, Long> {

	private static final String OK = "OK";

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioConverter converter;

	@Override
	protected AbstractService<Usuario, UsuarioDTO, Long> getService() {
		return this.service;
	}

	@Override
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@Valid @RequestBody UsuarioDTO dto) {
		Usuario usuario = converter.convertToEntity(dto);
		log.debug(" >> create entity {} ", dto);
		if (OK.equals(validarUsuario(usuario).getBody())) {
			dto = getService().save(dto);
		}
		log.debug(" << create entity {} ", dto);

	}	
	
	public ResponseEntity<String> validarUsuario(Usuario usuario) {
		if (!LocadoraStringUtils.isCpf(usuario.getCpf())) {
			return ResponseEntity.badRequest().body("CPF invalido!");
		}
		if (usuario.getDataNascimento() != null && !ValidatorUtils.validaDataNascimento(usuario.getDataNascimento())) {
			return ResponseEntity.badRequest().body("Data de nascimento invalida!");
		}
		if (usuario.getDataNascimento() != null && !ValidatorUtils.isMaioridade(usuario.getDataNascimento())) {
			return ResponseEntity.badRequest().body("O usuario deve ser maior de idade!");
		}
		return ResponseEntity.ok().body(OK);
	}
	
	@GetMapping(value = "/findAllByFilter/{filter}")
	public List<UsuarioDTO> findAllByFilter(@PathVariable String filter) {
		String tipoFiltro = validarFiltro(filter);
		List<UsuarioDTO> dtos = new ArrayList<>();
		log.debug(">> findAllByFilter [filter={}] ", filter);
		if ("CPF".equals(tipoFiltro)) {
			dtos.add(service.findUsuarioByCpf(filter.toLowerCase()));
		} else if ("NOME".equals(tipoFiltro)) {
			dtos = service.findAllByNome("%".concat(filter.toLowerCase()).concat("%"));
		} else if ("INICIAL".equals(tipoFiltro)) {
			dtos = service.findAllByNome(filter.toLowerCase().concat("%"));
		}
		log.debug("<< findAllByFilter [filter={}, dtos={}] ", filter, dtos);
		return dtos;
	}
	
	public String validarFiltro(String filtro) {
		String result = "";
		
		if (LocadoraStringUtils.isCpf(filtro)) {
			result = "CPF";
		} else if (LocadoraStringUtils.isNomeOuDescricao(filtro)) {
			result = "NOME";
		} else if (LocadoraStringUtils.isFiltroInicial(filtro)) {
			result = "INICIAL";
		}
		
		return result;
	}



}
