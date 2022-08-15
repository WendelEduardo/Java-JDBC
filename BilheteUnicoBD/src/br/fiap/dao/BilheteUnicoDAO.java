package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.JOptionPane.*;

import br.fiap.conexao.Conexao;
import br.fiap.modelo.BilheteUnico;

public class BilheteUnicoDAO {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public BilheteUnicoDAO() {
		this.connection = new Conexao().conectar();
	}

	public BilheteUnico pesquisarCPF(String cpf) {
		BilheteUnico bilhete = null;
		sql = "SELECT * FROM java_bilhete WHERE cpf = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, cpf);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				bilhete = new BilheteUnico(rs.getInt("numero"), rs.getString("cpf"), rs.getDouble("saldo"));
			}
			
		} catch (SQLException e) {
			showMessageDialog(null, "Erro ao pesquisar o bilhete pelo cpf\n" + e);
		}

		return bilhete;
	}

}
