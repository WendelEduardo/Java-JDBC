package br.fiap.form;

import static javax.swing.JOptionPane.*;

import javax.swing.JOptionPane;

public class FormUsuario {

	public void menuUsuario() {
		int opcao = 0;
		
		do {
			
			try {
				opcao = Integer.parseInt(showInputDialog(gerarMenuUsuario()));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Número inválido!\n" + e);
			}
			
		} while (opcao != 4);
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
