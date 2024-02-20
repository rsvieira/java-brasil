/**
 * 
 */
package br.com.java.brasil;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.format.TituloEleitoralFormatter;

/**
 * @author devrsvieira
 * e-mail: devrsvieira@gmail.com
 * date: 02-19-2024
 */

public class FormatadorDocumento {
	
	public static void main(String[] args) {
		String cpf = "862.883.667-57";
		String cnpj = "98.610.832/0001-24";
		String tituloEleitor = "4174535301/16";
		
		String cpfSemFormatacao = desformatarDocumentos(new CPFFormatter(), cpf);
		String cnpjSemFormatacao = desformatarDocumentos(new CNPJFormatter(), cnpj);
		String tituloEleitorSemFormatacao = desformatarDocumentos(new TituloEleitoralFormatter(), tituloEleitor);
		
		String cpfFormatacaoRecuperada = formatarDocumentos(new CPFFormatter(), cpfSemFormatacao);
		String cnpjFormatacaoRecuperada = formatarDocumentos(new CNPJFormatter(), cnpjSemFormatacao);
		String tituloEleitorFormatacaoRecuperada = formatarDocumentos(new TituloEleitoralFormatter(), tituloEleitorSemFormatacao);
		
		System.out.println("CPF com mask : " + cpf);
		System.out.println("CNPJ com mask : " + cnpj);
		System.out.println("Titulo Eleitor com mask : " + tituloEleitor);
		System.out.println("");
		System.out.println("CPF sem formatação : " + cpfSemFormatacao);
		System.out.println("CNPJ sem formatação : " + cnpjSemFormatacao);
		System.out.println("Titulo Eleitor sem formatação : " + tituloEleitorSemFormatacao);
		System.out.println("");
		System.out.println("CPF com formatação recuperada : " + cpfFormatacaoRecuperada);
		System.out.println("CNPJ com formatação recuperada : " + cnpjFormatacaoRecuperada);
		System.out.println("Titulo Eleitor com formatação recuperada : " + tituloEleitorFormatacaoRecuperada);
		
	}
	
	private static String desformatarDocumentos(Formatter formatter, String documento) {
		return formatter.unformat(documento);
	}
	
	private static String formatarDocumentos(Formatter formatter, String documento) {
		return formatter.format(documento);
	}
}
