package codigoFinal;

public class Retangulo implements IFiguraGeometrica {
	protected int largura;
	protected int altura;

	public Retangulo(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		return largura * altura;
	}
}