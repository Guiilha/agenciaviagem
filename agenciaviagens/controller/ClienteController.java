package controller;

import java.util.Scanner;
import bancoDados.*;
import model.*;

public class ClienteController {
    public static void cadastrar(Scanner scanner) {
        try {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Digite o documento (CPF/Passaporte): ");
            String documento = scanner.nextLine();
            
            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();
            
            System.out.print("Digite o email: ");
            String email = scanner.nextLine();
            
            System.out.print("Digite o tipo (nacional/estrangeiro): ");
            String tipo = scanner.nextLine().toLowerCase();
            
            Cliente cliente = criarCliente(nome, telefone, email, documento, tipo);
            if (cliente != null) {
                InsertCliente.inserir(cliente);
                System.out.println("Cliente cadastrado com sucesso.");
            }
        } catch (Exception e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }
    
    private static Cliente criarCliente(String nome, String telefone, String email, 
                                      String documento, String tipo) {
        if ("nacional".equals(tipo)) {
            return new ClienteNacional(nome, telefone, email, documento);
        } else if ("estrangeiro".equals(tipo)) {
            return new ClienteEstrangeiro(nome, telefone, email, documento);
        }
        System.out.println("Tipo inválido.");
        return null;
    }
    
    public static void listarTodos() {
        SelectAllCliente.select();
    }
    
    public static void buscarPorId(Scanner scanner) {
        System.out.print("Digite o ID do cliente: ");
        BuscaCliente.busca(scanner.nextInt());
        scanner.nextLine();
    }
    
    public static void excluir(Scanner scanner) {
        System.out.print("Digite o ID do cliente para excluir: ");
        DeleteCliente.delete(scanner.nextInt());
        scanner.nextLine();
    }
}