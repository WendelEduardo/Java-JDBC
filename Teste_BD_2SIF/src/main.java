
public class main {

	public static void main(String[] args) {

		Conexao conexao = new Conexao();
		
		if(conexao.conectar() == null) {
			System.out.println("Não conectou!");
		}else {
			System.out.println("Conectou!");
		}
	}

}
