package entidades;

import model.EntidadeVisivel;

import java.time.LocalDate;

public class Emprestimo extends EntidadeVisivel {
    private static int qtdEmprestimos = 0;
    private final int ID = ++qtdEmprestimos;
    private Objeto objeto;
    private Pessoa tomador;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Objeto objeto, Pessoa tomador, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.objeto = objeto;
        this.tomador = tomador;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public Pessoa getTomador() {
        return tomador;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void update(LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        if (isVisivel())
            return "%3d | %s | %s | %s | %s | %s%n".formatted(ID, objeto.getNome(), objeto.getDono().getNome(), tomador.getNome(), dataEmprestimo, dataDevolucao);
        return "";
    }
}
