

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        FilaAtendimento fila = new FilaAtendimento();

        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n===== SISTEMA DE ATENDIMENTO =====");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Ver fila");
            System.out.println("3 - Chamar próximo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {

                System.out.print("Nome: ");
                String nome = entrada.nextLine();

                System.out.print("CPF: ");
                String cpf = entrada.nextLine();

                System.out.print("Telefone: ");
                String telefone = entrada.nextLine();

                System.out.print("Data de nascimento (AAAA-MM-DD): ");
                String dataNascimento = entrada.nextLine();

                boolean cadastro = fila.cadastrarPessoa(
                    nome, cpf, telefone, dataNascimento
                );

                if (cadastro) {
                    System.out.println("Pessoa cadastrada com sucesso!");
                } else {
                    System.out.println("Este CPF já está cadastrado!");
                }

            } else if (opcao == 2) {

                fila.listarFila();

            } else if (opcao == 3) {

                fila.chamarProximo();

            } else if (opcao == 4) {

                System.out.println("Sistema encerrado.");

            } else {

                System.out.println("Opção inválida!");
            }
        }

        entrada.close();
    }
}