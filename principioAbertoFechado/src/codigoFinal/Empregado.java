package codigoFinal;

public class Empregado {
	private String nome;
	private String sobrenome;
	private String email;
	private Boolean gerente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isGerente(){
		return this.gerente;
	}

	public void setGerente(Boolean gerente) {
		this.gerente = gerente;
	}
}
