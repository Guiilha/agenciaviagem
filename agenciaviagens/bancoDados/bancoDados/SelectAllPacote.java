package bancoDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllPacote {
	public static void select() {
		try (Connection conn = Conexao.conectar();

	            Statement stmt = conn.createStatement();

	            ResultSet rs = stmt.executeQuery("SELECT * FROM pacote_viagem")) {

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
