import java.util.ArrayList;

public class Player {
    private ArrayList<Item> vector;
    private boolean status;
    private int pontos;
    private int namePlayer;
    

    public Player(int i) {
        this.namePlayer = i;
        this.status = true;
        this.pontos = 0;
        this.vector = new ArrayList<>();
    }

    public int getNamePlayer() {
        return namePlayer;
    }

    public ArrayList<Item> getVector() {
        return vector;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus() {
        this.status = false;
    }

    public int getPontos() {
        return pontos;
    }

    public void addPontos() {
        this.pontos++;
    }

    
}
