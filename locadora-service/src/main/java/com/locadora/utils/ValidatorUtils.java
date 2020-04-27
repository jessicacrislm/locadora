package com.locadora.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

public class ValidatorUtils {

	public static boolean validacpf(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11) || (cpf.trim().isEmpty())) {
			return false;
		}

		char dig10, dig11;
		int sm, i, r, num, peso;
		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11)) {
				dig10 = '0';
			} else {
				dig10 = (char) (r + 48);
			}
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11)) {
				dig11 = '0';
			} else {
				dig11 = (char) (r + 48);
			}

			return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
		} catch (InputMismatchException erro) {
			return false;
		}
	}

	public static boolean validaDataNascimento(Date dataNascimento) {
		Date dataAtual = new Date();
		return dataNascimento.after(dataAtual);
	}

	public static boolean validaDataDevolucao(Date dataDevolucao) {
		Date dataAtual = new Date();
		return dataDevolucao.before(dataAtual);

	}

	public static boolean isMaioridade(Date dataNascimento) {
		Calendar cAtual = Calendar.getInstance();
		Calendar cNasc = Calendar.getInstance();
		cAtual.setTime(new Date());
		cNasc.setTime(dataNascimento);

		int idade = cAtual.get(Calendar.YEAR) - cNasc.get(Calendar.YEAR);

		// checar se já aniversariou esse ano
		if ((idade == 18) && (cAtual.get(Calendar.MONTH) < cNasc.get(Calendar.MONTH))
				|| ((cAtual.get(Calendar.MONTH) == cNasc.get(Calendar.MONTH))
						&& cAtual.get(Calendar.DAY_OF_MONTH) < cNasc.get(Calendar.DAY_OF_MONTH))) {
			idade--;
		}

		return idade >= 18;
	}

}
