import java.util.ArrayList;
import java.util.Scanner;

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

    public void Gamming() throws Exception{
        Item it = new Item();
        vector.add(it);
        try {
            show();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(!trying()){
            throw new Exception("Errou!");
        }
    }

    public void show() throws InterruptedException {
        for(Item i : this.vector){
            System.out.println(i.getColor());
            Thread.sleep(2000);
        }
    }

    public boolean trying() {
        Scanner input = new Scanner(System.in);
        int choose;
        System.out.println("Digite 0, 1, 2 ou 3:");
        for (Item it : this.vector) {
            choose = input.nextInt();
            if(!it.getColor().equals(Color.values()[choose]))
                return false;
        }
        return true;
    }

    
}
