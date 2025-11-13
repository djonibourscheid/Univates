package entidades;

public class Pessoa {
    private static int qtdContas = 0;
    private final int ID = ++qtdContas;
    private String nome;
    private String email;
    private boolean visivel = true;

    public Pessoa(String nome, String email) {
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
        this.visivel = false;
    }

    @Override
    public String toString() {
        if (visivel) return "%3d | %s | %s%n".formatted(ID, nome, email);
        return "";
    }
}
