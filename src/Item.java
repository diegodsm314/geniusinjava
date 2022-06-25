import java.util.Random;

public class Item {
    private Color color;

    public Item() {
        this.color = getRandColor();
    }

    //new
    public Item(Color color) {
        this.color = color;
    }

    private Color getRandColor() {
        Random rand = new Random();
        int r = Math.abs(rand.nextInt()%4);
        return Color.values()[r];
    }


    public Color getColor() {
        return color;
    }


    
}
