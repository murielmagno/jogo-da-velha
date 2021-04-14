package view;


import exception.SairException;
import model.Campo;
import model.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Console {
    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);


    public Console(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        executarJogo();
    }

    private void executarJogo() {
        try {
            boolean continuar = true;

            while (continuar) {
                loopDoJogo();

                System.out.println("Outra partida? (S/n) ");
                String resposta = entrada.nextLine();

                if ("n".equalsIgnoreCase(resposta)) {
                    continuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
            }
        } catch (SairException e) {
            System.out.println("Bye");
        } finally {
            entrada.close();
        }
    }

    private void loopDoJogo() {
        try {
            System.out.println("Jogador");

            while (!tabuleiro.vitoria()) {
                System.out.println(tabuleiro);

                String digitado = valorDigitado("Digite x,y: ");

                Iterator<Integer> xy = Arrays.stream(digitado.split(","))
                        .map(d -> Integer.parseInt(d.trim())).iterator();

                tabuleiro.marcar(xy.next(), xy.next());
            }
            System.out.println(tabuleiro);
            System.out.println("Você ganhouuu! Parabens!");
        } catch (SairException e) {
            System.out.println(tabuleiro);
            System.out.println("Você saiu :3");
        }

    }

    private String valorDigitado(String texto) {
        System.out.println(texto);
        String digitado = entrada.nextLine();

        if ("sair".equalsIgnoreCase(digitado)) {
            throw new SairException("Tchau");
        }
        return digitado;
    }
}

