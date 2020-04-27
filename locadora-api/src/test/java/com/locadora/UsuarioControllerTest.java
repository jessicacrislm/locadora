package com.locadora;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.server.LocalServerPort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.locadora.dto.UsuarioDTO;
import com.locadora.enumerators.GeneroUsuario;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UsuarioControllerTest {
	
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
	public void testCreateUsuario() throws JsonProcessingException {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNome("Teste nome");
		dto.setSexo(GeneroUsuario.FEMININO);
		dto.setDataNascimento(new Date());
		dto.setCpf("20853523088");
		RestAssured.given().contentType(ContentType.JSON).body(mapper.writeValueAsString(dto)).post("/usuario/").then().statusCode(201);
	}
	
}
