package unidade03.MinhaImobiliaria;

public class Imovel {
    private final String CODIGO_IMOVEL;
    private final String ENDERECO;
    private final double AREA_TOTAL;
    private final double VALOR;
    private static int quantidadeImoveis = 0;

    public Imovel(String endereco, double areaTotal, double valor) {
        this.CODIGO_IMOVEL = "AP%03d".formatted(++quantidadeImoveis);
        this.ENDERECO = validarTexto(endereco);
        this.AREA_TOTAL = validarNumero(areaTotal);
        this.VALOR = validarNumero(valor);
    }

    public String getCODIGO_IMOVEL() {
        return CODIGO_IMOVEL;
    }

    public static String validarTexto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("O texto inserido não pode ser vazio ou nulo.");
        }
        return texto;
    }

    public static double validarNumero(double valorInserido) {
        if (valorInserido <= 0) {
            throw new IllegalArgumentException("O valor inserido deve ser maior que 0.");
        }
        return valorInserido;
    }

    public double obterValorMetroQuadrado() {
        return (VALOR / AREA_TOTAL);
    }

    @Override
    public String toString() {
        return "%s - %s - %.2f m² - R$ %.2f".formatted(CODIGO_IMOVEL, ENDERECO, AREA_TOTAL, VALOR);
    }
}
