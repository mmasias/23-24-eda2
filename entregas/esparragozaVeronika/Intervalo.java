import java.util.Scanner;

class Intervalo {

	private double puntoMedio;
	
	private double longitud;
	
	private double getInferior() {
		return puntoMedio - longitud/2;
	}

	private void setInferior(double inferior) {
		longitud = this.getSuperior() - inferior;
		puntoMedio = inferior + longitud/2;
	}

	private double getSuperior() {
		return puntoMedio + longitud/2;
	}

	private void setSuperior(double superior) {
		longitud = superior - this.getInferior();
		puntoMedio = superior - longitud/2;
	}

	public Intervalo(double inferior, double superior) {
		this.setInferior(inferior);
		this.setSuperior(superior);
	}

	private Intervalo(Intervalo intervalo) {
		this(intervalo.getInferior(), intervalo.getSuperior());
	}

	public Intervalo clone() {
		return new Intervalo(this);
	}

	public boolean incluye(double valor) {
		return getInferior() <= valor && valor <= getSuperior();
	}

}

