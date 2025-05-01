package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteServico {
	public static void delete(int id) {
		boolean temPedido = false;

		String sql = "SELECT * FROM pedido_servico WHERE id_servico = ?";
		
		// Checando se o Servico possui Pedidos vinculados
		try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				temPedido = true;
				System.out.println("Serviço já está em um pedido!");
			}

		} catch (Exception e) {
			System.err.println("Erro ao consultar: " + e.getMessage());
		}
		
		//Se não possui pedidos vinculados, pode ser apagado
		if (!temPedido) {
			sql = "DELETE FROM servico_adicional WHERE id_servico = ?";

			try (Connection conn = Conexao.conectar();

					PreparedStatement stmt = conn.prepareStatement(sql)) {

				stmt.setInt(1, id);

				int linhasAfetadas = stmt.executeUpdate();
				System.out.println("Serviço deletado\n");

			} catch (Exception e) {

				System.err.println("Erro ao deletar: " + e.getMessage());
			}
		}

	}
}
