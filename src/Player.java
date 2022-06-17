import java.util.ArrayList;

public class Player {
    
    private boolean status;
    private int pontos;
    private int namePlayer;
    

    public Player(int i) {
        this.namePlayer = i;
        this.status = true;
        this.pontos = 0;
    }

    public int getNamePlayer() {
        return namePlayer;
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
