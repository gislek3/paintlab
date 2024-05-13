import java.awt.Color;
import java.util.Random;

public class RandomColorFactory implements ColorFactory {
    Random random = new Random();


    @Override
    public Color getColor() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }
    
}
