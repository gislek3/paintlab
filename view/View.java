package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import grid.GridCell;

public class View extends JPanel {
  
  private static final double OUTERMARGIN = 20;
  private static final double INNERMARGIN = 2;
  private ViewableModel model;
  
  // Constructor
  public View(ViewableModel model) {
    this.model = model;
    this.setBackground(Color.BLACK);
    this.setFocusable(true);
    this.setPreferredSize(new Dimension(300, 400));
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    drawGame(g2);
  }


  private void drawGame(Graphics2D g2) {
    Rectangle2D box = new Rectangle2D.Double(
      OUTERMARGIN,
      OUTERMARGIN,
      this.getWidth() - OUTERMARGIN * 2,
      this.getHeight() - OUTERMARGIN * 2
    );

    g2.setColor(Color.BLACK);
    g2.fill(box);

    CellPositionToPixelConverter converter = new CellPositionToPixelConverter(
      box, this.model.getDimension(), INNERMARGIN
    );
    drawCells(g2, this.model.getBoard(), converter); 
  }

  private void drawCells(Graphics2D g2, Iterable<GridCell<Color>> cells, CellPositionToPixelConverter converter) {
    for (GridCell<Color> cell : cells) {
      Rectangle2D box = converter.getBoundsForCell(cell.pos());

      Color color = (cell.value() == null) ? Color.DARK_GRAY : cell.value();
      g2.setColor(color);
      g2.fill(box);
    }
  }

}
