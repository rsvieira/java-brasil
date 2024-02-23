package br.com.java.brasil;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

/**
 * @author devrsvieira
 * e-mail: devrsvieira@gmail.com
 * date: 02-22-2024
 */

public class ValidaCPFCobranca {
	
	public static void main(String[] args) {
		String cpf = "51720155232";
		
		try {
			new CPFValidator().assertValid(cpf);
			
			CurrencyUnit real = Monetary.getCurrency("BRL");
			MonetaryAmount valorDaParcela = Money.of(900, real);
			NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
			
			System.out.println("Caro cliente. Sua fatura esse mês chegou no valor de " + conversor.toWords(valorDaParcela.getNumber().doubleValue()));
		}catch (InvalidStateException e) {
		    System.out.println("Olá cliente, favor entrar no nosso sistema e atualizar seus dados pois seu CPF é inválido." );
		}
		
		
	}

}
