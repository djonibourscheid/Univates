package unidade04.atividade01.entidades;

public class Cidade {
    private String descricao;
    private String cep;

    public Cidade(String descricao, String cep) {
        this.descricao = descricao;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "%s, %s".formatted(descricao, cep);
    }
}
