package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModel;
import model.pieces.Brick;
import model.pieces.Tetra;

import static view.TetrisPanel.determineColor;

/**
 * Represents the drawing panel for the next piece.
 */
public class NextPiecePanel extends JPanel {
  private final TetrisModel model;

  public NextPiecePanel(TetrisModel model) {
    this.model = model;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    this.setBackground(Color.BLACK);

    g2d.setColor(Color.WHITE);
    g2d.drawRect(0, 0, 125, 100);

    g2d.translate(50, 30);
    drawTetra(g2d, model.getNextPiece());
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(125, 100);
  }

  /**
   * Draws the given tetra.
   * @param g the graphics object
   * @param t the tetra to be drawn
   */
  private void drawTetra(Graphics2D g, Tetra t) {
    Color c = determineColor(t);
    for (Brick b : t.getBricks()) {
      Brick center = t.getCenterBrick();
      int x = center.getX() - b.getX();
      int y = center.getY() - b.getY();
      g.setColor(Color.WHITE);
      g.drawRect(x * 15, y * 15, 15, 15);
      g.setColor(c);
      g.fillRect(x * 15, y * 15, 15, 15);
    }

  }
}
