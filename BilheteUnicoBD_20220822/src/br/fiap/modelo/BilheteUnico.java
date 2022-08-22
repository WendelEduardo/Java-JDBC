package br.fiap.modelo;

public class BilheteUnico {

	private int numero;
	private String cpfUsuario;
	private double saldo;
	public static final double valorDaPassagem = 4.40;

	public BilheteUnico(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}
	
	public BilheteUnico(int numero, String cpfUsuario, double saldo) {
		this.numero = numero;
		this.cpfUsuario = cpfUsuario;
		this.saldo = saldo;
	}

	public void passarNaCatraca() {
		saldo -= valorDaPassagem;
	}

	public void carregar(double valor) {
		saldo += valor;
	}

	public int getNumero() {
		return numero;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getValorDaPassagem() {
		return valorDaPassagem;
	}
}
