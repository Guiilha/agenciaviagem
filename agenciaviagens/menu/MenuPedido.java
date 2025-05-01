package menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.PedidoController;

public class MenuPedido {
    public static void exibir(Scanner scanner) {
        int opcao = -1;

        while (opcao != 0) {
            exibirCabecalho();
            opcao = lerOpcao(scanner);
            
            processarOpcao(scanner, opcao);
        }
    }

    private static void exibirCabecalho() {
        System.out.println("\n--- Gerenciamento de Pedidos ---");
        System.out.println("1. Cadastrar pedido");
        System.out.println("2. Listar todos os pedidos");
        System.out.println("3. Buscar pedido por ID");
        System.out.println("4. Excluir pedido");
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
            case 1 -> PedidoController.cadastrar(scanner);
            case 2 -> PedidoController.listarTodos();
            case 3 -> PedidoController.buscarPorId(scanner);
            case 4 -> PedidoController.excluir(scanner);
            case 0 -> {}
            default -> System.out.println("\nOpção inválida.");
        }
    }
}