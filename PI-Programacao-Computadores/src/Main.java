import util.Entrada;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<String[]> listaFuncionarios = new ArrayList<>();
    private static ArrayList<String[]> categoriasObjetos = new ArrayList<>();
    private static ArrayList<String[]> listaObjetos = new ArrayList<>();
    private static ArrayList<String[]> listaManutencao = new ArrayList<>();
    private static ArrayList<String[]> listaEmprestimos = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    private static String validarTexto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("O valor inserido não pode ser vazio ou nulo.");
        }
        return texto;
    }

    public static String capitalizar(String texto) {
        validarTexto(texto);
        return texto.transform(s ->
                s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase()
        );
    }

    private static void menu() {
        int opcao;
        do {
            System.out.println("=========================================");
            System.out.println("|  1 - Sistema de Pessoas               |");
            System.out.println("|  2 - Sistema de Categorias de Objetos |");
            System.out.println("|  3 - Sistema de Objetos               |");
            System.out.println("|  4 - Sistema de Manutenções           |");
            System.out.println("|  5 - Sistema de Empréstimos           |");
            System.out.println("|  0 - Sair                             |");
            System.out.println("=========================================\n");

            opcao = Entrada.leiaInt("Opção -> ");
            System.out.println();
            switch (opcao) {
                case 1: {
                    clientes();
                    break;
                }
                case 2: {
                    categorias();
                    break;
                }
                case 3: {
                    objetos();
                    break;
                }
                case 4: {
                    manutencoes();
                    break;
                }
                case 5: {
                    emprestimos();
                    break;
                }
                case 0: {
                    System.out.println("\n\n");

                    System.out.println("Lista de funcionários:");
                    for (String[] item : listaFuncionarios) {
                        System.out.println(Arrays.toString(item));
                    }

                    System.out.println("\nLista de categorias:");
                    for (String[] item : categoriasObjetos) {
                        System.out.println(Arrays.toString(item));
                    }

                    System.out.println("\nLista de objetos:");
                    for (String[] item : listaObjetos) {
                        System.out.println(Arrays.toString(item));
                    }

                    System.out.println("\nLista de manutenções:");
                    for (String[] item : listaManutencao) {
                        System.out.println(Arrays.toString(item));
                    }

                    System.out.println("\nLista de empréstimos:");
                    for (String[] item : listaEmprestimos) {
                        System.out.println(Arrays.toString(item));
                    }
                    System.out.println();


                    System.out.println("Finalizando o sistema...");
                    System.exit(0);
                }
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }

    //  submenu clientes
    private static void clientes() {
        int opcao;
        do {
            System.out.println("Menu do sistema de Pessoas");
            System.out.println();
            System.out.println(" 1 - Cadastrar nova pessoa");
            System.out.println(" 0 - Voltar");
            System.out.println();

            opcao = Entrada.leiaInt("Operação -> ");
            System.out.println();

            switch (opcao) {
                case 1: {
                    System.out.println("\nCadastro");
                    String nome = capitalizar(Entrada.leiaString("Nome -> "));
                    String email = capitalizar(Entrada.leiaString("E-mail -> "));

                    String[] pessoa = {nome, email};
                    listaFuncionarios.add(pessoa);

                    System.out.println("=> Pessoa cadastrada com sucesso! <= \n");
                    break;
                }
                case 0: {
                }
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }

    //  submenu categorias
    private static void categorias() {
        int opcao;
        do {
            System.out.println("Menu do sistema de Categorias de Objetos");
            System.out.println();
            System.out.println(" 1 - Cadastrar nova categoria");
            System.out.println(" 0 - Voltar");
            System.out.println();

            opcao = Entrada.leiaInt("Operação -> ");
            System.out.println();

            switch (opcao) {
                case 1: {

                    System.out.println("\nCadastro");
                    String nome = capitalizar(Entrada.leiaString("Nome -> "));
                    String descricao = capitalizar(Entrada.leiaString("Descrição -> "));

                    String[] categoria = {nome, descricao};
                    categoriasObjetos.add(categoria);

                    System.out.println("=> Tipo cadastrado com sucesso! <= \n");
                    break;
                }
                case 0: {
                }
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }

    private static void objetos() {
        int opcao;
        do {
            System.out.println("Menu do sistema de Objetos");
            System.out.println();
            System.out.println(" 1 - Cadastrar novo objeto");
            System.out.println(" 0 - Voltar");
            System.out.println();

            opcao = Entrada.leiaInt("Operação -> ");
            System.out.println();

            switch (opcao) {
                case 1: {
                    System.out.println("\nCadastro");
                    String nome = capitalizar(Entrada.leiaString("Nome do objeto -> "));
                    String situacao = capitalizar(Entrada.leiaString("Situação do objeto -> "));
                    String dono = capitalizar(Entrada.leiaString("Nome do dono -> "));
                    String categoria = capitalizar(Entrada.leiaString("Categoria do objeto -> "));

                    // TO DO: Será listado as pessoas e categorias disponiveis no sistema e uma validação se
                    // realmente é válido as entradas

                    String[] objeto = {nome, situacao, dono, categoria};
                    listaObjetos.add(objeto);

                    System.out.println("=> Objeto cadastrado com sucesso! <= \n");
                    break;
                }
                case 0: {
                }
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }

    private static void manutencoes() {
        int opcao;
        do {
            System.out.println("Menu do sistema de Manutenções");
            System.out.println();
            System.out.println(" 1 - Cadastrar nova manutenção");
            System.out.println(" 0 - Voltar");
            System.out.println();

            opcao = Entrada.leiaInt("Operação -> ");
            System.out.println();

            switch (opcao) {
                case 1: {
                    System.out.println("\nCadastro");
                    String idObjeto = Entrada.leiaString("ID do objeto -> ");
                    String nomeResponsavelManut = Entrada.leiaString("Nome do responsável pela manutenção -> ");
                    String dataEntrada = validarTexto(Entrada.leiaString("Data de entrada na manutenção -> "));
                    String dataSaida = validarTexto(Entrada.leiaString("Data de saída da manutenção -> "));

                    String[] objeto = {idObjeto, nomeResponsavelManut, dataEntrada, dataSaida};
                    listaManutencao.add(objeto);

                    System.out.println("=> Manutenção cadastrada com sucesso! <= \n");
                    break;
                }
                case 0: {
                }
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }

    private static void emprestimos() {
        int opcao;
        do {
            System.out.println("Menu do sistema de Empréstimos");
            System.out.println();
            System.out.println(" 1 - Cadastrar novo empréstimo");
            System.out.println(" 0 - Voltar");
            System.out.println();

            opcao = Entrada.leiaInt("Operação -> ");
            System.out.println();

            switch (opcao) {
                case 1: {
                    System.out.println("\nCadastro");
                    String idObjeto = Entrada.leiaString("ID do objeto -> ");
                    String nomeTomador = capitalizar(Entrada.leiaString("Nome do tomador -> "));
                    String dataEntrada = validarTexto(Entrada.leiaString("Data do empréstimo -> "));
                    String dataSaida = validarTexto(Entrada.leiaString("Data da devolução -> "));

                    // TODO: Será listado as pessoas disponiveis no sistema e uma validação se
                    // realmente é válido as entradas

                    String[] objeto = {idObjeto, nomeTomador, dataEntrada, dataSaida};
                    listaEmprestimos.add(objeto);

                    System.out.println("=> Manutenção cadastrada com sucesso! <= \n");
                    break;
                }
                case 0: {
                }
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }
}