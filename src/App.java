import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Show s = new Show();
        s.welcome();
        int numPlayers = s.numPlayers();
        Game g = new Game(numPlayers,s.codeSelect());
        if(s.modeSelect(numPlayers)){
            s.clear();
            g.createGamming();
        }
        else {
            s.clear();
            g.Gamming();
        }
        
    }
}
