package model;

import java.util.Scanner;

public class Computador extends Jogador {
    public Scanner entrada = new Scanner(System.in);
    public Computador(int jogador){
        super(jogador);
        System.out.println("Jogador 'Computador' criado!");
    }

    @Override
    public void jogar(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);

    }

    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        do{
            tentativa[0] = 1 + (int)(3*Math.random());
            tentativa[1] = 1 + (int)(3*Math.random());
            tentativa[0]--;
            tentativa[1]--;
        } while ( !verificaTentativa(tentativa, tabuleiro) );
    }
}