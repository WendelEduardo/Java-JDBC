package br.fiap.form;

import static javax.swing.JOptionPane.*;

import javax.swing.JOptionPane;

import br.fiap.operacoes.OperacoesUsuario;

public class FormUsuario {

	public void menuUsuario(String opcao_CPF) {
		int opcao = 0;

		do {

			try {
				opcao = Integer.parseInt(showInputDialog(gerarMenuUsuario()));

				switch (opcao) {
				case 1:
					OperacoesUsuario.carregarBilhete(opcao_CPF);
					break;

				case 2:
					OperacoesUsuario.passarCatraca(opcao_CPF);
					break;

				case 3:
					OperacoesUsuario.consultarSaldo(opcao_CPF);
					break;
				}
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
