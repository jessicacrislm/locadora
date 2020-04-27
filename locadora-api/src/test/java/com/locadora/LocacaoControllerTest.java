package com.locadora;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.server.LocalServerPort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.locadora.dto.FilmeDTO;
import com.locadora.dto.LocacaoDTO;
import com.locadora.dto.UsuarioDTO;
import com.locadora.enumerators.StatusLocacao;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class LocacaoControllerTest {

	private ObjectMapper mapper = new ObjectMapper();

	@LocalServerPort
	private int porta;
	
	@Before
	public void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.basePath = "/api";
		RestAssured.port = porta;
	}
	
	@Test
	public void testCreateLocacao() throws JsonProcessingException {
		LocacaoDTO dto = new LocacaoDTO();
		dto.setFilme(new FilmeDTO());
		dto.setUsuario(new UsuarioDTO());
		dto.setDataLocacao(new Date());
		dto.setDataDevolucao(null);
		dto.setStatus(StatusLocacao.ABERTO);
		RestAssured.given().contentType(ContentType.JSON).body(mapper.writeValueAsString(dto)).post("/locacao/").then().statusCode(201);
	}
}
