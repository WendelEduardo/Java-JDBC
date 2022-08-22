package br.fiap.form;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class FormPrincipal {

	public void menuPrincipal() {
		String opcao;

		do {
			opcao = showInputDialog("Digite sua senha ou CPF ou Sair");

			if (opcao.equalsIgnoreCase("admin")) {
				new FormAdmin().menuAdmin();
			}

		} while (!opcao.equalsIgnoreCase("sair"));
	}

}
