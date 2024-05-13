package view;

import java.awt.Color;

import grid.GridCell;
import grid.GridDimension;

public interface ViewableModel {
    GridDimension getDimension();
    Iterable<GridCell<Color>> getBoard();
}
