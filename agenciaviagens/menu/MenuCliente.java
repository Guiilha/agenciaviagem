package menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.ClienteController;

public class MenuCliente {
    public static void exibir(Scanner scanner) {
        int opcao = -1;

        while (opcao != 0) {
            exibirCabecalho();
            opcao = lerOpcao(scanner);
            
            processarOpcao(scanner, opcao);
        }
    }

    private static void exibirCabecalho() {
        System.out.println("\n--- Gerenciamento de Clientes ---");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Buscar cliente por ID");
        System.out.println("4. Excluir cliente");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        } finally {
            scanner.nextLine();
        }
    }

    private static void processarOpcao(Scanner scanner, int opcao) {
        switch (opcao) {
            case 1 -> ClienteController.cadastrar(scanner);
            case 2 -> ClienteController.listarTodos();
            case 3 -> ClienteController.buscarPorId(scanner);
            case 4 -> ClienteController.excluir(scanner);
            case 0 -> {}
            default -> System.out.println("\nOpção inválida.");
        }
    }
}