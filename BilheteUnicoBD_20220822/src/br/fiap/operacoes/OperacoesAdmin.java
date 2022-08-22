package br.fiap.operacoes;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.Random;

import javax.swing.JOptionPane;

import br.fiap.dao.BilheteUnicoDAO;
import br.fiap.modelo.BilheteUnico;
import br.fiap.modelo.Usuario;

public class OperacoesAdmin {

	BilheteUnicoDAO bilheteUnicoDao = new BilheteUnicoDAO();

	public void emitirBilhete() {
		String nome;
		int numero, tipo;
		String[] opcao = { "Estudante", "Professor", "Normal" };

		Random random = new Random();

		String cpf = showInputDialog("Digite seu CPF: ");

		if (bilheteUnicoDao.pesquisarCPF(cpf) == null) {

			do {
				numero = random.nextInt(1000, Integer.MAX_VALUE);
			} while (bilheteUnicoDao.pesquisarNumero(numero) != null);

			nome = showInputDialog("Nome do usuario: ");
			tipo = JOptionPane.showOptionDialog(null, "Tipo de tarifa: ", "Tarifas", 0, 0, null, opcao, opcao[0]);

			Usuario usuario = new Usuario(nome, cpf, opcao[tipo]);
			BilheteUnico bilheteUnico = new BilheteUnico(numero, cpf, 0);

			bilheteUnicoDao.emitir(usuario, bilheteUnico);
			showMessageDialog(null, "Bilhete único com CPF: " + cpf + "\n Cadastrado com Sucesso!");
		} else {
			showMessageDialog(null, "Seu CPF já tem um bilhete!");
		}
	}

	public void imprimirBilhete() {

	}

	public void consultarBilhete() {

	}

}
