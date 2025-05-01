package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeletePedido {
	public static void delete(int id) {
		String sql = "DELETE FROM pedido_servico WHERE id_pedido = ?,"
				+ "DELETE FROM pedido WHERE id_pedido = ?";

		try (Connection conn = Conexao.conectar())
				{
				// Primeiro deletar na tabela dependente (pedido_servico)
			    String sql1 = "DELETE FROM pedido_servico WHERE id_pedido = ?";
			    PreparedStatement stmt1 = conn.prepareStatement(sql1);
			    stmt1.setInt(1, id);
			    stmt1.executeUpdate();
			    
			 // Deletar na tabela desejada (pedido)
			    String sql2 = "DELETE FROM pedido WHERE id_pedido = ?";
			    PreparedStatement stmt2 = conn.prepareStatement(sql2);
			    stmt2.setInt(1, id);
			    stmt2.executeUpdate();
			    
			System.out.println("Pedido deletado!\n");

		} catch (Exception e) {

			System.err.println("Erro ao deletar: " + e.getMessage());
		}
	}
}
