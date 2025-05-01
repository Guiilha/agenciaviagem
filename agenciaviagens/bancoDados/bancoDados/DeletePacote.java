package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeletePacote {
	public static void delete(int id) {
		boolean temClientes = false;

		String sql = "SELECT * FROM pedido WHERE id_pacote = ?";
		
		// Checando se o Pacote possui clientes
		try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				temClientes = true;
				System.out.println("Pacote já está em um pedido!");
			}

		} catch (Exception e) {
			System.err.println("Erro ao consultar: " + e.getMessage());
		}

		// Deletando o Pacote que não possui clientes
		if (!temClientes) {
			sql = "DELETE FROM pacote_viagem WHERE id_pacote = ?";

			try (Connection conn = Conexao.conectar();

					PreparedStatement stmt = conn.prepareStatement(sql)) {

				stmt.setInt(1, id);

				int linhasAfetadas = stmt.executeUpdate();
				System.out.println("Pacote deletado\n");

			} catch (Exception e) {

				System.err.println("Erro ao deletar: " + e.getMessage());
			}

		}
	}

}
