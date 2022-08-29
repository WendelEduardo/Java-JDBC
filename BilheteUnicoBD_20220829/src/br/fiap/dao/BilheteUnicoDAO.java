package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static javax.swing.JOptionPane.*;

import br.fiap.conexao.Conexao;
import br.fiap.modelo.BilheteUnico;
import br.fiap.modelo.Usuario;

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

			if (rs.next()) {
				bilhete = new BilheteUnico(rs.getInt("numero"), rs.getString("cpf"), rs.getDouble("saldo"));
			}

		} catch (SQLException e) {
			showMessageDialog(null, "Erro ao pesquisar o bilhete pelo cpf\n" + e);
		}

		return bilhete;
	}

	public BilheteUnico pesquisarNumero(int numero) {
		BilheteUnico bilheteUnico = null;
		String sql = "SELECT numero FROM java_bilhete WHERE numero=?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, numero);
			rs = ps.executeQuery();

			if (rs.next()) {
				bilheteUnico = new BilheteUnico(rs.getInt("numero"), rs.getString("cpf"), rs.getDouble("saldo"));
			}

		} catch (SQLException e) {
			showMessageDialog(null, "Erro ao pesquisar o bilhete pelo numero: " + numero + "\n" + e);
		}

		return bilheteUnico;
	}

	public void emitir(Usuario usuario, BilheteUnico bilheteUnico) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		sql = "INSERT INTO java_bilhete (numero, cpf, saldo, valorpassagem) values (?, ?, ?, ?)";

		try {
			usuarioDAO.inserirUsuario(usuario);

			ps = connection.prepareStatement(sql);
			ps.setInt(1, bilheteUnico.getNumero());
			ps.setString(2, bilheteUnico.getCpfUsuario());
			ps.setDouble(3, bilheteUnico.getSaldo());
			ps.setDouble(4, BilheteUnico.valorDaPassagem);
			ps.execute();

		} catch (SQLException e) {
			showMessageDialog(null, "Erro ao cadastrar bilhete unico\n" + e);
		}
	}

	public List<BilheteUnico> listar() {
		List<BilheteUnico> bilhetes = new ArrayList<BilheteUnico>();
		sql = "SELECT * FROM java_bilhete";

		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				bilhetes.add(new BilheteUnico(rs.getInt("NUMERO"), rs.getString("CPF"), rs.getDouble("SALDO")));
			}

		} catch (SQLException e) {
			showMessageDialog(null, "Erro ao listar bilhetes \n" + e);
		}

		return bilhetes;
	}
	

}
