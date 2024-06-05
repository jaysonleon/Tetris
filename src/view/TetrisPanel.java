package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModelImpl;
import model.pieces.Brick;
import model.pieces.Tetra;

/**
 * Represents the main drawing panel for the Tetris game. Draws the board and the current piece.
 */
public class TetrisPanel extends JPanel {
  private final TetrisModelImpl model;

  /**
   * Constructs a new TetrisPanel.
   * @param model the model to be used
   */
  public TetrisPanel(TetrisModelImpl model) {
    this.model = model;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    this.setBackground(Color.BLACK);
    Graphics2D g2d = (Graphics2D) g;
    this.setBackground(Color.BLACK);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    drawBoard(g2d);

    Tetra t = model.getCurrentPiece();
    this.drawTetra(g2d, t);
  }

  /**
   * Draws the board.
   * @param g2d the graphics object
   */
  private void drawBoard(Graphics2D g2d) {
    // draw the grid lines
    for (int y = 0; y < model.getBoard().getHeight(); y++) {
      for (int x = 0; x < model.getBoard().getWidth(); x++) {
        g2d.setColor(Color.WHITE);
<<<<<<< Updated upstream
        g2d.drawRect(x * 20, y * 20, 20, 20);
=======
        g2d.drawRect(x * 20, y * 20, 20, 20)
>>>>>>> Stashed changes

        // draw the bricks, if present on the board
        if (model.getBoard().isOccupied(x, y)) {
          Brick b = model.getBoard().getBrickAt(x, y);
          Color c = determineColor(b);
          g2d.setColor(Color.WHITE);
          g2d.drawRect(x * 20, y * 20, 20, 20);
          g2d.setColor(c);
          g2d.fillRect(x * 20, y * 20, 20, 20);
        }
      }
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(200, 400);
  }

  /**
   * Draws the given tetra.
   * @param g the graphics object
   * @param t the tetra to be drawn
   */
  private void drawTetra(Graphics2D g, Tetra t) {
    Color c = determineColor(t);
    for (Brick b : t.getBricks()) {
      g.setColor(Color.WHITE);
      g.drawRect(b.getX() * 20, b.getY() * 20, 20, 20);
      g.setColor(c);
      g.fillRect(b.getX() * 20, b.getY() * 20, 20, 20);
    }

  }

  /**
   * Determines the color of the given tetra.
   * @param t the tetra to be checked
   * @return the color of the tetra
   */
  public static Color determineColor(Tetra t) {
    return determineColor(t.getCenterBrick());
  }

  /**
   * Determines the color of the given brick.
   * @param b the brick to be checked
   * @return the color of the brick
   */
  public static Color determineColor(Brick b) {
    return b.getType().getColor();
  }

  /**
   * Shows the given message in a popup.
   * @param message the message to be shown
   */
  public void showMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }
}
