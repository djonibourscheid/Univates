package unidade02;

public class Magia {
    private int nivel;
    private int custoMana;
    private int tempoEspera;

    public Magia(int nivel, int custoMana, int tempoEspera) {
        this.nivel = nivel;
        this.custoMana = custoMana;
        this.tempoEspera = tempoEspera;
    }

    public void equipar() {
        System.out.println("Magia equipada!");
    }

    public void desequipar() {
        System.out.println("Magia desequipada!");
    }

    public void utilizar(String alvo) {
        System.out.println("Magia lançada contra " + alvo + "!");
    }

    // Getters

    public int getNivel() {
        return nivel;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }
}
