package br.fiap.form;

import static javax.swing.JOptionPane.*;

import br.fiap.dao.UsuarioDAO;

import static java.lang.Integer.parseInt;

public class FormPrincipal {

	public void menuPrincipal() {
		String opcao;
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		do {
			opcao = showInputDialog("Digite sua senha ou CPF ou Sair");

			if (opcao.equalsIgnoreCase("admin")) {
				new FormAdmin().menuAdmin();
			} else if (!opcao.equalsIgnoreCase("sair")) {
				if (usuarioDAO.pesquisarUsuarioCPF(opcao)) {
					new FormUsuario().menuUsuario(opcao);
				}
			}

		} while (!opcao.equalsIgnoreCase("sair"));
	}

}
