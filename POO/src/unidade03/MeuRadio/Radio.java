package unidade03.MeuRadio;

public class Radio {
    // Variaveis de limite
    private final int ESTACAO_MIN = 88;
    private final int ESTACAO_MAX = 110;
    private final int VOLUME_MIN = 0;
    private final int VOLUME_MAX = 40;

    private int estacao; // limites de 88 a 110
    private int volume; // limites de 0 a 40
    private boolean estado; // ligado/desligado

    public Radio() {
        estacao = ESTACAO_MIN;
        volume = VOLUME_MAX / 2;
        estado = false;
    }

    public Radio(int estacao, int volume, boolean estado) {
        verificarNumeroValido(estacao);
        verificarNumeroValido(volume);

        if (estacao < ESTACAO_MIN) {
            estacao = ESTACAO_MIN;
            System.out.println("-> Valor inserido para 'Estação' é menor que os limites previstos. Valor configurado " +
                    "para 'Estação: " + estacao + " <-");
        }

        if (estacao > ESTACAO_MAX) {
            estacao = ESTACAO_MAX;
            System.out.println("-> Valor inserido para 'Estação' é maior que os limites previstos. Valor configurado " +
                    "para 'Estação: " + estacao + " <-");
        }

        if (volume < VOLUME_MIN) {
            volume = VOLUME_MIN;
            System.out.println("-> Valor inserido para 'Volume' é maior que os limites previstos. Valor configurado " +
                    "para 'Volume: " + volume + " <-");
        }

        if (volume > VOLUME_MAX) {
            volume = VOLUME_MAX;
            System.out.println("-> Valor inserido para 'Volume' é maior que os limites previstos. Valor configurado " +
                    "para 'Volume: " + volume + " <-");
        }

        this.estacao = estacao;
        this.volume = volume;
        this.estado = estado;
    }

    public int getEstacao() {
        return estacao;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isEstado() {
        return estado;
    }


    private void verificarNumeroValido(int numero) {
        if (numero < 0) throw new IllegalArgumentException("Os números inseridos não podem ser negativos.");
    }


    public void ligar() {
        if (estado) {
            System.out.println("O rádio já está ligado.");
            return;
        }
        estado = true;
        System.out.println("O rádio foi ligado.");
    }

    public void desligar() {
        if (!estado) {
            System.out.println("O rádio já está desligado.");
            return;
        }
        estado = false;
        System.out.println("O rádio foi desligado.");
    }


    public void incrementarEstacao() {
        int estacaoAntiga = estacao;
        estacao++;

        if (estacao > ESTACAO_MAX) {
            estacao = ESTACAO_MIN;
        }

        System.out.printf("Estação foi aumentado em 1: %d -> %d%n", estacaoAntiga, estacao);
    }

    public void incrementarEstacao(int quantidade) {
        verificarNumeroValido(quantidade);

        int estacaoAntiga = estacao;
        estacao += quantidade;

        while (estacao > ESTACAO_MAX) {
            estacao = estacao - ESTACAO_MAX + ESTACAO_MIN;
        }
        System.out.printf("Estação foi aumentado em %d: %d -> %d%n", quantidade, estacaoAntiga, estacao);

    }


    public void decrementarEstacao() {
        int estacaoAntiga = estacao;
        estacao--;

        if (estacao < ESTACAO_MIN) {
            estacao = ESTACAO_MAX;
        }

        System.out.printf("Estação foi diminuído em 1: %d -> %d%n", estacaoAntiga, estacao);
    }

    public void decrementarEstacao(int quantidade) {
        verificarNumeroValido(quantidade);

        int estacaoAntiga = estacao;
        estacao -= quantidade;

        while (estacao < ESTACAO_MIN) {
            estacao = estacao + ESTACAO_MAX - ESTACAO_MIN;
        }

        System.out.printf("Estação foi diminuído em %d: %d -> %d%n", quantidade, estacaoAntiga, estacao);
    }


    public void incrementarVolume() {
        if (volume == VOLUME_MAX) {
            System.out.println("O rádio já está no volume máximo.");
            return;
        }
        volume++;
        System.out.println("O volume foi aumentado em 1. Volume atual: " + volume);
    }

    public void incrementarVolume(int quantidade) {
        verificarNumeroValido(quantidade);

        if (volume == VOLUME_MAX) {
            System.out.println("O rádio já está no volume máximo.");
            return;
        }

        volume += quantidade;

        if (volume > VOLUME_MAX) {
            int valorAumentado = VOLUME_MAX - (volume - quantidade);

            volume = VOLUME_MAX;
            System.out.printf("O volume foi aumentado em %d e chegou no volume máximo. Volume atual: %d%n",
                    valorAumentado, volume);
            return;
        }

        System.out.printf("O volume foi aumentado em %d. Volume atual: %d%n", quantidade, volume);
    }


    public void decrementarVolume() {
        if (volume == VOLUME_MIN) {
            System.out.println("O rádio já está no volume mínimo.");
            return;
        }
        volume--;
        System.out.println("O volume foi diminuído em 1. Volume atual: " + volume);
    }

    public void decrementarVolume(int quantidade) {
        verificarNumeroValido(quantidade);

        if (volume == VOLUME_MIN) {
            System.out.println("O rádio já está no volume mínimo.");
            return;
        }

        volume -= quantidade;

        if (volume < VOLUME_MIN) {
            int valorDiminuido = VOLUME_MIN + (volume + quantidade);

            volume = VOLUME_MIN;
            System.out.printf("O volume foi diminuído em %d e chegou no volume mínimo. Volume atual: %d%n",
                    valorDiminuido, volume);
            return;
        }

        System.out.printf("O volume foi diminuído em %d. Volume atual: %d%n", quantidade, volume);
    }

    @Override
    public String toString() {
        return "{estação: %d, volume: %d, estado: %b}".formatted(estacao, volume, estado);
    }
}
