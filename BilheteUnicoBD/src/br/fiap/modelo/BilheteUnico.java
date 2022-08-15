package br.fiap.modelo;

import java.util.Random;

public class BilheteUnico {

	private int numero;
	private String cpfUsuario;
	private double saldo;
	private static final double valorDaPassagem = 4.40;

	public BilheteUnico(String cpfUsuario) {

		Random random = new Random();
		this.numero = random.nextInt(100, Integer.MAX_VALUE);

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
