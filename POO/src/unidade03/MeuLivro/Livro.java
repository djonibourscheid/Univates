package unidade03.MeuLivro;

public class Livro {
    private String titulo;
    private int ano;
    private String editora;
    private String autor;


    public Livro(String titulo, int ano, String editora, String autor) {
        // Verifica se não tem erro
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio ou nulo.");
        }

        if (ano <= 0) {
            throw new IllegalArgumentException("O ano deve ser maior que zero.");
        }

        if (editora == null || editora.trim().isEmpty()) {
            throw new IllegalArgumentException("A editora não pode ser vazia ou nula.");
        }

        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("O autor não pode ser vazio ou nulo.");
        }

        // Se tudo estiver certo, atribui
        this.titulo = titulo.trim();
        this.ano = ano;
        this.editora = editora.trim();
        this.autor = autor.trim();
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getEditora() {
        return editora;
    }

    public String getAutor() {
        return autor;
    }


    public String obterAutorFormatoAbnt() {
        int ultimoEspaco = autor.lastIndexOf(" ");
        String sobrenome = autor.substring(ultimoEspaco + 1).toUpperCase();
        String nome = autor.substring(0, ultimoEspaco);

        return "%s. %s.".formatted(sobrenome, nome);
    }

    /*O método obterInformacaoCompletaLivro retorna uma String no seguinte formato: ALENCAR, José de. Iracema. editora
    : Typ. de Viana & Filhos. 1865. Ou seja,
    Autor. Título. Editora: nome da editora. Ano.*/


    public String obterInformacaoCompletaLivro() {
        return obterAutorFormatoAbnt() + " %s. editora: %s. %d".formatted(titulo, editora, ano);

    }
}
