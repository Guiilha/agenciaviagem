package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.PacoteViagem;

public class InsertPacote {
	public static void inserir(PacoteViagem pacote) {
		String sql = "INSERT INTO pacote_viagem (nome, destino, duracao_dias, preco, tipo, descricao)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();

              PreparedStatement stmt = conn.prepareStatement(sql)) {

        	  stmt.setString(1, pacote.getNome());
              stmt.setString(2, pacote.getDestino());
              stmt.setInt(3, pacote.getDuracao());
              stmt.setDouble(4, pacote.getPreco());
              stmt.setString(5, pacote.getTipo());
              stmt.setString(6, pacote.getDescricao());

              int linhasAfetadas = stmt.executeUpdate();
              System.out.println("Linhas inseridas: " + linhasAfetadas);

        } catch (Exception e) {

              System.err.println("Erro ao inserir: " + e.getMessage());
        }
	}
}
