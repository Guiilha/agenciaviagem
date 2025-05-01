package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Cliente;

public class InsertCliente {
	public static void inserir(Cliente cliente) {
		String sql;
		if ("estrangeiro".equals(cliente.getTipo())) {
			sql = "INSERT INTO cliente (nome, telefone, email, tipo, passaporte) VALUES (?, ?, ?, ?, ?)";
			try (Connection conn = Conexao.conectar();

		              PreparedStatement stmt = conn.prepareStatement(sql)) {

		              stmt.setString(1, cliente.getNome());
		              stmt.setString(2, cliente.getTelefone());
		              stmt.setString(3, cliente.getEmail());
		              stmt.setString(4, cliente.getTipo());
		              stmt.setString(5, cliente.getPassaporte());

		              int linhasAfetadas = stmt.executeUpdate();
		              System.out.println("Linhas inseridas: " + linhasAfetadas);

		        } catch (Exception e) {

		              System.err.println("Erro ao inserir: " + e.getMessage());
		        }
		} else if ("nacional".equals(cliente.getTipo())) {
			sql = "INSERT INTO cliente (nome, telefone, email, tipo, cpf) VALUES (?, ?, ?, ?, ?)";
			try (Connection conn = Conexao.conectar();

		              PreparedStatement stmt = conn.prepareStatement(sql)) {

		              stmt.setString(1, cliente.getNome());
		              stmt.setString(2, cliente.getTelefone());
		              stmt.setString(3, cliente.getEmail());
		              stmt.setString(4, cliente.getTipo());
		              stmt.setString(5, cliente.getCPF());

		              int linhasAfetadas = stmt.executeUpdate();
		              System.out.println("Linhas inseridas: " + linhasAfetadas);

		        } catch (Exception e) {

		              System.err.println("Erro ao inserir: " + e.getMessage());
		        }
			
		} else {
			System.out.println("Erro: O usuário não é nem estrangeiro nem nacional");
		}
		
    }
	
}
