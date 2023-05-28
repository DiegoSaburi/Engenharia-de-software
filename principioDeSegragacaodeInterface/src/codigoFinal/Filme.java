package codigoFinal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Filme implements IItemBiblioteca, IFilme, ITempoDeDuracao, IEmprestavel {
    public String idItemBiblioteca;
    public String titulo;
    public int duracaoEmprestimoEmDias = 21;
    public String usuarioEmprestimo;
    public LocalDateTime dataEmprestimo;
    public int duracaoEmMinutos;
    public List<String> atores = new ArrayList<String>();

	@Override
    public void emprestar(String usuarioEmprestimo) {
        this.usuarioEmprestimo = usuarioEmprestimo;
        this.dataEmprestimo = LocalDateTime.now();
    }

	@Override
    public void devolver() {
        this.usuarioEmprestimo = "";
    }

	@Override
    public LocalDateTime getDataDevolver() {
        return dataEmprestimo.plusDays(duracaoEmprestimoEmDias);
    }

	@Override
	public String getIdItemBiblioteca() {
		return idItemBiblioteca;
	}

	@Override
	public void setIdItemBiblioteca(String idItemBiblioteca) {
		this.idItemBiblioteca = idItemBiblioteca;
	}

	@Override
	public String getTitulo() {
		return titulo;
	}

	@Override
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public int getDuracaoEmprestimoEmDias() {
		return duracaoEmprestimoEmDias;
	}

	@Override
	public void setDuracaoEmprestimoEmDias(int duracaoEmprestimoEmDias) {
		this.duracaoEmprestimoEmDias = duracaoEmprestimoEmDias;
	}
	@Override
	public String getUsuarioEmprestimo() {
		return usuarioEmprestimo;
	}

	@Override
	public void setUsuarioEmprestimo(String usuarioEmprestimo) {
		this.usuarioEmprestimo = usuarioEmprestimo;
	}

	@Override
	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}

	@Override
	public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	@Override
	public int getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	@Override
	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	@Override
	public List<String> getAtores() {
		return atores;
	}

	@Override
	public void setAtores(List<String> atores) {
		this.atores = atores;
	}
}
