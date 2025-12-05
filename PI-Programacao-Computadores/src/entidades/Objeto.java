package entidades;

import model.EntidadeVisivel;

public class Objeto extends EntidadeVisivel {
    private static int qtdObjetos = 0;
    private final int ID = ++qtdObjetos;
    private String nome;
    private String situacao;  // Ativo, Emprestado, Manutenção ou Baixado
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

    public Pessoa getDono() {
        return dono;
    }

    public String getSituacao() {
        return situacao;
    }

    protected void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void update(String nome, String situacao, Pessoa dono, Categoria categoria) {
        this.nome = nome;
        this.situacao = situacao;
        this.dono = dono;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        if (isVisivel())
            return "%3d | %s | %s | %s | %s%n".formatted(ID, nome, situacao, dono.getNome(), categoria.getNome());
        return "";
    }

}
