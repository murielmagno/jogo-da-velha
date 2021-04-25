package model;


public class Computador extends Jogador {
    public Computador(int jogador) {
        super(jogador);
        System.out.println("Jogador 'Computador' criado!");
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }

    @Override
    public void Tentativa(Tabuleiro tabuleiro) {
        do {
            tentativa[0] = (int) (Math.random() * 3) +1;
            tentativa[1] = (int) (Math.random() * 3) +1;
            tentativa[0]--;
            tentativa[1]--;
        } while (!verificaTentativa(tentativa, tabuleiro));
    }
}