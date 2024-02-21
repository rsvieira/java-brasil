package br.com.java.brasil;

import java.math.BigDecimal;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

/**
 * @author devrsvieira
 * e-mail: devrsvieira@gmail.com
 * date: 02-20-2024
 */

public class NumeroPorExtenso {

	public static void main(String[] args) {
		NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
		BigDecimal valor = new BigDecimal("209220922092209220922092209293481590123075.99");
		String valorPorExtenso = conversor.toWords(valor.doubleValue());
		System.out.println(valorPorExtenso);
	}
	
}
