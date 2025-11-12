package unidade02;

public class Item {
    private int quantidade;
    private int raridade;

    public Item(int quantidade, int raridade) {
        this.quantidade = quantidade;
        this.raridade = raridade;
    }

    public void inspecionar() {
        System.out.println("Inspecionando o item...");
    }

    public void utilizar() {
        System.out.println("Item utilizado!");
    }

    public void largar() {
        System.out.println("Item largado.");
    }

    public void destruir() {
        System.out.println("Item destruído!");
    }

    // Getters
    public int getQuantidade() {
        return quantidade;
    }

    public int getRaridade() {
        return raridade;
    }
}
