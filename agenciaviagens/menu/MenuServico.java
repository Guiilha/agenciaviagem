package menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.ServicoController;

public class MenuServico {
    public static void exibir(Scanner scanner) {
        int opcao = -1;

        while (opcao != 0) {
            exibirCabecalho();
            opcao = lerOpcao(scanner);
            
            processarOpcao(scanner, opcao);
        }
    }

    private static void exibirCabecalho() {
        System.out.println("\n--- Gerenciamento de Serviços Adicionais ---");
        System.out.println("1. Cadastrar serviço");
        System.out.println("2. Listar serviços");
        System.out.println("3. Buscar serviço por ID");
        System.out.println("4. Excluir serviço");
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
            case 1 -> ServicoController.cadastrar(scanner);
            case 2 -> ServicoController.listarTodos();
            case 3 -> ServicoController.buscarPorId(scanner);
            case 4 -> ServicoController.excluir(scanner);
            case 0 -> {}
            default -> System.out.println("\nOpção inválida.");
        }
    }
}