import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String login = "";
	private String senha = "";
	private Connection connection;

	public Connection conectar() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, senha);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao carregar o driver\n" + e);
		} catch (SQLException e) {
			System.out.println("Erro ao estabelecer conexão\n" + e);
		}

		return connection;
	}
}
