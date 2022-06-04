import java.util.ArrayList;

public class Game {
    private ArrayList<Item> vector;
    private int gotcha;

    public Game(){
        this.vector = new ArrayList<>();
        gotcha = 0;
    }

    public ArrayList<Item> getVector() {
        return vector;
    }


    public int getGotcha() {
        return gotcha;
    }

    public void addGotcha() {
        this.gotcha++;
    }

    public void Gamming(){
        Item it = new Item();
        vector.add(it);
        show();
    }

    public void show() {
        for(Item i : this.vector){
            System.out.println(i.getColor());
        }
    }

    
}
