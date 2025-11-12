package unidade03.MinhaImobiliaria;

import utils.Entrada;

import java.util.ArrayList;

public class Main {
    private static final ArrayList<Imovel> listaImoveis = new ArrayList<>();

    public static void main(String[] args) {
        /*Imovel imovel1 = new Imovel("Rua 7", 34.8, 100000);
        Imovel imovel2 = new Imovel("Avenida 2 leste", 140.2, 432999);
        Imovel imovel3 = new Imovel("Estrada 3", 40, 125000);
        listaImoveis.add(imovel1);
        listaImoveis.add(imovel2);
        listaImoveis.add(imovel3);*/

        int opcao;
        do {
            System.out.println("""
                    ================================================
                    | [1] - Cadastrar imóvel                       |
                    | [2] - Listar todos os imóveis                |
                    | [3] - Obter valor metro quadrado dos imóveis |
                    | [4] - Sair                                   |
                    ================================================""");

            opcao = Entrada.leiaInt("Opção: ");
            switch (opcao) {
                case 1:
                    cadastrarImovel();
                    break;
                case 2:
                    listarImoveis();
                    break;
                case 3:
                    listarImoveisMetroQuadrado();
                    break;
                case 4:
                    System.out.println("-> Saindo do sistema... <-");
                    break;
                default:
                    System.out.println("-> Opção inválida! <-\n");
                    break;
            }
        } while (opcao != 4);

    }

    private static void cadastrarImovel() {
        System.out.println("\nCadastro de novo imóvel: ");
        String endereco = Imovel.validarTexto(Entrada.leiaString("Digite o endereço do imóvel -> "));
        double areaTotal = Imovel.validarNumero(Entrada.leiaDouble("Digite a area total do imóvel -> "));
        double valor = Imovel.validarNumero(Entrada.leiaDouble("Digite o valor do imóvel -> "));

        System.out.println("\n-> Imóvel cadastrado! <-\n");
        listaImoveis.add(new Imovel(endereco, areaTotal, valor));
    }

    private static void listarImoveis() {
        System.out.println("\nListagem de imóveis cadastrados:");
        for (Imovel imovel : listaImoveis) {
            System.out.println(imovel);
        }
        System.out.println();
    }

    private static void listarImoveisMetroQuadrado() {
        System.out.println("\nListagem da metragem quadrada dos imóveis cadastrados:");
        for (Imovel imovel : listaImoveis) {
            System.out.printf("%s - %.2f%n", imovel.getCODIGO_IMOVEL(), imovel.obterValorMetroQuadrado());
        }
        System.out.println();
    }
}

