package codigoFinal;

public class Quadrado implements IFiguraGeometrica {
	private Retangulo retangulo;

	public Quadrado(int lado) {
		retangulo = new Retangulo(lado, lado);
	}

	public void setLado(int lado) {
		retangulo.setLargura(lado);
		retangulo.setAltura(lado);
	}

	@Override
	public double calcularArea() {
		return retangulo.calcularArea();
	}
}