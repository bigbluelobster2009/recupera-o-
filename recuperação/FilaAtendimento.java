

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;

public class FilaAtendimento {

    private List<PessoaFila> pessoas = new ArrayList<>();
    private int proximaSenha = 1;

    public boolean cadastrarPessoa(String nome, String cpf, String telefone, String dataNascimento) {

        for (PessoaFila pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return false;
            }
        }

        PessoaFila pessoa = new PessoaFila(
            nome,
            cpf,
            telefone,
            dataNascimento,
            proximaSenha
        );

        proximaSenha++;

        int posicao = 0;

        while (posicao < pessoas.size() &&
            calcularIdade(pessoas.get(posicao).getDataNascimento()) >= calcularIdade(dataNascimento)) {

            posicao++;
        }

        pessoas.add(posicao, pessoa);

        return true;
    }

    private int calcularIdade(String dataNascimento) {
        LocalDate nascimento = LocalDate.parse(dataNascimento);
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

    public void listarFila() {

        if (pessoas.isEmpty()) {
            System.out.println("A fila está vazia.");
            return;
        }

        System.out.println("\n===== FILA DE ATENDIMENTO =====");

        for (PessoaFila pessoa : pessoas) {
            System.out.println("Senha: " + pessoa.getSenha());
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("CPF: " + pessoa.getCpf());
            System.out.println("Telefone: " + pessoa.getTelefone());
            System.out.println("Data de nascimento: " + pessoa.getDataNascimento());
            System.out.println("-----------------------------");
        }
    }

    public void chamarProximo() {

        if (pessoas.isEmpty()) {
            System.out.println("Não existem pessoas aguardando.");
        } else {
            PessoaFila pessoa = pessoas.remove(0);

            System.out.println("\nPróximo atendimento:");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Senha: " + pessoa.getSenha());
        }
    }
}