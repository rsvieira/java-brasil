package br.com.java.brasil;

import java.io.IOException;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

/**
 * @author devrsvieira
 * e-mail: devrsvieira@gmail.com
 * date: 02-23-2024
 */

public class Cep {
	
	public static void main(String[] args) {
		ViaCEPClient cliente = new ViaCEPClient();
		try {
			ViaCEPEndereco endereco = cliente.getEndereco("41150000");
			
			System.out.println(endereco.getCep());
			System.out.println(endereco.getLogradouro());
			System.out.println(endereco.getComplemento());
			System.out.println(endereco.getBairro());
			System.out.println(endereco.getLocalidade());
			System.out.println(endereco.getUf());
			System.out.println(endereco.getIbge());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
