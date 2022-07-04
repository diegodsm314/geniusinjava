import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Show s = new Show();
        s.welcome();
        int numPlayers = s.numPlayers();
        int selectionMode = s.modeSelect(numPlayers);
        Game g;
        
        if(selectionMode==3){
            g = new Game(numPlayers,50);            //"infinite" mode
            s.clear();
            g.createGamming();
        }
        else if(selectionMode==2){
            g = new Game(numPlayers,50);            //"infinite" mode
            s.clear();
            g.Gamming();
        }
        else{
            g = new Game(numPlayers,s.codeSelect());
            s.clear();
            g.Gamming();
        }
        input.close();
    }
}
