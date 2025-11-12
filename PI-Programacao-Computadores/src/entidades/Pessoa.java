package entidades;

public class Pessoa {
    private static int codigo = 0;
    private int id;
    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
        this.id = ++codigo;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "%3d | %s | %s".formatted(id, nome, email);
    }
}
