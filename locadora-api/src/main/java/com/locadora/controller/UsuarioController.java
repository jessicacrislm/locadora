package com.locadora.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.locadora.utils.StringUtils;
import com.locadora.utils.ValidatorUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/usuario")
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
	@SuppressWarnings("unlikely-arg-type")
	@PostMapping(value = "/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@Valid @RequestBody UsuarioDTO dto) {
		Usuario usuario = converter.convertToEntity(dto);
		log.debug(" >> create entity {} ", dto);
		if (OK.equals(validar(usuario))) {
			dto = getService().save(dto);
		}
		log.debug(" << create entity {} ", dto);

	}

	public ResponseEntity<String> validar(Usuario usuario) {
		String cpfFormat = StringUtils.formataCpf(usuario.getCpf());
		if (cpfFormat != null && !ValidatorUtils.validacpf(cpfFormat)) {
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

}
