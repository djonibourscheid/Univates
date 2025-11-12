package unidade04.atividade01;

import unidade04.atividade01.entidades.Aluno;
import unidade04.atividade01.entidades.Cidade;
import unidade04.atividade01.entidades.EstadoCivil;
import unidade04.atividade01.entidades.Religiao;
import utils.Entrada;

public class CadastroAlunos {
    private static Aluno[] alunos = new Aluno[3];

    public static void main(String[] args) {
        System.out.println("Cadastro de 3 alunos:");
        for (int i = 0; i < alunos.length; i++) {
            String nome = Entrada.leiaString("Digite o nome do aluno " + (i+1) + ": ");
            String dataNascimento = Entrada.leiaString("Digite a data de nascimento do aluno " + (i+1) + ": ");
            String religiao = Entrada.leiaString("Digite a religião do aluno " + (i+1) + ": ");
            String estadoCivil = Entrada.leiaString("Digite o estado civil do aluno " + (i+1) + ": ");
            String cidade = Entrada.leiaString("Digite a cidade do aluno " + (i+1) + ": ");
            String cepCidade = Entrada.leiaString("Digite o CEP desta cidade: ");

            System.out.println("\n------------\n");
            alunos[i] = new Aluno(nome, dataNascimento, new Religiao(religiao), new EstadoCivil(estadoCivil),
                    new Cidade(cidade, cepCidade));
        }

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
