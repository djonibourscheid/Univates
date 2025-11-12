package unidade04.atividade03.entidades;

import java.util.ArrayList;

public class Time {
    private static int qtdTime = 0;

    private int codigo = ++qtdTime;
    private String nome;
    private String tecnico;
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public Time(String nome, String tecnico) {
        this.nome = nome;
        this.tecnico = tecnico;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public boolean addJogador(Jogador novoJogador) {
        for (Jogador jogador : jogadores) {
            if (novoJogador == jogador) {
                return false;
            }
        }

        this.jogadores.add(novoJogador);
        return true;
    }

    @Override
    public String toString() {
        return "%03d - %s - %s".formatted(codigo, nome, tecnico);
    }
}
