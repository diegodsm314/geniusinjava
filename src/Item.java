import java.util.Random;

public class Item {
    private Color color;

    public Item() {
        this.color = getRandColor();
    }

    private Color getRandColor() {
        Random rand = new Random();
        int r = Math.abs(rand.nextInt()%4);
        return Color.values()[r];
    }


    public Color getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = Color.values()[color];
    }

    
}
