package com.locadora.utils;

import java.text.Normalizer;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class LocadoraStringUtils {
	public static String formataCpf(String cpf) {
		String cpfFormat = cpf.replaceAll("[^0-9]", "");
		if (cpfFormat.length() != 11) {
			return cpfFormat;
		}
		return cpfFormat;
	}
	
	public static boolean isCpf(String str) {
		String cpf = formataCpf(StringUtils.trim(str));
		return StringUtils.isNotBlank(cpf) && ValidatorUtils.validacpf(cpf);
	}
	
	public static boolean isFiltroInicial(String str) {
		String strTrim = StringUtils.trim(str);
		return StringUtils.isNotBlank(strTrim) && strTrim.length() < 3;
	}
	
	public static boolean isNomeOuDescricao(String str) {
		String strTrim = StringUtils.trim(str);
		return StringUtils.isNotBlank(strTrim) && strTrim.length() > 3;
	}
	
	public static boolean isFiltroComposto(String str) {
		String strTrim = StringUtils.trim(str);
		String[] arrayStr = StringUtils.split(strTrim, ',');
		return StringUtils.isNotBlank(strTrim) && CollectionUtils.size(arrayStr) > 1;
	}
	
	public static boolean isFiltroAno(String str) {
		return StringUtils.isNotBlank(str) 
				&& str.trim().length() == 4 
				&& StringUtils.isNumeric(str);
	}
	
	/**
	 * Remove da string os acentos e cedilhas.<br/><br/>
	 * Uma string nula ou em branco retorna uma string vazia.
	 * 
	 * <pre>
     * StringUtil.normalize(null)        = ""
     * StringUtil.normalize("")          = ""
     * StringUtil.normalize(" ")         = ""
     * StringUtil.normalize("instrüção") = "instrucao"
     * StringUtil.normalize("éçàô")      = "ecao"
     * </pre>
     * 
	 * @param str1 String original
	 * @return string normalizada
	 */
	public static String normalize(String str1) {
		if (StringUtils.isBlank(str1)) {
			return StringUtils.EMPTY;
		}
		str1 = Normalizer.normalize(str1, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""); 
		return str1;
	}
}
