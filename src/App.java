import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //[Seleção de modo de jogo]
        System.out.println("Digite a quantidade de jogadores");
        Game g = new Game(input.nextInt(),0);
        g.Gamming();
    }
}
