package entidades;

import java.time.LocalDate;

public class Manutencao {
    private static int qtdManutencoes = 0;
    private final int ID = ++qtdManutencoes;
    private Objeto objeto;
    private String nomeResponsavelManut;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private boolean visivel = true;

    public Manutencao(Objeto objeto, String nomeResponsavelManut, LocalDate dataEntrada, LocalDate dataSaida) {
        this.objeto = objeto;
        this.nomeResponsavelManut = nomeResponsavelManut;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public void setNomeResponsavelManut(String nomeResponsavelManut) {
        this.nomeResponsavelManut = nomeResponsavelManut;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void excluir(char manutConcluido) {
        this.visivel = false;
        if (manutConcluido == 's') {
            objeto.setSituacao("Ativo");
        } else {
            objeto.setSituacao("Baixado");
        }
    }

    @Override
    public String toString() {
        if (visivel)
            return "%3d | %s | %s | %s | %s%n".formatted(ID, objeto.getNome(), nomeResponsavelManut, dataEntrada, dataSaida);
        return "";
    }

}

