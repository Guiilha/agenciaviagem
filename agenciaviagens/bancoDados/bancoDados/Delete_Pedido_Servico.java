package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Delete_Pedido_Servico {
	public static void delete(int id_pedido, int id_servico) {
		boolean temPedido = false;

		String sql = "DELETE FROM pedido_servico WHERE id_pedido = ? AND id_servico = ?";

		try (Connection conn = Conexao.conectar();

			PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id_pedido);
			stmt.setInt(2, id_servico);

			int linhasAfetadas = stmt.executeUpdate();
			System.out.println("Serviço deletado\n");

		} catch (Exception e) {

			System.err.println("Erro ao deletar: " + e.getMessage());
		}

	}

}
