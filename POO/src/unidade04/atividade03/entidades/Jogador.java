package unidade04.atividade03.entidades;

public class Jogador {
    private static int qtdJogador = 0;

    private int codigo;
    private String nome;
    private String posicao;

    public Jogador(String nome, String posicao) {
        this.codigo = ++qtdJogador;
        this.nome = nome;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    @Override
    public String toString() {
        return "%03d - %s - %s".formatted(codigo, nome, posicao);
    }
}
