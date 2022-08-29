package br.fiap.dao;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.conexao.Conexao;
import br.fiap.modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public UsuarioDAO() {
		this.connection = new Conexao().conectar();
	}

	public void inserirUsuario(Usuario usuario) {
		sql = "INSERT INTO java_usuario (nome, cpf, tipo) values (?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getCpf());
			ps.setString(3, usuario.getTarifa());
			ps.execute();

		} catch (SQLException e) {
			showMessageDialog(null, "Erro ao cadastrar Usuario" + e);
		}
	}

	public boolean pesquisarUsuarioCPF(String cpf) {
		boolean aux = false;

		sql = "SELECT cpf FROM java_usuario where cpf = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, cpf);
			rs = ps.executeQuery();

			if (rs.next()) {
				aux = true;
			}
		} catch (SQLException e) {
			showMessageDialog(null, "Erro ao procurar usúario\n" + e);
		}

		return aux;

	}

	public void carregar(double valor, String opcao_CPF) {
		sql = "UPDATE java_bilhete SET saldo=saldo+? WHERE cpf=?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setDouble(1, valor);
			ps.setString(2, opcao_CPF);
			ps.executeQuery();

			showMessageDialog(null, "Saldo carregado com Sucesso! \n");

		} catch (SQLException e) {
			showMessageDialog(null, "Não foi possível carregar bilhete!\n" + e);
		}

	}

	public void passarCatraca(String opcao_CPF) {
		sql = "UPDATE java_bilhete SET saldo = saldo-valorpassagem WHERE cpf = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, opcao_CPF);
			ps.executeQuery();

			showMessageDialog(null, "Passou na catraca! \n Valor debitado do cartão! \n");
		} catch (SQLException e) {
			showMessageDialog(null, "Erro ao passar na catraca!\n" + e);
		}
	}

	public void consultarSaldo(String opcao_CPF) {

		sql = "SELECT saldo FROM java_bilhete where cpf = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, opcao_CPF);
			rs = ps.executeQuery();

			if (rs.next()) {
				showMessageDialog(null, "Saldo atual: " + rs.getDouble("saldo"));
			}

		} catch (SQLException e) {
			showMessageDialog(null, "Erro ao consultar saldo! \n" + e);
		}

	}

}
