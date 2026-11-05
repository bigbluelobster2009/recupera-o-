

public class PessoaFila extends Pessoa {

    private int senha;

    public PessoaFila(String nome, String cpf, String telefone, String dataNascimento, int senha) {
        super(nome, cpf, telefone, dataNascimento);
        this.senha = senha;
    }

    public int getSenha() {
        return senha;
    }
}