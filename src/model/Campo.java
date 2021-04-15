package model;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    private final int linha;
    private final int coluna;
    private  int jogador = 1;
    private boolean marcado;
    private String x = "x";
    private String o = "O";

    private List<Campo> vizinhos = new ArrayList<>();

    public Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;

    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public int getJogador() {
        return jogador;
    }

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }

    public void alternarMarcacao() {
            marcado = !marcado;
    }

    public boolean getMarcado(){
        return this.marcado = marcado;
    }

    public void reiniciar(){
        marcado = false;
    }

    public String toString() {
        if (jogador == 1 && marcado){
            return x;
        }else if(jogador == 2 && marcado)
            return o;
        return " ";
    }

}
