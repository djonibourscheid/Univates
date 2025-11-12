package unidade03.MeuLivro;

import utils.Entrada;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cadastro de livros:");
        String titulo = Entrada.leiaString("Insira o título do livro: ");
        int ano = Entrada.leiaInt("Insira o ano do livro: ");
        String editora = Entrada.leiaString("Insira a editora do livro: ");
        String autor = Entrada.leiaString("Insira o nome do autor(a) do livro: ");

        Livro livro = new Livro(titulo, ano, editora, autor);

        System.out.println("Nome do autor na forma ABNT: " + livro.obterAutorFormatoAbnt());
        System.out.println("Informações completas do livro na forma ABNT: " + livro.obterInformacaoCompletaLivro());
    }
}
