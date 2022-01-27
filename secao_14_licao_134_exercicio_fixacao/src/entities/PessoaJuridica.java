package entities;

final public class PessoaJuridica extends Pessoa {
	private int numeroDeFuncionarios;

	public PessoaJuridica(String nome, double rendaAnual, int numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public int getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(int numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double impostoAPagar() {
		double taxaDeImposto;
		if (this.numeroDeFuncionarios > 10) {
			taxaDeImposto = 0.14;
		} else {
			taxaDeImposto = 0.16;
		}
		
		return this.rendaAnual * taxaDeImposto;
	}

}
