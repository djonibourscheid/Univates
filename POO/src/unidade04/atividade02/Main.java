package unidade04.atividade02;

import utils.Entrada;

public class Main {
    private static final Pessoa[] LISTA_PESSOAS = new Pessoa[3];

    public static void main(String[] args) {
        System.out.println("Cadastro de 3 pessoas:");
        for (int i = 0; i < LISTA_PESSOAS.length; i++) {
            String nome = Entrada.leiaString("Digite o nome da pessoa " + (i + 1) + ": ");
            int idade = Entrada.leiaInt("Digite a idade da pessoa " + (i + 1) + ": ");

            System.out.println("\n------------\n");
            LISTA_PESSOAS[i] = new Pessoa(nome, idade);
        }

        for (int i = 0; i < LISTA_PESSOAS.length; i++) {
            System.out.printf("Pessoa nº%d: Nome: %s, Idade: %d%n", (i + 1), LISTA_PESSOAS[i].getNome(),
                    LISTA_PESSOAS[i].getIdade());
        }

        System.out.println("\nA pessoa mais velhas é:");
        Pessoa pessoaMaisVelha = getPessoaMaisVelha();
        System.out.println("Nome: " + pessoaMaisVelha.getNome() + ", Idade: " + pessoaMaisVelha.getIdade());

        System.out.println("\nA pessoa mais nova é:");
        Pessoa pessoaMaisNova = getPessoaMaisNova();
        System.out.println("Nome: " + pessoaMaisNova.getNome() + ", Idade: " + pessoaMaisNova.getIdade());
    }


    private static Pessoa getPessoaMaisVelha() {
        int idadeMaisAlta = 0;
        Pessoa pessoaMaisVelha = null;
        for (Pessoa p : LISTA_PESSOAS) {
            if (p.getIdade() > idadeMaisAlta) {
                pessoaMaisVelha = p;
                idadeMaisAlta = p.getIdade();
            }
        }
        return pessoaMaisVelha;
    }

    private static Pessoa getPessoaMaisNova() {
        int idadeMaisNova = 200;
        Pessoa pessoaMaisNova = null;
        for (Pessoa p : LISTA_PESSOAS) {
            if (p.getIdade() < idadeMaisNova) {
                pessoaMaisNova = p;
                idadeMaisNova = p.getIdade();
            }
        }
        return pessoaMaisNova;
    }
}

