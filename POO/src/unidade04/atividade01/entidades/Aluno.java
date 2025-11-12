package unidade04.atividade01.entidades;

public class Aluno {
    private String nome;
    private String dataNascimento;
    private Religiao religiao;
    private EstadoCivil estadoCivil;
    private Cidade cidade;

    public Aluno(String nome, String dataNascimento, Religiao religiao, EstadoCivil estadoCivil, Cidade cidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.religiao = religiao;
        this.estadoCivil = estadoCivil;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", religiao=" + religiao +
                ", estadoCivil=" + estadoCivil +
                ", cidade=" + cidade +
                '}';
    }
}
