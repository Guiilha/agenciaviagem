package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteCliente {
	public static void delete(int id) {
		boolean temPedido = false;

		String sql = "SELECT * FROM pedido WHERE id_cliente = ?";
		
		// Checando se o Cliente possui Pedidos
		try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				temPedido = true;
				System.out.println("Cliente possui um pedido!");
			}

		} catch (Exception e) {
			System.err.println("Erro ao consultar: " + e.getMessage());
		}

		// Deletando o Cliente que não possui pedidos
		if (!temPedido) {
			sql = "DELETE FROM cliente WHERE id_cliente = ?";

			try (Connection conn = Conexao.conectar();

					PreparedStatement stmt = conn.prepareStatement(sql)) {

				stmt.setInt(1, id);

				int linhasAfetadas = stmt.executeUpdate();
				System.out.println("Cliente deletado\n");

			} catch (Exception e) {

				System.err.println("Erro ao deletar: " + e.getMessage());
			}

		}
	}

}
