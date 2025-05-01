package controller;

import java.util.Scanner;
import bancoDados.*;
import model.Pedido;

public class PedidoController {
    public static void cadastrar(Scanner scanner) {
        try {
            System.out.print("Digite o ID do cliente: ");
            int idCliente = scanner.nextInt();
            
            System.out.print("Digite o ID do pacote: ");
            int idPacote = scanner.nextInt();
            
            System.out.print("Digite a data (YYYY-MM-DD): ");
            String data = scanner.next();
            
            InsertPedido.insert(new Pedido(idCliente, idPacote, data));
            System.out.println("Pedido cadastrado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        } finally {
            scanner.nextLine();
        }
    }
    
    public static void listarTodos() {
        SelectAllPedido.select();
    }
    
    public static void buscarPorId(Scanner scanner) {
        System.out.print("Digite o ID do pedido: ");
        BuscaPedido.busca(scanner.nextInt());
        scanner.nextLine();
    }
    
    public static void excluir(Scanner scanner) {
        System.out.print("Digite o ID do pedido para excluir: ");
        DeletePedido.delete(scanner.nextInt());
        scanner.nextLine();
    }
}