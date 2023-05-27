package codigoFinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Seja bem-vinda ou bem-vindo.");

		Pessoa usuario = CapturadorDadosPessoa.obterDadosPessoa();

		
		if (!ValidadorPessoa.validar(usuario)){
			GerenciadorMensagens.mensagemFimPrograma();
		}
		else {
			CriadorConta.criar(usuario);
		}
	}
}