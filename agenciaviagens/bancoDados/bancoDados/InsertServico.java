package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.ServicoAdicional;

public class InsertServico {
	public static void inserir(ServicoAdicional servico) {
		String sql = "INSERT INTO servico_adicional (nome, descricao, preco)"
				+ "VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();

              PreparedStatement stmt = conn.prepareStatement(sql)) {

        	  stmt.setString(1, servico.getNome());
              stmt.setString(2, servico.getDescricao());
              stmt.setDouble(3, servico.getPreco());

              int linhasAfetadas = stmt.executeUpdate();
              System.out.println("Linhas inseridas: " + linhasAfetadas);

        } catch (Exception e) {

              System.err.println("Erro ao inserir: " + e.getMessage());
        }
	}
}
