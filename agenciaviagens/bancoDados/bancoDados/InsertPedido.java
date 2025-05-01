package bancoDados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import model.Pedido;

public class InsertPedido {
    public static void insert(Pedido pedido) {
        String sql = "INSERT INTO pedido (id_cliente, id_pacote, data_contratacao)"
                + "VALUES(?, ?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedido.getId_cliente());
            stmt.setInt(2, pedido.getId_pacote());

            // Verifica se a string da data está no formato correto (yyyy-MM-dd)
            String dataString = pedido.getData();
            Date dataContratacao = Date.valueOf(dataString);
            stmt.setDate(3, dataContratacao);

            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Pedido inserido!");

        } catch (Exception e) {
            System.err.println("Erro ao inserir: " + e.getMessage());
        }
    }
}
