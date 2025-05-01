package bancoDados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    private static final String URL = "jdbc:mariadb://localhost:3306/agencia_viagem";
    private static final String USUARIO = "root";
    private static final String SENHA = "admin";

    
    public static Connection conectar() throws SQLException {

        return DriverManager.getConnection(URL, USUARIO, SENHA);

    }

    public static void desconectar(Connection conn) {

        try {

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

        } catch (SQLException e) {

            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }

}

