package entidades;

import model.EntidadeVisivel;

import java.time.LocalDate;

public class Manutencao extends EntidadeVisivel {
    private static int qtdManutencoes = 0;
    private final int ID = ++qtdManutencoes;
    private Objeto objeto;
    private String nomeResponsavelManut;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

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

    @Override
    public void excluir(){
       throw new IllegalArgumentException("=> É necessario informar o código da manutenção. <=\n");
    }

    public void excluir(char manutConcluido) {
        super.excluir();
        if (manutConcluido == 's') {
            objeto.setSituacao("Ativo");
        } else {
            objeto.setSituacao("Baixado");
        }
    }

    @Override
    public String toString() {
        if (isVisivel())
            return "%3d | %s | %s | %s | %s | %s%n".formatted(ID, objeto.getNome(), objeto.getDono().getNome(), nomeResponsavelManut, dataEntrada, dataSaida);
        return "";
    }

}

