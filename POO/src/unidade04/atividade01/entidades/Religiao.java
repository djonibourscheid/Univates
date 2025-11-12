package unidade04.atividade01.entidades;

public class Religiao {
    private String descricao;

    public Religiao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
