import entidades.Categoria;
import entidades.Manutencao;
import entidades.Objeto;
import entidades.Pessoa;
import util.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    private static ArrayList<Categoria> listaCategorias = new ArrayList<>();
    private static ArrayList<Objeto> listaObjetos = new ArrayList<>();
    private static ArrayList<Manutencao> listaManutencoes = new ArrayList<>();
    private static ArrayList<String[]> listaEmprestimos = new ArrayList<>();
    private static final DateTimeFormatter DATA_FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        completarDados();
        menu();
    }

    private static void completarDados() {
        listaPessoas.addAll(List.of(
                new Pessoa("nome1", "email1"),
                new Pessoa("nome2", "email2"),
                new Pessoa("nome3", "email3"),
                new Pessoa("nome4", "email4"),
                new Pessoa("nome5", "email5")
        ));

        listaCategorias.addAll(List.of(
                new Categoria("categoria1", "descricao1"),
                new Categoria("categoria2", "descricao2"),
                new Categoria("categoria3", "descricao3"),
                new Categoria("categoria4", "descricao4"),
                new Categoria("categoria5", "descricao5")
        ));

        Objeto objeto1 = new Objeto("objeto1", "ativo", listaPessoas.get(2), listaCategorias.get(3));
        Objeto objeto2 = new Objeto("objeto2", "baixado", listaPessoas.get(1), listaCategorias.get(1));

        listaObjetos.addAll(List.of(
                objeto1, objeto2,
                new Objeto("objeto3", "ativo", listaPessoas.get(3), listaCategorias.get(2)),
                new Objeto("objeto4", "baixado", listaPessoas.get(2), listaCategorias.get(0)),
                new Objeto("objeto5", "ativo", listaPessoas.get(0), listaCategorias.get(4))
        ));


        listaManutencoes.addAll(List.of(
                new Manutencao(objeto1, "José", LocalDate.parse("01/01/2001", DATA_FORMATO), LocalDate.parse("02/01/2001",
                        DATA_FORMATO)),
                new Manutencao(objeto2, "Marcos", LocalDate.parse("05/12/2012", DATA_FORMATO), LocalDate.parse("20/12/2012",
                        DATA_FORMATO))
        ));
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
                    pessoas();
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

    //  submenu pessoas
    private static void pessoas() {
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
                    String email = validarTexto(Entrada.leiaString("E-mail -> "));

                    listaPessoas.add(new Pessoa(nome, email));
                    System.out.println("=> Pessoa cadastrada com sucesso! <= \n");
                    break;
                }
                case 2: {
                    System.out.println("Lista de pessoas cadastradas:");
                    listarPessoas();
                    System.out.println("----------------------\n");
                    break;
                }
                case 3: {
                    listarPessoas();
                    int idPessoa = Entrada.leiaInt("Código da pessoa que deseja alterar -> ");
                    Pessoa pessoa = listaPessoas.get(idPessoa - 1);
                    // TODO: validar se o idPessoa está visível

                    String nome = capitalizar(Entrada.leiaString("Novo nome -> "));
                    String email = validarTexto(Entrada.leiaString("Novo e-mail -> "));

                    pessoa.setNome(nome);
                    pessoa.setEmail(email);
                    System.out.println("=> Cadastro alterado com sucesso! <= \n");
                    break;
                }
                case 4: {
                    listarPessoas();
                    int idPessoa = Entrada.leiaInt("Código da pessoa que deseja excluir -> ");
                    listaPessoas.get(idPessoa - 1).excluir();
                    System.out.println("=> Cadastro excluído com sucesso! <= \n");
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

    private static void listarPessoas() {
        System.out.println("Código | Nome | E-mail");
        for (Pessoa pessoa : listaPessoas) {
            System.out.print(pessoa);
        }
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
                    System.out.println("Cadastro:");
                    String nome = capitalizar(Entrada.leiaString("Nome -> "));
                    String descricao = capitalizar(Entrada.leiaString("Descrição -> "));

                    listaCategorias.add(new Categoria(nome, descricao));
                    System.out.println("=> Categoria cadastrada com sucesso! <= \n");
                    break;
                }
                case 2: {
                    System.out.println("Lista de categorias cadastradas:");
                    listarCategorias();
                    System.out.println("----------------------\n");
                    break;
                }
                case 3: {
                    listarCategorias();
                    int idCategoria = Entrada.leiaInt("Código da categoria que deseja alterar -> ");
                    Categoria categoria = listaCategorias.get(idCategoria - 1);
                    // TODO: validar se o idCategoria está visível

                    String nome = capitalizar(Entrada.leiaString("Novo nome -> "));
                    String descricao = capitalizar(Entrada.leiaString("Nova descrição -> "));

                    categoria.setNome(nome);
                    categoria.setDescricao(descricao);
                    System.out.println("=> Cadastro alterado com sucesso! <= \n");
                    break;
                }
                case 4: {
                    listarCategorias();
                    int idCategoria = Entrada.leiaInt("Código da categoria que deseja excluir -> ");
                    listaCategorias.get(idCategoria - 1).excluir();
                    System.out.println("=> Cadastro excluído com sucesso! <= \n");
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

    private static void listarCategorias() {
        System.out.println("Código | Nome | Descrição");
        for (Categoria categoria : listaCategorias) {
            System.out.print(categoria);
        }
    }


    //  submenu objetos
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
                    System.out.println("Cadastro:");
                    String nome = capitalizar(Entrada.leiaString("Nome do objeto -> "));
                    String situacao = capitalizar(Entrada.leiaString("Situação do objeto (Ativo ou Baixado) -> "));

                    // TODO: Este trecho de codigo está repetido no case 3
                    System.out.println("\nLista de pessoas cadastradas: ");
                    listarPessoas();
                    int idDono = Entrada.leiaInt("Código do dono -> ");
                    Pessoa dono = listaPessoas.get(idDono - 1);

                    System.out.println("\nLista de categorias cadastradas:");
                    listarCategorias();
                    int idCategoria = Entrada.leiaInt("Código da categoria do objeto -> ");
                    Categoria categoria = listaCategorias.get(idCategoria - 1);

                    // TODO: validação se realmente é válido as entradas em vez de dar erro

                    listaObjetos.add(new Objeto(nome, situacao, dono, categoria));
                    System.out.println("=> Objeto cadastrado com sucesso! <= \n");
                    break;
                }
                case 2: {
                    System.out.println("Lista de objetos cadastrados:");
                    listarObjetos();
                    System.out.println("----------------------\n");
                    break;
                }
                case 3: {
                    listarObjetos();
                    int idObjeto = Entrada.leiaInt("Código do objeto que deseja alterar -> ");
                    Objeto objeto = listaObjetos.get(idObjeto - 1);
                    // TODO: validar se o idObjeto está visível

                    String nome = capitalizar(Entrada.leiaString("Novo nome -> "));
                    String sitaucao = capitalizar(Entrada.leiaString("Nova situação (Ativo ou Baixado) -> "));

                    System.out.println("\nLista de pessoas cadastradas: ");
                    listarPessoas();
                    int idDono = Entrada.leiaInt("Código do novo dono -> ");
                    Pessoa dono = listaPessoas.get(idDono - 1);

                    System.out.println("\nLista de categorias cadastradas:");
                    listarCategorias();
                    int idCategoria = Entrada.leiaInt("Código da nova categoria do objeto -> ");
                    Categoria categoria = listaCategorias.get(idCategoria - 1);

                    // TODO: validação se realmente é válido as entradas em vez de dar erro

                    objeto.setNome(nome);
                    objeto.setSituacao(sitaucao);
                    objeto.setDono(dono);
                    objeto.setCategoria(categoria);
                    System.out.println("=> Cadastro alterado com sucesso! <= \n");
                    break;
                }
                case 4: {
                    listarObjetos();
                    int idObjeto = Entrada.leiaInt("Código do objeto que deseja excluir -> ");
                    listaObjetos.get(idObjeto - 1).excluir();
                    System.out.println("=> Cadastro excluído com sucesso! <= \n");
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

    private static void listarObjetos() {
        System.out.println("Código | Nome | Situação | Nome dono | Nome categoria");
        for (Objeto objeto : listaObjetos) {
            System.out.print(objeto);
        }
    }


    //  submenu manutencoes
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
                    System.out.println("Cadastro:");

                    listarObjetos();
                    int idObjeto = Entrada.leiaInt("ID do objeto -> ");
                    Objeto objeto = listaObjetos.get(idObjeto - 1);

                    // TODO: codigo repetido no case 3
                    String responsavelManut = capitalizar(Entrada.leiaString("Nome do responsável pela manutenção -> "));
                    String entradaStr = validarTexto(Entrada.leiaString("Data de entrada na manutenção (DD/MM/AAAA) -> "));
                    String saidaStr = validarTexto(Entrada.leiaString("Data de saída da manutenção (DD/MM/AAAA) -> "));

                    try {
                        LocalDate dataEntrada = LocalDate.parse(entradaStr, DATA_FORMATO);
                        LocalDate dataSaida = LocalDate.parse(saidaStr, DATA_FORMATO);
                        listaManutencoes.add(new Manutencao(objeto, responsavelManut, dataEntrada, dataSaida));
                        System.out.println("=> Manutenção cadastrada com sucesso! <=\n");
                    } catch (Exception e) {
                        System.out.println("=> Data inválida! Use o formato DD/MM/AAAA. <=\n");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Lista de manutenções cadastradas:");
                    listarManutencoes();
                    System.out.println("----------------------\n");
                    break;
                }
                case 3: {
                    listarManutencoes();
                    int idManut = Entrada.leiaInt("Código da manutenção que deseja alterar -> ");
                    Manutencao manutencao = listaManutencoes.get(idManut - 1);
                    // TODO: validar se o idManut está visível

                    String responsavelManut = capitalizar(Entrada.leiaString("Nome do novo responsável pela " +
                            "manutenção -> "));
                    String entradaStr = validarTexto(Entrada.leiaString("Data de entrada na manutenção (DD/MM/AAAA) -> "));
                    String saidaStr = validarTexto(Entrada.leiaString("Data de saída da manutenção (DD/MM/AAAA) -> "));

                    try {
                        LocalDate dataEntrada = LocalDate.parse(entradaStr, DATA_FORMATO);
                        LocalDate dataSaida = LocalDate.parse(saidaStr, DATA_FORMATO);

                        manutencao.setNomeResponsavelManut(responsavelManut);
                        manutencao.setDataEntrada(dataEntrada);
                        manutencao.setDataSaida(dataSaida);
                        System.out.println("=> Cadastro alterado com sucesso! <=\n");
                    } catch (Exception e) {
                        System.out.println("=> Data inválida! Use o formato DD/MM/AAAA. <=\n");
                    }
                    break;
                }
                case 4: {
                    listarManutencoes();
                    int idManut = Entrada.leiaInt("Código da manutenção que deseja excluir -> ");
                    char manutConcluido = Entrada.leiaChar("Manutenção concluída? (S/N) ->");
                    listaManutencoes.get(idManut - 1).excluir(manutConcluido);
                    System.out.println("=> Cadastro excluído com sucesso! <= \n");
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

    private static void listarManutencoes() {
        System.out.println("Código | Nome objeto | Responsável pela manut. | Data entrada | Data saída");
        for (Manutencao manutencao : listaManutencoes) {
            System.out.print(manutencao);
        }
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