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
        for (int qtlinha=0 ; qtlinha<3 ; qtlinha++) {
            System.out.println(campos.get(qtlinha).getMarcado());
            if (campos.get(qtlinha).getMarcado()){
                campos.parallelStream().filter(campo -> campo.getLinha() >= 0 && campo.getLinha()>=2);
                campos.indexOf(qtlinha);
                int a = campos.get(qtlinha).getLinha() + campos.get(qtlinha).getColuna();
                System.out.println(a);
            }
//            System.out.println(campos.parallelStream().filter(campo -> campo.getLinha() >= 0 && campo.getLinha()>=2)
//                    .allMatch(campo -> campo.getMarcado()));
        }

         campos.parallelStream()
                .filter(c -> c.getLinha() >= 0 && c.getColuna() >= 2)
                .allMatch(c -> c.toString().equalsIgnoreCase("X"));
        return false;
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



//    public int checaLinhas(){
//        for(int linha=0 ; linha<3 ; linha++){
//
//            if( (tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
//                return -1;
//            if( (tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
//                return 1;
//        }
//
//        return 0;
//
//    }
//
//    public int checaColunas(){
//        for(int coluna=0 ; coluna<3 ; coluna++){
//
//            if( (tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
//                return -1;
//            if( (tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
//                return 1;
//        }
//
//        return 0;
//
//    }
//
//    public int checaDiagonais(){
//        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
//            return -1;
//        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
//            return 1;
//        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
//            return -1;
//        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
//            return 1;
//
//        return 0;
//    }

    public boolean objetivoAlcancado() {
        return false;
    }
}
