package entidades;

import model.EntidadeVisivel;

public class Objeto extends EntidadeVisivel {
    private static int qtdObjetos = 0;
    private final int ID = ++qtdObjetos;
    private String nome;
    private String situacao;
    private Pessoa dono;
    private Categoria categoria;

    public Objeto(String nome, String situacao, Pessoa dono, Categoria categoria) {
        this.nome = nome;
        this.situacao = situacao;
        this.dono = dono;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        if (isVisivel()) return "%3d | %s | %s | %s | %s%n".formatted(ID, nome, situacao, dono.getNome(), categoria.getNome());
        return "";
    }

}
