package view;


import model.Computador;
import model.Humano;
import model.Jogador;
import model.Tabuleiro;

import java.util.Scanner;

public class Console {
    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);

    private int rodada = 1, vez = 1;
    String nome1 = "";
    String nome2 = "";
    private Jogador jogador1;
    private Jogador jogador2;


    public void jogo() {
        tabuleiro = new Tabuleiro();
        adicionarJogador();

        while (Jogar()) ;
    }

    public void adicionarJogador() {
        System.out.println("----------------------");
        System.out.println("nome do jogador 1 [X]:");
        nome1 = entrada.next();
        System.out.println("Quem vai ser o Jogador 1 [X] ?");

        if (menu() == 1)
            this.jogador1 = new Humano(1);
        else
            this.jogador1 = new Computador(1);

        System.out.println("----------------------");
        System.out.println("nome do jogador 2 [O]:");
        nome2 = entrada.next();
        System.out.println("Quem vai ser o Jogador 2 [O] ?");

        if (menu() == 1)
            this.jogador2 = new Humano(2);
        else
            this.jogador2 = new Computador(2);

    }

    public int menu() {
        int opcao = 0;
        do {
            System.out.println(" ####### MENU #######  ");
            System.out.println("1. Humano");
            System.out.println("2. Computador");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            if (opcao != 1 && opcao != 2)
                System.out.println("Opção inválida! Tente novamente");
        } while (opcao != 1 && opcao != 2);
        return opcao;
    }

    public boolean Jogar() {
        if (vitoria() == 0) {
            System.out.println("----------------------");
            System.out.println("\nRodada " + rodada);
            System.out.println("É a vez do jogador " + jogada());
            if (jogada() == 1) {
                jogador1.jogar(tabuleiro);
            }else{
                jogador2.jogar(tabuleiro);
            }
            if (tabuleiro.tabuleiroCompleto()) {
                System.out.println("Tabuleiro Completo. Jogo deu velha");
                return false;
            }
            vez++;
            rodada++;
            return true;
        } else {
            if (vitoria() == -1)
                System.out.println("O Jogador (X), " + nome1 + " ganhou!");
            else
                System.out.println("O Jogador (O)," + nome2 + " ganhou!");
            return false;
        }
    }

    public int jogada() {
        if (vez % 2 == 1)
            return 1;
        else
            return 2;
    }

    public int vitoria() {
        if (tabuleiro.checaLinhas() == 1)
            return 1;
        else if (tabuleiro.checaColunas() == 1)
            return 1;
        else if (tabuleiro.checaDiagonais() == 1)
            return 1;
        else if (tabuleiro.checaLinhas() == -1)
            return -1;
        else if (tabuleiro.checaColunas() == -1)
            return -1;
        else if (tabuleiro.checaDiagonais() == -1)
            return -1;

        return 0;
    }

}

