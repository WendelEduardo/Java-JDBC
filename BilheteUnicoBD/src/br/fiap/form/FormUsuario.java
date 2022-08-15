package br.fiap.form;

public class FormUsuario {

	public void menuUsuario() {

	}

	private String gerarMenuUsuario() {
		String menu = "Escolha uma operação:\n";
		menu += "1. Carregar Bilhete\n";
		menu += "2. Passar na Catraca\n";
		menu += "3. Consultar Saldo\n";
		menu += "4. Sair";
		return menu;
	}

}
