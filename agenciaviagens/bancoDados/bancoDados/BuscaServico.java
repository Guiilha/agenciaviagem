package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuscaServico {
	public static void busca(int id_pedido) {
		try (Connection conn = Conexao.conectar();) {
			String sql = "SELECT * FROM servico_adicional WHERE id_servico = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pedido);

            ResultSet rs = stmt.executeQuery();

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
