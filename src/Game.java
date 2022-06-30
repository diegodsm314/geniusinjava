import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int gotcha;
    private boolean modeGame;
    private ArrayList<Item> colorSequence; //colorSeq
    private ArrayList<Player> players;
    private Show s = new Show();
    private boolean win;
    

    public Game(int numPlayers, int codeSelect) {
        this.modeGame = (numPlayers<2 ? true : false); //true=singleplayer; false=multiplayer
        this.players= new ArrayList<>();
        this.colorSequence = new ArrayList<>();
        this.gotcha = modeSelect(codeSelect);
        this.win = true;
        addPlayer(numPlayers);
    }

    // Main game
    public void Gamming() throws Exception {
        int index = 0;
        int lastPlayer=99;
        while (verify()) {
            Player play = players.get(index);
            lastPlayer = play.getNamePlayer();

            //prymary checker
            if(this.verifyPlayers()) break;;

            if (players.get(index).isStatus()) {          
                Item it = new Item();
                this.getColorSequence().add(it);  
                try {
                    s.clear();
                    s.line("Jogador" + lastPlayer);
                    this.showColors(play);
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
                s.waitText(20);
            }

            //checkers
            index++;
            if(index==players.size()) index=0;
            if(play.getPoints()>=gotcha) {
                win = true;
                break;
            }
            else win = false;
        }
        s.endGame(lastPlayer, win || !modeGame);
    }

    public void createGamming() throws IOException, InterruptedException {
        int index = 0;
        boolean first = true;
        int lastPlayer=99;
        while (verify()) {
            Player play = players.get(index);
            lastPlayer = play.getNamePlayer();

            //prymary checker
            if(this.verifyPlayers()) break;

            if (players.get(index).isStatus()) {           
                try {
                    s.line("Jogador" + lastPlayer);
                    if(first)
                        addItem();
                    else{
                        showColors(play);
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
        s.endGame(lastPlayer,true);
    }

    private ArrayList<Item> getColorSequence() {
        return colorSequence;
    }

    // show color sequence
    private void showColors(Player play) throws InterruptedException {
        //just print
        s.line("Atenção");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            System.out.print(".");    
        }

        //engine
        for (Item i : this.getColorSequence()) {
            s.clear();
            Thread.sleep(500);
            System.out.println(i.getColor());
            Thread.sleep(1200);
            s.clear();
        }
    }

    // tryng accept
    private boolean trying(Player play) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Integer choose;
        s.line("Digite AZUL = 0, VERDE = 1, AMARELO = 2 ou VERMELHO = 3:");
        for (Item it : this.getColorSequence()) {
            try {
                choose = input.nextInt();
                if (choose>3 || !it.getColor().equals(Color.getColor(choose)))
                    return false;
            } catch (Exception e) {
                s.line("Caractere incorreto!!");
                s.waitText(20);
                return false;
            }
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

    private int modeSelect( int code) {
        switch(code){
            case 0: return 4; //TESTE
            case 10: return 8;
            case 20: return 14;
            case 30: return 20;
            case 40: return 31;
            case 50: return 999;
            default: throw new Error("Error ModeSelect: Erro ao dissemimar escolha");
        }        
    }

    private boolean verifyPlayers(){
        int coutPlayers=0;
        for (int i = 0; i < players.size(); i++) {
            if(!players.get(i).isStatus()) coutPlayers++;
        }
        if(coutPlayers==1){
            return true;
        }
        return false;
    }

    private void addItem() throws InterruptedException{
        Scanner input = new Scanner(System.in);
        int aux;
        s.clear();
        do{
            s.line("Crie uma cor");
            s.line("Digite AZUL = 0, VERDE = 1, AMARELO = 2 ou VERMELHO = 3:");
            aux = input.nextInt();
        }
        while(aux>3);
        Item it = new Item(Color.getColor(aux));
        colorSequence.add(it);
        s.clear();
        input.close();
    }

}
