package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.ServicoAdicional;

public class Insert_Pedido_Servico {
	public static void inserir(int id_pedido, int id_servico) {
		String sql = "INSERT INTO pedido_servico (id_pedido, id_servico)"
				+ "VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();

              PreparedStatement stmt = conn.prepareStatement(sql)) {

        	  stmt.setInt(1, id_pedido);
        	  stmt.setInt(2, id_servico);

              int linhasAfetadas = stmt.executeUpdate();
              System.out.println("Linhas inseridas: " + linhasAfetadas);

        } catch (Exception e) {

              System.err.println("Erro ao inserir: " + e.getMessage());
        }
	}

}
