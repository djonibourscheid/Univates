package entidades;

import model.EntidadeVisivel;

public class Pessoa extends EntidadeVisivel {
    private static int qtdContas = 0;
    private final int ID = ++qtdContas;
    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        if (isVisivel()) return "%3d | %s | %s%n".formatted(ID, nome, email);
        return "";
    }
}
