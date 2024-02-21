package br.com.java.brasil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author devrsvieira
 * e-mail: devrsvieira@gmail.com
 * date: 02-20-2024
 */

public class Data {
	
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(formatadorData));
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora);
		DateTimeFormatter formatadorDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println(agora.format(formatadorDataHora));
		DateTimeFormatter formatadorCurto = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt","br"));
		DateTimeFormatter formatadorMedio = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt","br"));
		System.out.println(agora.format(formatadorCurto));
		System.out.println(agora.format(formatadorMedio));
		System.out.println(agora.minusHours(5).format(formatadorDataHora));
		System.out.println(agora.plusHours(12).format(formatadorDataHora));
		
	}

}
