package com.locadora.utils;

public class StringUtils {
	public static String formataCpf(String cpf) {
		String cpfFormat = cpf.replaceAll("[^0-9]", "");
		if (cpfFormat.length() != 11) {
			return cpfFormat;
		}
		return cpfFormat;
	}
}
