package unidade03.MeuRadio;

public class Main {
    public static void main(String[] args) {
        Radio radio1 = new Radio(110, 20, true);

        System.out.println("Rádio nº1 criado: " + radio1);

        System.out.println("\nTestes de ligar e desligar:");
        radio1.ligar();
        radio1.desligar();
        radio1.desligar();
        radio1.ligar();

        System.out.println("\nTeste volumes:");
        System.out.println("Volume atual: " + radio1.getVolume());
        radio1.incrementarVolume();
        radio1.incrementarVolume(30);
        radio1.decrementarVolume();
        radio1.decrementarVolume(50);


        System.out.println("\nTeste Estação: (com comportamento circular)");
        System.out.println("Estação atual: " + radio1.getEstacao());
        radio1.incrementarEstacao();
        radio1.incrementarEstacao(30);
        radio1.decrementarEstacao();
        radio1.decrementarEstacao(50);


        System.out.println("\nCriação de um rádio sem passar parámetros.");
        Radio radio2 = new Radio();
        System.out.println("Rádio 2: " + radio2);


        System.out.println("\nCriação de um rádio com parámetros acima dos limites.");
        Radio radio3 = new Radio(50, 50, false);
        System.out.println("Rádio 3: " + radio3);

        System.out.println();
        Radio radio4 = new Radio(200, 0, false);
        System.out.println("Rádio 4: " + radio4);
    }
}
