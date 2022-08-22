package br.fiap.modelo;

public class Usuario {
	private String nome;
	private String cpf;
	private String tipo;

	public Usuario(String nome, String cpf, String tarifa) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tarifa;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTarifa() {
		return tipo;
	}

}
