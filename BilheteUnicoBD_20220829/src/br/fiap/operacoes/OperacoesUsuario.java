package br.fiap.operacoes;

import javax.swing.JOptionPane;

import br.fiap.dao.BilheteUnicoDAO;
import br.fiap.dao.UsuarioDAO;

public class OperacoesUsuario {

	static UsuarioDAO usuarioDAO = new UsuarioDAO();
	BilheteUnicoDAO bilheteUnico = new BilheteUnicoDAO();

	public static void carregarBilhete(String opcao_CPF) {
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser carregado: "));
		usuarioDAO.carregar(valor, opcao_CPF);
	}

	public static void passarCatraca(String opcao_CPF) {
		usuarioDAO.passarCatraca(opcao_CPF);
	}

	public static void consultarSaldo(String opcao_CPF) {
		usuarioDAO.consultarSaldo(opcao_CPF);
	}

}
