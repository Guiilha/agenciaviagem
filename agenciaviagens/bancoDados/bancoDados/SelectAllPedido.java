package bancoDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllPedido {
	public static void select() {
		try (Connection conn = Conexao.conectar();

				Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery("SELECT * FROM pedido")) {
			
			System.out.printf("%-11s %-12s %-11s %-20s\n", "id_pedido", "id_cliente", "id_pacote", "data_contratacao");

			System.out.println("---------------------------------------------------------------");

			while (rs.next()) {
				System.out.printf("%-11d %-12d %-11d %-20s\n", rs.getInt("id_pedido"), rs.getInt("id_cliente"),
						rs.getInt("id_pacote"), rs.getString("data_contratacao"));
			}

		} catch (Exception e) {
			System.err.println("Erro ao consultar: " + e.getMessage());
		}
	}

}
