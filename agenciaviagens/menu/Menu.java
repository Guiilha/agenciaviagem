package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void exibir() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            exibirCabecalho();
            opcao = lerOpcao(scanner);
            
            processarOpcao(scanner, opcao);
        }
        
        scanner.close();
    }

    private static void exibirCabecalho() {
        System.out.println("\n=========== MENU AGENCIA DE VIAGENS ===========");
        System.out.println("1. Gerenciar Clientes");
        System.out.println("2. Gerenciar Pacotes de Viagem");
        System.out.println("3. Gerenciar Serviços Adicionais");
        System.out.println("4. Gerenciar Pedidos");
        System.out.println("0. Sair");
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
            case 1 -> MenuCliente.exibir(scanner);
            case 2 -> MenuPacote.exibir(scanner);
            case 3 -> MenuServico.exibir(scanner);
            case 4 -> MenuPedido.exibir(scanner);
            case 0 -> System.out.println("\nSistema encerrado.");
            default -> System.out.println("\nOpção inválida.");
        }
    }
}