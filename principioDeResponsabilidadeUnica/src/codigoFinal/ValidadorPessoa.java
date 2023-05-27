package codigoFinal;

public class ValidadorPessoa {
	public static boolean validar(Pessoa pessoa){
		if (pessoa.getPrimeiroNome().isEmpty()){
			GerenciadorMensagens.mensagemErroValidacao("Primeiro nome");
			return false;
		}
		if (pessoa.getUltimoNome().isEmpty()){
			GerenciadorMensagens.mensagemErroValidacao("Ultimo  nome");
			return false;
		}
		return true;
	}
}
