package model;

public class Tabuleiro {
    private final int qtLinhas = 3;
    private final int qtColunas = 3;

    private int[][] tabuleiro = new int[3][3];

    public Tabuleiro() {
        gerarCampos();
    }

    private void gerarCampos() {
        for (int i = 0; i < qtLinhas; i++) {
            for (int j = 0; j < qtColunas; j++) {
                tabuleiro[i][j] = 0;
            }
        }
    }

    public int getPosicao(int[] tentativa) {
        return tabuleiro[tentativa[0]][tentativa[1]];
    }

    public void setPosicao(int[] tentativa, int jogador) {
        if (jogador == 1)
            tabuleiro[tentativa[0]][tentativa[1]] = -1;
        else
            tabuleiro[tentativa[0]][tentativa[1]] = 1;

        exbir();
    }

    public int checaLinhas() {
        for (int linha = 0; linha < 3; linha++) {
            if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
                return -1;
            else if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
                return 1;
        }
        return 0;

    }

    public int checaColunas() {
        for (int coluna = 0; coluna < 3; coluna++) {

            if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
                return -1;
            else if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
                return 1;
        }

        return 0;

    }

    public int checaDiagonais() {
        if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
            return -1;
        else if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
            return 1;
        else if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
            return -1;
        else if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
            return 1;

        return 0;
    }

    public boolean tabuleiroCompleto() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tabuleiro[i][j] == 0)
                    return false;
        return true;
    }

    public void exbir() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == -1) {
                    System.out.print(" X ");
                }
                else if (tabuleiro[i][j] == 1) {
                    System.out.print(" O ");
                }
                else if (tabuleiro[i][j] == 0) {
                    System.out.print("   ");
                }
                if (j == 0 || j == 1)
                    System.out.print("|");
            }
            System.out.println();
        }
    }
}


