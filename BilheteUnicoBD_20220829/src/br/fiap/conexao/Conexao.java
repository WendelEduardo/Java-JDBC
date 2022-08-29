package br.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String caminho = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private String login = "rm89355";
	private String senha = "261102";
	private Connection conexao; // armazena a conexão que será estabelecida com o banco

	public Connection conectar() {
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(caminho, login, senha);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao carregar o driver de conexão\n" + e);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco de dados\n" + e);
		}

		return conexao;
	}
}
