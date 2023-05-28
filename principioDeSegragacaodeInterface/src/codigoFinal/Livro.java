package codigoFinal;

import java.time.LocalDateTime;

public class Livro implements IItemBiblioteca, IEmprestavel, ILivroTradicional, IAutoral {
    public String idItemBiblioteca;
    public String titulo;
    public String autor;
    public int numeroPaginas;
    public int duracaoEmprestimoEmDias = 21;
    public String usuarioEmprestimo;
    public LocalDateTime dataEmprestimo;

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
	public String getAutor() {
		return autor;
	}

	@Override
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	@Override
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
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
}
