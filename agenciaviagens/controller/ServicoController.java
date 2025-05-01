package controller;

import java.util.Scanner;
import bancoDados.*;
import model.ServicoAdicional;

public class ServicoController {
    public static void cadastrar(Scanner scanner) {
        try {
            System.out.print("Digite o nome do serviço: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a descrição: ");
            String descricao = scanner.nextLine();

            System.out.print("Digite o preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            InsertServico.inserir(new ServicoAdicional(nome, descricao, preco));
            System.out.println("Serviço cadastrado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }

    public static void listarTodos() {
        SelectAllServico.select();
    }

    public static void buscarPorId(Scanner scanner) {
        System.out.print("Digite o ID do serviço: ");
        BuscaServico.busca(scanner.nextInt());
        scanner.nextLine();
    }

    public static void excluir(Scanner scanner) {
        System.out.print("Digite o ID do serviço para excluir: ");
        DeleteServico.delete(scanner.nextInt());
        scanner.nextLine();
    }
}