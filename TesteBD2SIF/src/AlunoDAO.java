import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// objetivo --> reunir as operações de banco de dados ligadas ao Aluno
public class AlunoDAO {

	// variáveis que serão utilizadas para trabalhar com as operações de banco de
	// dados
	private PreparedStatement ps; // configurar o sql que será executado
	private Connection connection; // armazena a conexão estabelecida com o banco de dados
	private ResultSet rs; // armazena o resultada da pesquisa no banco de dados
	private String sql; // utilizada para montar as instruções sql

	public AlunoDAO() {
		connection = new Conexao().conectar();
	}

	public void inserir(Aluno aluno) {
		sql = "insert into java_aluno(rm, nome) values(?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, aluno.getRm());
			ps.setString(2, aluno.getNome());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir aluno\n" + e);
		}
	}

	public boolean pesquisar(int rm) {
		boolean aux = false;

		sql = "SELECT * FROM java_aluno WHERE rm = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, rm);
			rs = ps.executeQuery();
			aux = rs.next(); // Retorna true se encontrar o aluno e false caso contrário
		} catch (SQLException e) {
			System.out.println("Erro ao inserir aluno\n" + e);
		}

		return aux;
	}

}
