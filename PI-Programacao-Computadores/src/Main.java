import entidades.*;
import util.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    private static ArrayList<Categoria> listaCategorias = new ArrayList<>();
    private static ArrayList<Objeto> listaObjetos = new ArrayList<>();
    private static ArrayList<Manutencao> listaManutencoes = new ArrayList<>();
    private static ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();
    private static final DateTimeFormatter DATA_FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        completarDados();
        menu();
    }

    private static void completarDados() {
        Pessoa pessoa = new Pessoa("nome1", "email1");
        listaPessoas.addAll(List.of(
                pessoa,
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

        Objeto objeto1 = new Objeto("objeto1", "Ativo", listaPessoas.get(2), listaCategorias.get(3));
        Objeto objeto2 = new Objeto("objeto2", "Baixado", listaPessoas.get(1), listaCategorias.get(1));
        Objeto objeto3 = new Objeto("objeto3", "Ativo", listaPessoas.get(3), listaCategorias.get(2));

        listaObjetos.addAll(List.of(
                objeto1, objeto2, objeto3,
                new Objeto("objeto4", "Baixado", listaPessoas.get(2), listaCategorias.get(0)),
                new Objeto("objeto5", "Ativo", listaPessoas.get(0), listaCategorias.get(4))
        ));


        LocalDate data1 = LocalDate.parse("01/01/2001", DATA_FORMATO);
        LocalDate data2 = LocalDate.parse("02/01/2001", DATA_FORMATO);

        listaManutencoes.addAll(List.of(
                new Manutencao(objeto1, "José", data1, data2),
                new Manutencao(objeto2, "Marcos", data1, data2)
        ));


        listaEmprestimos.add(new Emprestimo(objeto3, pessoa, data1, data2));
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
                    listarPessoas();
                    break;
                }
                case 3: {
                    int qtdPessoas = listarPessoas();
                    if (qtdPessoas == 0) break;

                    int idPessoa = Entrada.leiaInt("Código da pessoa que deseja alterar -> ");
                    Pessoa pessoa = listaPessoas.get(idPessoa - 1);

                    // valida se a pessoa está visível
                    if (!pessoa.validarVisibilidade()) break;

                    String nome = capitalizar(Entrada.leiaString("Novo nome -> "));
                    String email = validarTexto(Entrada.leiaString("Novo e-mail -> "));

                    pessoa.update(nome, email);
                    System.out.println("=> Cadastro alterado com sucesso! <= \n");
                    break;
                }
                case 4: {
                    int qtdPessoas = listarPessoas();
                    if (qtdPessoas == 0) break;

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

    private static int listarPessoas() {
        int tempCount = 0;

        System.out.println("Lista de pessoas cadastradas:");
        System.out.println("Código | Nome | E-mail");

        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.isVisivel()) {
                System.out.print(pessoa);
                tempCount++;
            }
        }

        if (tempCount == 0) System.out.println("Não há pessoas cadastradas.");

        System.out.println("----------------------\n");
        return tempCount;
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
                    listarCategorias();
                    break;
                }
                case 3: {
                    int qtdCategorias = listarCategorias();
                    if (qtdCategorias == 0) break;

                    int idCategoria = Entrada.leiaInt("Código da categoria que deseja alterar -> ");
                    Categoria categoria = listaCategorias.get(idCategoria - 1);

                    // valida se a categoria está visível
                    if (!categoria.validarVisibilidade()) break;

                    String nome = capitalizar(Entrada.leiaString("Novo nome -> "));
                    String descricao = capitalizar(Entrada.leiaString("Nova descrição -> "));

                    categoria.update(nome, descricao);
                    System.out.println("=> Cadastro alterado com sucesso! <= \n");
                    break;
                }
                case 4: {
                    int qtdCategorias = listarCategorias();
                    if (qtdCategorias == 0) break;

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

    private static int listarCategorias() {
        int tempCount = 0;

        System.out.println("Lista de categorias cadastradas:");
        System.out.println("Código | Nome | Descrição");

        for (Categoria categoria : listaCategorias) {
            if (categoria.isVisivel()) {
                System.out.print(categoria);
                tempCount++;
            }
        }

        if (tempCount == 0) System.out.println("Não há categorias cadastradas.");

        System.out.println("----------------------\n");
        return tempCount;
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
                    try {
                        System.out.println();
                        int qtdPessoas = listarPessoas();
                        if (qtdPessoas == 0) break;
                        int idDono = Entrada.leiaInt("Código do dono -> ");
                        Pessoa dono = listaPessoas.get(idDono - 1);
                        if (!dono.validarVisibilidade()) break;


                        System.out.println();
                        int qtdCategorias = listarCategorias();
                        if (qtdCategorias == 0) break;
                        int idCategoria = Entrada.leiaInt("Código da categoria do objeto -> ");
                        Categoria categoria = listaCategorias.get(idCategoria - 1);
                        if (!categoria.validarVisibilidade()) break;


                        listaObjetos.add(new Objeto(nome, situacao, dono, categoria));
                        System.out.println("=> Objeto cadastrado com sucesso! <= \n");
                    } catch (Exception e) {
                        System.out.println("=> Código do dono ou da categoria não válido. Tente novamente. <=\n");
                    }

                    break;
                }
                case 2: {
                    listarObjetos();
                    break;
                }
                case 3: {
                    int qtdObjetos = listarObjetos();
                    if (qtdObjetos == 0) break;

                    int idObjeto = Entrada.leiaInt("Código do objeto que deseja alterar -> ");
                    Objeto objeto = listaObjetos.get(idObjeto - 1);

                    // valida se o objeto está visível
                    if (!objeto.validarVisibilidade()) break;

                    String nome = capitalizar(Entrada.leiaString("Novo nome -> "));
                    String situacao = capitalizar(Entrada.leiaString("Nova situação (Ativo ou Baixado) -> "));

                    try {
                        System.out.println();
                        int qtdPessoas = listarPessoas();
                        if (qtdPessoas == 0) break;

                        int idDono = Entrada.leiaInt("Código do dono -> ");
                        Pessoa dono = listaPessoas.get(idDono - 1);
                        if (!dono.validarVisibilidade()) break;


                        System.out.println("\nLista de categorias cadastradas:");
                        listarCategorias();
                        int idCategoria = Entrada.leiaInt("Código da categoria do objeto -> ");

                        Categoria categoria = listaCategorias.get(idCategoria - 1);
                        if (!categoria.validarVisibilidade()) break;


                        objeto.update(nome, situacao, dono, categoria);
                        System.out.println("=> Cadastro alterado com sucesso! <= \n");
                    } catch (Exception e) {
                        System.out.println("=> Código do dono ou da categoria não válido. Tente novamente. <=\n");
                    }

                    break;
                }
                case 4: {
                    int qtdObjetos = listarObjetos();
                    if (qtdObjetos == 0) break;

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

    private static int listarObjetos() {
        int tempCount = 0;

        System.out.println("Lista de objetos cadastrados:");
        System.out.println("Código | Nome | Situação | Nome dono | Nome categoria");

        for (Objeto objeto : listaObjetos) {
            if (objeto.isVisivel()) {
                System.out.print(objeto);
                tempCount++;
            }
        }

        if (tempCount == 0) System.out.println("Não há objetos cadastrados.");

        System.out.println("----------------------\n");
        return tempCount;
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

                    System.out.println("Lista de objetos:");
                    System.out.println("Código | Nome | Situação | Nome dono | Nome categoria");
                    int tempCount = 0;
                    for (Objeto objeto : listaObjetos) {
                        if (objeto.getSituacao().equals("Baixado") && objeto.isVisivel()) {
                            System.out.print(objeto);
                            tempCount++;
                        }
                    }
                    if (tempCount == 0) {
                        System.out.println("Não há objetos baixados para manutenções.");
                        System.out.println("----------------------\n");
                        break;
                    }

                    int idObjeto = Entrada.leiaInt("ID do objeto -> ");
                    Objeto objeto = listaObjetos.get(idObjeto - 1);
                    if (!objeto.validarVisibilidade()) break;

                    // TODO: codigo repetido no case 3
                    String responsavelManut = capitalizar(Entrada.leiaString("Nome do responsável pela manutenção -> "));

                    try {
                        String dataEntradaStr = validarTexto(Entrada.leiaString("Data de entrada na manutenção (DD/MM/AAAA) -> "));
                        LocalDate dataEntrada = LocalDate.parse(dataEntradaStr, DATA_FORMATO);

                        String dataSaidaStr = validarTexto(Entrada.leiaString("Data de saída da manutenção (DD/MM/AAAA) -> "));
                        LocalDate dataSaida = LocalDate.parse(dataSaidaStr, DATA_FORMATO);

                        listaManutencoes.add(new Manutencao(objeto, responsavelManut, dataEntrada, dataSaida));
                        System.out.println("=> Manutenção cadastrada com sucesso! <=\n");
                    } catch (Exception e) {
                        System.out.println("=> Data inválida! Use o formato DD/MM/AAAA. <=\n");
                    }
                    break;
                }
                case 2: {
                    listarManutencoes();
                    break;
                }
                case 3: {
                    int qtdManut = listarManutencoes();
                    if (qtdManut == 0) break;

                    int idManut = Entrada.leiaInt("Código da manutenção que deseja alterar -> ");
                    Manutencao manutencao = listaManutencoes.get(idManut - 1);

                    // valida se a manutencao está visível
                    if (!manutencao.validarVisibilidade()) break;

                    String responsavelManut = capitalizar(Entrada.leiaString("Nome do novo responsável pela manutenção -> "));

                    try {
                        String dataEntradaStr = validarTexto(Entrada.leiaString("Nova data de entrada na manutenção (DD/MM/AAAA) -> "));
                        LocalDate dataEntrada = LocalDate.parse(dataEntradaStr, DATA_FORMATO);

                        String dataSaidaStr = validarTexto(Entrada.leiaString("Nova data de saída da manutenção (DD/MM/AAAA) -> "));
                        LocalDate dataSaida = LocalDate.parse(dataSaidaStr, DATA_FORMATO);

                        manutencao.update(responsavelManut, dataEntrada, dataSaida);
                        System.out.println("=> Cadastro alterado com sucesso! <=\n");
                    } catch (Exception e) {
                        System.out.println("=> Data inválida! Use o formato DD/MM/AAAA. <=\n");
                    }
                    break;
                }
                case 4: {
                    int qtdManut = listarManutencoes();
                    if (qtdManut == 0) break;

                    int idManut = Entrada.leiaInt("Código da manutenção que deseja excluir -> ");
                    listaManutencoes.get(idManut - 1).excluir();
                    System.out.println("=> Cadastro excluído com sucesso e objeto voltou ao status de 'Ativo'! <= \n");
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

    private static int listarManutencoes() {
        int tempCount = 0;

        System.out.println("Lista de manutenções cadastradas:");
        System.out.println("Código | Nome objeto | Nome do dono | Responsável pela manut. | Data entrada | Data saída");

        for (Manutencao manutencao : listaManutencoes) {
            if (manutencao.isVisivel()) {
                System.out.print(manutencao);
                tempCount++;
            }
        }

        if (tempCount == 0) System.out.println("Não há manutenções cadastradas.");

        System.out.println("----------------------\n");
        return tempCount;
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
                    System.out.println("Cadastro:");

                    System.out.println("Lista de objetos:");
                    System.out.println("Código | Nome | Situação | Nome dono | Nome categoria");
                    int tempCount = 0;
                    for (Objeto objeto : listaObjetos) {
                        if (objeto.getSituacao().equals("Ativo") && objeto.isVisivel()) {
                            System.out.print(objeto);
                            tempCount++;
                        }
                    }
                    if (tempCount == 0) {
                        System.out.println("Não há objetos disponíveis para empréstimos.");
                        System.out.println("----------------------\n");
                        break;
                    }

                    int idObjeto = Entrada.leiaInt("ID do objeto -> ");
                    Objeto objeto = listaObjetos.get(idObjeto - 1);

                    if (!objeto.validarVisibilidade()) break;
                    if (!objeto.getSituacao().equals("Ativo")) {
                        System.out.println("=> Objeto não pode ser emprestado. Tente novamente. <=\n");
                        break;
                    }


                    System.out.println("Lista de pessoas:");
                    System.out.println("Código | Nome | E-mail");
                    tempCount = 0;
                    for (Pessoa pessoa : listaPessoas) {
                        if (!pessoa.equals(objeto.getDono())) {
                            System.out.print(pessoa);
                            tempCount++;
                        }
                    }
                    if (tempCount == 0) {
                        System.out.println("Não há pessoas disponíveis para emprestar o objeto.");
                        System.out.println("----------------------\n");
                        break;
                    }

                    int idTomador = Entrada.leiaInt("\nID do tomador -> ");
                    Pessoa tomador = listaPessoas.get(idTomador - 1);

                    if (!tomador.validarVisibilidade()) break;
                    if (tomador.equals(objeto.getDono())) {
                        System.out.println("=> Não é possível emprestar um objeto para o dono do objeto! <=\n");
                        break;
                    }


                    try {
                        String dataEmprestimoStr = validarTexto(Entrada.leiaString("Data do empréstimo (DD/MM/AAAA) -> "));
                        LocalDate dataEmprestimo = LocalDate.parse(dataEmprestimoStr, DATA_FORMATO);

                        String dataDevolucaoStr = validarTexto(Entrada.leiaString("Data da devolução (DD/MM/AAAA) -> "));
                        LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr, DATA_FORMATO);

                        listaEmprestimos.add(new Emprestimo(objeto, tomador, dataEmprestimo, dataDevolucao));
                        System.out.println("=> Empréstimo cadastrado com sucesso! <=\n");
                    } catch (Exception e) {
                        System.out.println("=> Data inválida! Use o formato DD/MM/AAAA. <=\n");
                    }
                    break;
                }
                case 2: {
                    listarEmprestimos();
                    break;
                }
                case 3: {
                    int qtdEmprestimos = listarEmprestimos();
                    if (qtdEmprestimos == 0) break;

                    int idEmprestimo = Entrada.leiaInt("Código do empréstimo que deseja alterar -> ");
                    Emprestimo emprestimo = listaEmprestimos.get(idEmprestimo - 1);

                    // valida se o emprestimo está visível
                    if (!emprestimo.validarVisibilidade()) break;

                    try {
                        String dataEmprestimoStr = validarTexto(Entrada.leiaString("Nova data do empréstimo (DD/MM/AAAA) -> "));
                        LocalDate dataEmprestimo = LocalDate.parse(dataEmprestimoStr, DATA_FORMATO);

                        String dataDevolucaoStr = validarTexto(Entrada.leiaString("Nova data da devolução (DD/MM/AAAA) -> "));
                        LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr, DATA_FORMATO);

                        emprestimo.update(dataEmprestimo, dataDevolucao);
                        System.out.println("=> Cadastro alterado com sucesso! <=\n");
                    } catch (Exception e) {
                        System.out.println("=> Data inválida! Use o formato DD/MM/AAAA. <=\n");
                    }
                    break;
                }
                case 4: {
                    int qtdEmprestimos = listarEmprestimos();
                    if (qtdEmprestimos == 0) break;

                    int idEmprestimo = Entrada.leiaInt("Código do empréstimo que deseja excluir -> ");
                    listaEmprestimos.get(idEmprestimo - 1).excluir();
                    System.out.println("=> Cadastro excluído com sucesso e objeto devolvido ao status de 'Ativo'! <= \n");
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

    private static int listarEmprestimos() {
        int tempCount = 0;

        System.out.println("Lista de empréstimos cadastradas:");
        System.out.println("Código | Nome objeto | Nome do Dono | Nome do tomador | Data entrada | Data saída");


        for (Emprestimo emprestimo : listaEmprestimos) {
            if (emprestimo.isVisivel()) {
                System.out.print(emprestimo);
                tempCount++;
            }
        }

        if (tempCount == 0) System.out.println("Não há empréstimos cadastradas.");

        System.out.println("----------------------\n");
        return tempCount;
    }
}