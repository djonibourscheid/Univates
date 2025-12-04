package entidades;

import model.EntidadeVisivel;

public class Categoria extends EntidadeVisivel {
    private static int qtdCategorias = 0;
    private final int ID = ++qtdCategorias;
    private String nome;
    private String descricao;

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        if (isVisivel()) return "%3d | %s | %s%n".formatted(ID, nome, descricao);
        return "";
    }
}

