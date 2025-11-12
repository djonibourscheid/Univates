package entidades;

public class Pessoa {
    private static int qtdContas = 0;
    private final int ID;
    private String nome;
    private String email;
    private boolean ativo = true;

    public Pessoa(String nome, String email) {
        this.ID = ++qtdContas;
        this.nome = nome;
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void excluir() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        if (ativo) return "%3d | %s | %s%n".formatted(ID, nome, email);
        return "";
    }
}
