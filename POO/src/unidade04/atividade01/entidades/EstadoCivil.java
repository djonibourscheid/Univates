package unidade04.atividade01.entidades;

public class EstadoCivil {
    private String descricao;

    public EstadoCivil(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
