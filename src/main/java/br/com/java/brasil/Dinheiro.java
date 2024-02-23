package br.com.java.brasil;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.convert.ExchangeRateType;
import org.javamoney.moneta.function.MonetaryOperators;

import br.com.caelum.stella.inwords.FormatoDeInteiro;
import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

/**
 * @author devrsvieira
 * e-mail: devrsvieira@gmail.com
 * date: 02-21-2024
 */

public class Dinheiro {
	
	public static void main(String[] args) {
		// criando a moeda dolar e real
		CurrencyUnit dolar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		// criando o valor de 75 reais
		MonetaryAmount valorDaParcela = Money.of(75, real);
		System.out.println(valorDaParcela);
		// multiplicando o valor de 75 reais por 12
		MonetaryAmount valorTotal = valorDaParcela.multiply(12);
		System.out.println(valorTotal);
		
		// criando valores em dolar e real para cotação
		MonetaryAmount valorProdutoDolar = FastMoney.of(90, dolar);
		MonetaryAmount valorImpostoReal = FastMoney.of(30, real);
		// pegando a cotação atual
		ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.ECB);
		CurrencyConversion conversaoAtual = provider.getCurrencyConversion(dolar);
		// calculando imposto
		MonetaryAmount valorImpostoDolar = conversaoAtual.apply(valorImpostoReal);
		MonetaryAmount valorFinalProdutoDolar = valorProdutoDolar.add(valorImpostoDolar);
		System.out.println(valorFinalProdutoDolar);
		// aplicando desconto e convertendo por extenso usando a stella
		MonetaryAmount desconto = valorTotal.with(MonetaryOperators.percent(10));
		System.out.println(desconto);
		NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
		
		System.out.println(conversor.toWords(desconto.getNumber().doubleValue()));
		
	}

}
