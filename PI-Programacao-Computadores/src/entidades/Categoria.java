package entidades;

public class Categoria {
    private static int qtdCategorias = 0;
    private final int ID = ++qtdCategorias;
    private String nome;
    private String descricao;
    private boolean visivel = true;

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void excluir() {
        this.visivel = false;
    }

    @Override
    public String toString() {
        if (visivel) return "%3d | %s | %s%n".formatted(ID, nome, descricao);
        return "";
    }
}

