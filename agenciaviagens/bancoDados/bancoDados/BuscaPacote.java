package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuscaPacote {
	public static void busca(int id_pacote) {
		try (Connection conn = Conexao.conectar();) {
			String sql = "SELECT * FROM pacote_viagem WHERE id_pacote = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_pacote);

            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-10s %-25s %-12s %-14s %-10s %-10s %-50s\n",
				    "ID", "Nome", "Destino", "Duracao_dias", "Preco", "Tipo", "Descricao");

				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

				while (rs.next()) {
				    System.out.printf("%-10d %-25s %-12s %-14d %-10.2f %-10s %-50s\n",
				        rs.getInt("id_pacote"),
				        rs.getString("nome"),
				        rs.getString("destino"),
				        rs.getInt("duracao_dias"),
				        rs.getDouble("preco"),
				        rs.getString("tipo"),
				        rs.getString("descricao"));
				}



	        } catch (Exception e) {
	             System.err.println("Erro ao consultar: " + e.getMessage());
	        }
	}

}
