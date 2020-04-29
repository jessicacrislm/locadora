package com.locadora.enumerators;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum GeneroFilme {
	TERROR("Terror"), 
	AVENTURA("Aventura"), 
	COMEDIA("COMEDIA"), ROMANCE("Aventura"), ACAO("Aventura"), SUSPENSE("Aventura"), DRAMA("Aventura"), 
	ANIMACAO("Aventura"), MUSICAL("Aventura"), DOCUMENTARIO("Aventura"), FICCAO("Aventura");
	
	private final String genero;
	
	private GeneroFilme(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}
	
	public List<String> listarGeneros () {
		List<GeneroFilme> generos = Arrays.asList(GeneroFilme.values());
		return generos.stream().map(g -> g.getGenero()).collect(Collectors.toList());
	}
}
