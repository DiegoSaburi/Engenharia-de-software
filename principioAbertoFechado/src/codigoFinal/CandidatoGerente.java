package codigoFinal;

public class CandidatoGerente implements ICandidato{

	private String nome;
	private String sobrenome;
	private TipoCandidato tipoCandidato = TipoCandidato.GENERICO;

	public CandidatoGerente(String nome, String sobrenome, TipoCandidato tipoCandidato){
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipoCandidato = tipoCandidato;
	}

	public CandidatoGerente(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public String getSobrenome() {
		return sobrenome;
	}

	@Override
	public ICriadorConta obterCriadorConta() {
		return new CriadorContasGerente();
	}

	public TipoCandidato getTipoCandidato() {
		return tipoCandidato;
	}

	public void setTipoCandidato(TipoCandidato tipoCandidato) {
		this.tipoCandidato = tipoCandidato;
	}
}
