package entities;

final public class PessoaFisica extends Pessoa {
	
	private double gastosComSaude;
	
	public PessoaFisica(String nome, double rendaAnual, double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	public double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	public double impostoAPagar() {
		return this.rendaAnual * this.percentualDeImposto() - this.abatimentoSaude();
	}
	
	private double abatimentoSaude() {
		if (this.gastosComSaude > 0) {
			return this.gastosComSaude * 0.5;
		}
		return 0;
	}
	
	private double percentualDeImposto() {
		if (this.rendaAnual < 20000) {
			return 0.15;
		} else {
			return 0.25;
		}
	}
}
