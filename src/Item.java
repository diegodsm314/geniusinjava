import java.util.Random;

public class Item {
    private Color color;

    public Item() {
        this.color = getRandColor();
    }

    private Color getRandColor() {
        Random rand = new Random();
        int r = (rand.nextInt()%4);
        return Color.values()[r];
    }


    public Color getColor() {
        return color;
    }

    
}
