import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int gotcha;
    private boolean modeGame;
    private ArrayList<Item> vector;
    private ArrayList<Player> players;
    private Show s = new Show();

    public Game(int numPlayers, int codeSelect) {
        this.modeGame = (numPlayers<2 ? true : false); //true=singleplayer; false=multiplayer
        this.players= new ArrayList<>();
        this.vector = new ArrayList<>();
        this.gotcha = modeSelect(codeSelect);
        addPlayer(numPlayers);
    }

    public int getGotcha() {
        return gotcha;
    }

    public void addGotcha() {
        this.gotcha++;
    }

    public ArrayList<Item> getVector() {
        return vector;
    }

    // Main game
    public void Gamming() throws Exception {
        int index = 0;
        int lastPlayer=99;
        while (verify()) {
            Player play = players.get(index);
            verifyPlayers();
            if (players.get(index).isStatus()) {          
                Item it = new Item();
                this.getVector().add(it);  
                try {
                    s.clear();
                    lastPlayer = play.getNamePlayer();
                    s.line("Jogador" + lastPlayer);
                    this.show(play);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!trying(play)) {
                    s.line("Errou!\n");
                    play.setStatus();  
                }
            }
            else{
                s.line("\nJogador"+play.getNamePlayer()+" está fora...\n");
            }

            //checkers
            index++;
            if(index==players.size()) index=0;
            if(play.getPoints()>=gotcha && modeGame) break;
        }
        s.endGame(lastPlayer);
    }

    public void createGamming() throws IOException, InterruptedException {
        int index = 0;
        boolean first = true;
        int lastPlayer=99;
        while (verify()) {
            Player play = players.get(index);

            //prymary checkers
            verifyPlayers();
            if(modeGame) break;

            if (players.get(index).isStatus()) {           
                try {
                    lastPlayer = play.getNamePlayer();
                    s.line("Jogador" + lastPlayer);
                    if(first)
                        addItem();
                    else{
                        show(play);
                        if (!trying(play)) {
                            s.line("Errou!\n");
                            play.setStatus();                
                        }
                        else{
                            addItem();
                        }
                    }
                    first = false;
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                s.line("\nJogador"+play.getNamePlayer()+" está fora...\n");
            }

            //increment checkers
            index++;
            if(index==players.size()) index=0;
        }
        s.endGame(lastPlayer);
    }

    // print game
    public void show(Player play) throws InterruptedException, IOException {
        System.out.print("Atenção");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            System.out.print(".");    
        }

        for (Item i : this.getVector()) {
            s.clear();
            Thread.sleep(500);
            System.out.println(i.getColor());
            Thread.sleep(1200);
            s.clear();
        }
    }

    // tryng accept
    public boolean trying(Player play) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int choose;
        s.line("Digite AZ0, VR1, AM2 ou VM3:");
        for (Item it : this.getVector()) {
            choose = input.nextInt();
            if (choose>3 || !it.getColor().equals(Color.values()[choose]))
                return false;
        }
        play.addPoints();
        s.clear();
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
    private void endGame() throws InterruptedException{
        s.line("Fim de jogo! \nPontuação:");
        for (Player player : players) {           
            s.line("Jogador"+player.getNamePlayer()+": "+player.getPoints());
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

    private void addItem() throws InterruptedException{
        Scanner input = new Scanner(System.in);
        Item it = new Item();
        int aux;
        s.clear();
        do{
            s.line("Crie uma cor");
            s.line("Digite AZUL = 0, VERDE = 1, AMARELO = 2 ou VERMELHO = 3:");
            aux = input.nextInt();
        }
        while(aux>3);
        it.setColor(aux);
        vector.add(it);
        s.clear();
    }

}
