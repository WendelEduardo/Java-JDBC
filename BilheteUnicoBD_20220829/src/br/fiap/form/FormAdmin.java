package br.fiap.form;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;

import javax.swing.JOptionPane;

import br.fiap.operacoes.OperacoesAdmin;

public class FormAdmin {

	public void menuAdmin() {
		int opcao = 0;

		do {
			try {
				opcao = parseInt(showInputDialog(gerarMenuAdmin()));

				switch (opcao) {
				case 1:
					new OperacoesAdmin().emitirBilhete();
					break;
				case 2:
					new OperacoesAdmin().imprimirBilhetes();
					break;
				case 3:
					new OperacoesAdmin().consultarBilhete();
					break;
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Número inválido!\n" + e);
			}
		} while (opcao != 4);

	}

	private String gerarMenuAdmin() {
		String menu = "Escolha uma operação:\n";
		menu += "1. Emitir Bilhete\n";
		menu += "2. Imprimir Bilhete\n";
		menu += "3. Consultar Bilhete\n";
		menu += "4. Sair";
		return menu;
	}

}
