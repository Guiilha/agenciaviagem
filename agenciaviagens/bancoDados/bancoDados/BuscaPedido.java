package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuscaPedido {
	public static void busca(int id_pedido) {
		try (Connection conn = Conexao.conectar();) {
			String sql = "SELECT * FROM pedido WHERE id_pedido = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pedido);

            ResultSet rs = stmt.executeQuery();

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
