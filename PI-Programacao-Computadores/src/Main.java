import entidades.Pessoa;
import util.Entrada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
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
        while (true) {
            System.out.println("""
                    ========================================
                    | 1 - Sistema de Pessoas               |
                    | 2 - Sistema de Categorias de Objetos |
                    | 3 - Sistema de Objetos               |
                    | 4 - Sistema de Manutenções           |
                    | 5 - Sistema de Empréstimos           |
                    | 0 - Sair                             |
                    ========================================
                    """);

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
                    break;
                }
                default: {
                    System.out.println("Opção Inválida!");
                    break;
                }
            }
        }
    }

    //  submenu clientes
    private static void clientes() {
        int opcao;
        do {
            System.out.println("""
                    Menu do sistema de Pessoas:
                    1 - Cadastrar nova pessoa
                    2 - Listar pessoas
                    3 - Alterar uma pessoa
                    4 - Excluir uma pessoa
                    0 - Voltar
                    """);

            opcao = Entrada.leiaInt("Operação -> ");
            System.out.println();

            switch (opcao) {
                case 1: {
                    System.out.println("Cadastro:");
                    String nome = capitalizar(Entrada.leiaString("Nome -> "));
                    String email = capitalizar(Entrada.leiaString("E-mail -> "));

                    listaPessoas.add(new Pessoa(nome, email));

                    System.out.println("=> Pessoa cadastrada com sucesso! <= \n");
                    break;
                }
                case 2: {
                    System.out.println("Lista de pessoas cadastradas:");
                    System.out.println("Código | Nome | E-mail");
                    for (Pessoa pessoa : listaPessoas) {
                        System.out.println(pessoa);
                    }
                    System.out.println("----------------------\n");
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Opção Inválida!");
                    break;
                }
            }
        } while (opcao != 0);
    }

    //  submenu categorias
    private static void categorias() {
        int opcao;
        do {
            System.out.println("""
                    Menu do sistema de Categorias de Objetos:
                    1 - Cadastrar nova categoria
                    2 - Listar categorias
                    3 - Alterar uma categoria
                    4 - Excluir uma categoria
                    0 - Voltar
                    """);

            opcao = Entrada.leiaInt("Operação -> ");
            System.out.println();

            switch (opcao) {
                case 1: {
                    System.out.println("Cadastro");
                    String nome = capitalizar(Entrada.leiaString("Nome -> "));
                    String descricao = capitalizar(Entrada.leiaString("Descrição -> "));

                    String[] categoria = {nome, descricao};
                    categoriasObjetos.add(categoria);

                    System.out.println("=> Tipo cadastrado com sucesso! <= \n");
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Opção Inválida!");
                    break;
                }
            }
        } while (opcao != 0);
    }

    private static void objetos() {
        int opcao;
        do {
            System.out.println("""
                    Menu do sistema de Objetos:
                    1 - Cadastrar novo objeto
                    2 - Listar objetos
                    3 - Alterar um objeto
                    4 - Excluir um objeto
                    0 - Voltar
                    """);

            opcao = Entrada.leiaInt("Operação -> ");
            System.out.println();

            switch (opcao) {
                case 1: {
                    System.out.println("Cadastro");
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
                    break;
                }
                default: {
                    System.out.println("Opção Inválida!");
                    break;
                }
            }
        } while (opcao != 0);
    }

    private static void manutencoes() {
        int opcao;
        do {
            System.out.println("""
                    Menu do sistema de Manutenções:
                    1 - Cadastrar nova manutenção
                    2 - Listar manutenções
                    3 - Alterar uma manutenção
                    4 - Excluir uma manutenção
                    0 - Voltar
                    """);

            opcao = Entrada.leiaInt("Operação -> ");
            System.out.println();

            switch (opcao) {
                case 1: {
                    System.out.println("Cadastro");
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
                    break;
                }
                default: {
                    System.out.println("Opção Inválida!");
                    break;
                }
            }
        } while (opcao != 0);
    }

    private static void emprestimos() {
        int opcao;
        do {
            System.out.println("""
                    Menu do sistema de Empréstimos:
                    1 - Cadastrar novo empréstimo
                    2 - Listar empréstimos
                    3 - Alterar um empréstimo
                    4 - Excluir um empréstimo
                    0 - Voltar
                    """);

            opcao = Entrada.leiaInt("Operação -> ");
            System.out.println();

            switch (opcao) {
                case 1: {
                    System.out.println("Cadastro");
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
                    break;
                }
                default: {
                    System.out.println("Opção Inválida!");
                    break;
                }
            }
        } while (opcao != 0);
    }
}