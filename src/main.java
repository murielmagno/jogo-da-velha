
import model.Tabuleiro;
import view.Console;

public class main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();

        new Console(tabuleiro);

    }
}
