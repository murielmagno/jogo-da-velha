package view;

import exception.SairException;
import model.Jogador;
import model.MinMax;
import model.Tabuleiro;
import java.util.Scanner;

public class Console {

    private int ganhou = 0, pedeu = 0, empate = 0;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private MinMax minimax = new MinMax();
    private int iniciou = 1;

    public void start(){
        init();
    }

    public void init() {
        tabuleiro = new Tabuleiro();
        setTabuleiro(tabuleiro);
        iniciou = 1 - iniciou;
        if (iniciou == 0) {
            System.out.println("Você começa!");
            System.out.println("Você deve escolher uma linha e coluna entre [1,2,3]");
            tabuleiro.setJogador(Jogador.Min);
            tabuleiro.mostra();
            jogar();
        } else {
            System.out.println("Computador começa!");
            tabuleiro.setJogador(Jogador.Max);
            tabuleiro = minimax.minimaxDecision(tabuleiro);
            setTabuleiro(tabuleiro);
        }

    }

    public void jogar() {
        while (iniciou == 0 || iniciou ==2)
        if (tabuleiro.getJogador().equals(Jogador.Min) || tabuleiro.getJogador().equals(Jogador.Max)) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Informe uma linha: ");
            int linha = sc.nextInt();
            System.out.print("Informe uma coluna: ");
            int coluna1 = sc.nextInt();
            if (tabuleiro.getXY(linha -1,coluna1 -1)==null){
                if (linha != -1 || linha <=3 && coluna1 != -1 || coluna1 <=3) {
                    tabuleiro.setX(linha - 1, coluna1 - 1);

                    tabuleiro.setJogador(Jogador.Max);
                    tabuleiro = minimax.minimaxDecision(tabuleiro);

                    setTabuleiro(tabuleiro);
                    tabuleiro.setJogador(Jogador.Min);

                    if (tabuleiro.isTerminal()) {
                        System.out.println("Você ganhou? " + tabuleiro.perdeu() + "\nVocê perdeu? " + tabuleiro.ganhou() + "\nDeu empate? " + tabuleiro.empate());
                        if (tabuleiro.ganhou()) {
                            pedeu++;
                        }
                        if (tabuleiro.perdeu()) {
                            ganhou++;
                        }
                        if (tabuleiro.empate()) {
                            empate++;
                        }
                        System.out.println("Deseja continuar jogando?");
                        String jogo = sc.next();
                        if (jogo.equalsIgnoreCase("x")){
                            start();
                        }else {
                            throw new SairException("Saindoo...");
                        }
                    }
                }
            }else {
                System.out.println("Esse local já foi escolhido, marque outro lugar!!");
            }
        } else {
            System.out.println("Nao é sua vez ainda espere!");
        }
    }

    private void setTabuleiro(Tabuleiro tab) {
        tab.getXY(0, 0);
        tab.getXY(0, 1);
        tab.getXY(0, 2);

        tab.getXY(1, 0);
        tab.getXY(1, 1);
        tab.getXY(1, 2);

        tab.getXY(2, 0);
        tab.getXY(2, 1);
        tab.getXY(2, 2);
    }

}
