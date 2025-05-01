package bancoDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select_All_Servico_Pedido {
	public static void select() {
		try (Connection conn = Conexao.conectar();

				Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery("SELECT * FROM pedido_servico")) {
			
			System.out.printf("%-11s %-12s\n", "id_pedido", "id_servico");

			System.out.println("-------------------------");

			while (rs.next()) {
			    System.out.printf("%-11d %-12d\n", rs.getInt("id_pedido"), rs.getInt("id_servico"));
			}


		} catch (Exception e) {
			System.err.println("Erro ao consultar: " + e.getMessage());
		}
	}

}
