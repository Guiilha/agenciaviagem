package bancoDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllCliente {
	public static void select() {
		try (Connection conn = Conexao.conectar();

	            Statement stmt = conn.createStatement();

	            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente")) {

			System.out.printf("%-5s %-25s %-16s %-35s %-13s %-18s %-15s\n",
				    "ID", "Nome", "Telefone", "Email", "Tipo", "CPF", "Passaporte");

				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

				while (rs.next()) {
				    System.out.printf("%-5d %-25s %-16s %-35s %-13s %-18s %-15s\n",
				        rs.getInt("id_cliente"),
				        rs.getString("nome"),
				        rs.getString("telefone"),
				        rs.getString("email"),
				        rs.getString("tipo"),
				        rs.getString("cpf"),
				        rs.getString("passaporte"));
				}


	        } catch (Exception e) {
	             System.err.println("Erro ao consultar: " + e.getMessage());
	        }
	}
}
