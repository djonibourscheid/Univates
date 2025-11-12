package unidade04.atividade03;

import unidade04.atividade03.entidades.Jogador;
import unidade04.atividade03.entidades.Time;
import utils.Entrada;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final ArrayList<Jogador> LISTA_JOGADORES = new ArrayList<>();
    private static final ArrayList<Time> LISTA_TIMES = new ArrayList<>();

    public static void main(String[] args) {
        LISTA_JOGADORES.addAll(List.of(
                new Jogador("jogador1", "posicao1"),
                new Jogador("jogador2", "posicao2"),
                new Jogador("jogador3", "posicao3")
        ));

        LISTA_TIMES.addAll(List.of(
                new Time("time1", "tecnico1"),
                new Time("time2", "tecnico2"),
                new Time("time3", "tecnico3")
        ));

        int opcao;
        do {
            System.out.println("""
                    \n=====================================================
                    | [1] - Cadastrar jogador                           |
                    | [2] - Cadastrar time                              |
                    | [3] - Listar jogadores cadastrados                |
                    | [4] - Listar times cadastrados - sem os jogadores |
                    | [5] - Vincular jogador a um time                  |
                    | [6] - Listar dados completos de um time           |
                    | [7] - Sair.                                       |
                    =====================================================""");

            opcao = Entrada.leiaInt("Opção -> ");
            System.out.println();
            switch (opcao) {
                case 1:
                    cadastrarJogador();
                    break;
                case 2:
                    cadastrarTime();
                    break;
                case 3:
                    listarJogadoresCadastrados();
                    break;
                case 4:
                    listarTimesCadastrados();
                    break;
                case 5:
                    System.out.println("-> Vincular jogador a um time <-\n");

                    listarJogadoresCadastrados();
                    System.out.println();
                    listarTimesCadastrados();
                    System.out.println();

                    int idJogador = validarNumero(Entrada.leiaInt("Digite o código do jogador -> "));
                    int idTime = validarNumero(Entrada.leiaInt("Digite o código do time -> "));
                    vincularJogador(idJogador, idTime);
                    break;
                case 6:
                    idTime = validarNumero(Entrada.leiaInt("Digite o código do time para ver suas informações -> "));
                    listarTimeCompleto(idTime);
                    break;
                case 7:
                    System.out.println("-> Saindo do sistema... <-");
                    break;
                default:
                    System.out.println("-> Opção inválida! <-");
                    break;
            }
        } while (opcao != 7);
    }

    public static String validarTexto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("O texto inserido não pode ser vazio ou nulo.");
        }
        return texto;
    }

    public static int validarNumero(int valorInserido) {
        if (valorInserido <= 0) {
            throw new IllegalArgumentException("O valor inserido deve ser maior que 0.");
        }
        return valorInserido;
    }

    private static void cadastrarJogador() {
        System.out.println("Cadastro de jogador:");
        String nome = validarTexto(Entrada.leiaString("Digite o nome do jogador -> "));
        String posicao = validarTexto(Entrada.leiaString("Digite a posição do jogador -> "));

        LISTA_JOGADORES.add(new Jogador(nome, posicao));
        System.out.println("\n-> Jogador cadastrado! <-");
    }

    private static void cadastrarTime() {
        System.out.println("Cadastro de time:");
        String nome = validarTexto(Entrada.leiaString("Digite o nome do time -> "));
        String tecnico = validarTexto(Entrada.leiaString("Digite o nome do técnico do time -> "));

        LISTA_TIMES.add(new Time(nome, tecnico));
        System.out.println("\n-> Time cadastrado! <-");
    }

    private static void listarJogadoresCadastrados() {
        System.out.println("Lista de jogadores:");
        System.out.println("Código | Nome | Posição");
        for (Jogador j : LISTA_JOGADORES) {
            System.out.println(j);
        }
    }

    private static void listarTimesCadastrados() {
        System.out.println("Lista de times:");
        System.out.println("Código | Nome do time | Nome do técnico");
        for (Time t : LISTA_TIMES) {
            System.out.println(t);
        }
    }

    private static void vincularJogador(int idJogador, int idTime) {
        Jogador jogador = LISTA_JOGADORES.get(idJogador - 1);
        Time time = LISTA_TIMES.get(idTime - 1);

        System.out.println(time.addJogador(jogador)
                ? "-> Jogador vinculado com sucesso! <-"
                : "-> Jogador está vinculado a este time! <-"
        );
    }

    private static void listarTimeCompleto(int idTime) {
        Time time = LISTA_TIMES.get(idTime - 1);
        System.out.printf("%s%n%nJogadores:%n", time);

        if (time.getJogadores().isEmpty()) {
            System.out.println("Não há jogadores vinculados neste time.");
        } else {
            for (Jogador jogador : time.getJogadores()) {
                System.out.println(jogador.getNome() + " - " + jogador.getPosicao());
            }
        }
    }
}
