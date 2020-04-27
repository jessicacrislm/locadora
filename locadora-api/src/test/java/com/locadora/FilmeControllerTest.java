package com.locadora;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.server.LocalServerPort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.locadora.dto.FilmeDTO;
import com.locadora.enumerators.GeneroFilme;
import com.locadora.enumerators.TipoFilme;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class FilmeControllerTest {
	
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
	public void testCreateFilme() throws JsonProcessingException {
		FilmeDTO dto = new FilmeDTO();
		dto.setTitulo("Teste nome");
		dto.setGenero(GeneroFilme.COMEDIA);
		dto.setDiretor("Teste diretor");
		dto.setAnoLancamento(2019);
		dto.setQuantidade(2);
		dto.setTipo(TipoFilme.NORMAL);
		RestAssured.given().contentType(ContentType.JSON).body(mapper.writeValueAsString(dto)).post("/filme/").then().statusCode(201);
	}

}
