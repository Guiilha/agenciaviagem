package bancoDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllServico {
	public static void select() {
		try (Connection conn = Conexao.conectar();

	            Statement stmt = conn.createStatement();

	            ResultSet rs = stmt.executeQuery("SELECT * FROM servico_adicional")) {

				System.out.printf("%-12s %-22s %-50s %-8s\n",
				    "id_servico", "nome", "descricao", "preco");

				System.out.println("--------------------------------------------------------------------------------------------");

				while (rs.next()) {
				    System.out.printf("%-12d %-22s %-50s %-8.2f\n",
				        rs.getInt("id_servico"),
				        rs.getString("nome"),
				        rs.getString("descricao"),
				        rs.getDouble("preco"));
				}
				
	        } catch (Exception e) {
	             System.err.println("Erro ao consultar: " + e.getMessage());
	        }
	}


}
