package model;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private final int qtLinhas = 3;
    private final int qtColunas = 3;
    private boolean a = false;

    private final List<Campo> campos = new ArrayList<>();

    public Tabuleiro() {
        gerarCampos();
    }

    private void gerarCampos() {
        for (int i = 0; i < qtLinhas; i++) {
            for (int j = 0; j < qtColunas; j++) {
                campos.add(new Campo(i, j));
            }
        }
    }

    public void marcar(int linha, int coluna) {
        campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                .findFirst()
                .ifPresent(c -> c.alternarMarcacao());
    }

    public boolean vitoria(){
        System.out.println(campos);
        return campos.parallelStream()
                .filter(c -> c.getLinha() >= 0 && c.getColuna() >= 2)
                .allMatch(c -> c.toString().equalsIgnoreCase("X"));
    }


    public void reiniciar() {
        campos.stream().forEach(c -> c.reiniciar());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IN");
        for (int c = 0; c < qtColunas; c++) {
            if (c == 0){
                sb.append(" ");
            }else
                sb.append("  ");
            sb.append(c);
            sb.append(" ");
        }
        sb.append("\n");
        int k = 0;
        for (int i = 0; i < qtLinhas; i++) {
            sb.append(i);
            sb.append(" ");
            for (int j = 0; j < qtColunas; j++) {
                if (j == 0){
                    sb.append(" ");
                }else
                    sb.append(" | ");
                sb.append(campos.get(k));
                k++;
            }
            sb.append(" ");
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean objetivoAlcancado() {
        return false;
    }
}
