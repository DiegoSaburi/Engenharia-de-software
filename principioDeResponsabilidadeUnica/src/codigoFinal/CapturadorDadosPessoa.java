package codigoFinal;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapturadorDadosPessoa {
	public static Pessoa obterDadosPessoa() throws IOException {
		Pessoa pessoa = new Pessoa();
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		GerenciadorMensagens.mensagemSolicitarCampo("Primeiro nome");
		pessoa.setPrimeiroNome(teclado.readLine());

		GerenciadorMensagens.mensagemSolicitarCampo("Ultimo sobrenome");
		pessoa.setUltimoNome(teclado.readLine());

		return pessoa;
	}
}
