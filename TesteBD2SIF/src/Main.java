
public class Main {
	public static void main(String[] args) {

		Aluno aluno = new Aluno(2, "Patricia");
		AlunoDAO dao = new AlunoDAO();
		//dao.inserir(aluno);

		System.out.println(dao.pesquisar(2));

	}
}
