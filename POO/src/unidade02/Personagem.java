package unidade02;

public class Personagem {
    private String classe;
    private int nivel;
    private String[] proficiencias;
    private double vida;
    private int forca;
    private int defesa;

    public Personagem(String classe, int nivel, String[] proficiencias, double vida, int forca, int defesa) {
        this.classe = classe;
        this.nivel = nivel;
        this.proficiencias = proficiencias;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
    }

    public void atacar() {
        System.out.println("O personagem atacou!");
    }

    public void defender() {
        System.out.println("O personagem defendeu!");
    }

    public void andar() {
        System.out.println("O personagem está andando...");
    }

    public void interagir() {
        System.out.println("O personagem interagiu com o ambiente.");
    }

    // Getters

    public String getClasse() {
        return classe;
    }

    public int getNivel() {
        return nivel;
    }

    public String[] getProficiencias() {
        return proficiencias;
    }

    public double getVida() {
        return vida;
    }

    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }
}

