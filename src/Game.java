import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int gotcha;
    private boolean modeGame;
    private ArrayList<Player> players;

    public Game(int numPlayers, int codeSelect) {
        this.modeGame = (numPlayers<2 ? true : false); //true=singleplayer; false=multiplayer
        this.players= new ArrayList<>();
        this.gotcha = modeSelect(codeSelect);
        addPlayer(numPlayers);
    }

    public int getGotcha() {
        return gotcha;
    }

    public void addGotcha() {
        this.gotcha++;
    }

    // Main game
    public void Gamming() throws Exception {
        int index = 0;
        while (verify()) {
            Player play = players.get(index);
            if (players.get(index).isStatus()) {          
                Item it = new Item();
                play.getVector().add(it);
                try {
                    System.out.println("Jogador" + play.getNamePlayer());
                    show(play);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!trying(play)) {
                    System.out.println("Errou!\n");
                    play.setStatus();
                    
                }
            }
            else{
                System.out.println("\nJogador"+play.getNamePlayer()+" está fora...\n");
                verifyPlayers();
            }

            //checkers
            index++;
            if(index==players.size()) index=0;
            if(play.getPontos()>=gotcha && modeGame) break;
        }
        endGame();
    }

    // print game
    public void show(Player play) throws InterruptedException {
        for (Item i : play.getVector()) {
            System.out.println(i.getColor());
            Thread.sleep(1200);
        }
    }

    // tryng accept
    public boolean trying(Player play) {
        Scanner input = new Scanner(System.in);
        int choose;
        System.out.println("Digite AZ0, VR1, AM2 ou VM3:");
        for (Item it : play.getVector()) {
            choose = input.nextInt();
            if (!it.getColor().equals(Color.values()[choose]))
                return false;
        }
        play.addPontos();
        return true;
    }


    // new player add
    private void addPlayer(int numPlayers) {
        for (int i = 0; i < numPlayers && i < 4; i++) {
            players.add(new Player(i));
        }
    }

    //check satatus player
    private boolean verify() {
        for (Player player : players) {
            if(player.isStatus()){
                return true;
            }
        }
        return false;
    }

    //ending game
    private void endGame(){
        System.out.println("Fim de jogo! \nPontuação:");
        for (Player player : players) {           
            System.out.println("Jogador"+player.getNamePlayer()+": "+player.getPontos());
        }
    }

    private int modeSelect( int code) {
        switch(code){
            case 0: return 4; //TESTE
            case 10: return 8;
            case 20: return 14;
            case 30: return 20;
            case 40: return 31;
            default: throw new Error("Error ModeSelect: Erro ao dissemimar escolha");
        }
        
    }

    private void verifyPlayers(){
        int coutPlayers=0;
        for (int i = 0; i < players.size(); i++) {
            if(!players.get(i).isStatus()) coutPlayers++;
        }
        if(coutPlayers==1){
            this.modeGame=true;
        }
    }

}
