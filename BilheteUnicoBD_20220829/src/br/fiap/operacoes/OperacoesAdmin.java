package br.fiap.operacoes;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.List;
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

	public void imprimirBilhetes() {

		List<BilheteUnico> bilhetes = bilheteUnicoDao.listar();

		if (bilhetes == null) {
			showMessageDialog(null, "Não há bilhetes cadastrados!");
		} else {
			showMessageDialog(null, bilhetes);
		}

	}

	public void consultarBilhete() {
		String cpf = showInputDialog(null, "Digite o CPF para consultar: ");
		BilheteUnico bilhetePorCpf = bilheteUnicoDao.pesquisarCPF(cpf);

		if (bilhetePorCpf == null) {
			showMessageDialog(null, "Bilhete não encontrado!");
		} else {
			showMessageDialog(null, "Bilhete encontrado! \n\n" + bilhetePorCpf);
		}

	}

}
