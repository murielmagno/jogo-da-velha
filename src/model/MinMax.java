package model;

import java.util.ArrayList;

public class MinMax {
    private int alfa = Integer.MIN_VALUE;
    private int beta = Integer.MAX_VALUE;

    public Tabuleiro minimaxDecision(Tabuleiro tabuleiro) {
        int melhor = MaxValue(tabuleiro);
        ArrayList<Tabuleiro> filhos = tabuleiro.getTodosFilhos();
        for (Tabuleiro filho : filhos) {
            if (filho.getValor() == melhor) {
                filho.mostra();
                return filho;
            }
        }
        return null;
    }

    private int MinValue(Tabuleiro tabuleiro) {
        if (tabuleiro.isTerminal()) {
            tabuleiro.setValor(tabuleiro.getResultado());
            return tabuleiro.getValor();
        } else {
            tabuleiro.setValor(Integer.MAX_VALUE);
            tabuleiro.setJogador(Jogador.Min);
            ArrayList<Tabuleiro> filhos = tabuleiro.getFilhos(tabuleiro);
            for (Tabuleiro filho : filhos) {
                int minValue = Math.min(tabuleiro.getValor(), MaxValue(filho));
                if (minValue < alfa) {
                    tabuleiro.setValor(minValue);
                    return tabuleiro.getValor();
                }
                tabuleiro.setValor(minValue);
            }
            if (tabuleiro.getValor() < beta) {
                beta = tabuleiro.getValor();
            }
            return tabuleiro.getValor();
        }
    }

    private int MaxValue(Tabuleiro tabuleiro) {
        if (tabuleiro.isTerminal()) {
            tabuleiro.setValor(tabuleiro.getResultado());
            return tabuleiro.getValor();
        } else {
            tabuleiro.setValor(Integer.MIN_VALUE);
            tabuleiro.setJogador(Jogador.Max);
            ArrayList<Tabuleiro> filhos = tabuleiro.getFilhos(tabuleiro);
            for (Tabuleiro filho : filhos) {
                int maxValue = Math.max(tabuleiro.getValor(), MinValue(filho));
                if (maxValue > beta) {
                    tabuleiro.setValor(maxValue);
                    return tabuleiro.getValor();
                }
                tabuleiro.setValor(maxValue);
            }
            if (tabuleiro.getValor() > alfa) {
                alfa = tabuleiro.getValor();
            }
            return tabuleiro.getValor();
        }
    }

}
