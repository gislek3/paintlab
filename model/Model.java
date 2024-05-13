import java.awt.Color;

import grid.Grid;

public class Model extends Grid<Color> {

    ColorFactory factory = new RandomColorFactory();

    //en mer modulær løsning
    public Model(int rows, int cols) {
        super(rows, cols);
    }

    //men dette ville også vært mulig:
    public Model() {
        super(8,8);
    }
}