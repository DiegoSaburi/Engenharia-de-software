package codigoFinal;

public class CriadorConta {
	public static void criar(Pessoa pessoa){
		System.out.println("Seu id de usu�rio � " + pessoa.getPrimeiroNome().charAt(0) + pessoa.getUltimoNome());
	}
}
