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

/**
 * @author devrsvieira
 * e-mail: devrsvieira@gmail.com
 * date: 02-21-2024
 */

public class Dinheiro {
	
	public static void main(String[] args) {
		CurrencyUnit moeda = Monetary.getCurrency("BRL");
		MonetaryAmount valorDaParcela = Money.of(75, moeda);
		System.out.println(valorDaParcela);
		MonetaryAmount valorTotal = valorDaParcela.divide(12);
		System.out.println(valorTotal);
		
		CurrencyUnit dolar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		MonetaryAmount valorProdutoDolar = FastMoney.of(90, dolar);
		MonetaryAmount valorImpostoReal = FastMoney.of(30, real);
		
		ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.ECB);
		CurrencyConversion conversaoAtual = provider.getCurrencyConversion(dolar);
		
		MonetaryAmount valorImpostoDolar = conversaoAtual.apply(valorImpostoReal);
		MonetaryAmount valorFinalProdutoDolar = valorProdutoDolar.add(valorImpostoDolar);
		System.out.println(valorFinalProdutoDolar);
		
	}

}
