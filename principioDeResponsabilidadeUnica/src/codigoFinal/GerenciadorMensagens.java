package codigoFinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GerenciadorMensagens {
	public static void mensagemBoasVindas(){
		System.out.println("Seja bem-vindx");
	}

	public static void mensagemFimPrograma() throws IOException {
		System.out.println("aperte enter para sair");
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		teclado.readLine();
	}

	public static void mensagemSolicitarCampo(String campo){
		System.out.println("Qual o seu " + campo + "?");
	}

	public static void mensagemErroValidacao(String campo){
		System.out.println("Vc n forneceu um " + campo + " Valido");
	}

}
