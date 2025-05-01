package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import bancoDados.*;
import model.*;

public class PacoteController {
    public static void cadastrar(Scanner scanner) {
        try {
            System.out.print("Digite o nome do pacote: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o destino: ");
            String destino = scanner.nextLine();

            System.out.print("Digite a duração (número de dias): ");
            int duracao = getIntInput(scanner);

            System.out.print("Digite o preço: ");
            double preco = getDoubleInput(scanner);

            System.out.print("Digite o tipo de pacote (aventura/luxo/cultural/outro): ");
            String tipo = scanner.nextLine().toLowerCase();

            PacoteViagem pacote = criarPacote(scanner, nome, destino, duracao, preco, tipo);
            if (pacote != null) {
                InsertPacote.inserir(pacote);
                System.out.println("Pacote cadastrado com sucesso.");
            }
        } catch (Exception e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }

    private static PacoteViagem criarPacote(Scanner scanner, String nome, String destino, 
                                          int duracao, double preco, String tipo) {
        switch (tipo) {
            case "aventura":
                System.out.print("Digite a atividade principal: ");
                return new PacoteAventura(nome, destino, duracao, preco, scanner.nextLine());
            case "luxo":
                System.out.print("Digite a descrição: ");
                return new PacoteLuxo(nome, destino, duracao, preco, scanner.nextLine());
            case "cultural":
                System.out.print("Digite o tema cultural: ");
                return new PacoteCultural(nome, destino, duracao, preco, scanner.nextLine());
            case "outro":
                System.out.print("Digite a descrição: ");
                String descricao = scanner.nextLine();
                System.out.print("Digite o tipo específico: ");
                return new PacoteOutro(nome, destino, duracao, preco, descricao, scanner.nextLine());
            default:
                System.out.println("Tipo inválido.");
                return null;
        }
    }

    public static void listarTodos() {
        SelectAllPacote.select();
    }

    public static void buscarPorId(Scanner scanner) {
        System.out.print("Digite o ID do pacote: ");
        BuscaPacote.busca(getIntInput(scanner));
    }

    public static void excluir(Scanner scanner) {
        System.out.print("Digite o ID do pacote para excluir: ");
        DeletePacote.delete(getIntInput(scanner));
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Digite um número: ");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Digite um valor: ");
            } finally {
                scanner.nextLine();
            }
        }
    }
}