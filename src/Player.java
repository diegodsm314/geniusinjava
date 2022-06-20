public class Player {
    
    private boolean status;
    private int points;
    private int namePlayer;
    

    public Player(int i) {
        this.namePlayer = i;
        this.status = true;
        this.points = 0;
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

    public int getPoints() {
        return points;
    }

    public void addPoints() {
        this.points++;
    }

    
}
