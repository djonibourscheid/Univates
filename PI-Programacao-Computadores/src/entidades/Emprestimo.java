package entidades;

import java.time.LocalDate;

public class Emprestimo {
    private static int qtdEmprestimos = 0;
    private final int ID = ++qtdEmprestimos;
    private Objeto objeto;
    private Pessoa tomador;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean visivel = true;

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

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void excluir() {
        this.visivel = false;
    }

    @Override
    public String toString() {
        if (visivel)
            return "%3d | %s | %s | %s | %s | %s%n".formatted(ID, objeto.getNome(), objeto.getDono().getNome(),
                    tomador.getNome()
                    , dataEmprestimo, dataDevolucao);
        return "";
    }
}
