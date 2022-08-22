package br.fiap.dao;

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

}
