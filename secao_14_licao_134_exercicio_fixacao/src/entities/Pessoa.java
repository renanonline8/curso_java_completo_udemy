package entities;

abstract public class Pessoa {
	protected String nome;
	protected double rendaAnual;
	
	public Pessoa(String nome, double rendaAnual) {
		super();
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getRendaAnual() {
		return rendaAnual;
	}
	
	public void setRendaAnual(double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	
	public abstract double impostoAPagar();
	
	public String toString() {
		return this.nome + ": $ " + String.format("%.2f", this.impostoAPagar());
	}
}
