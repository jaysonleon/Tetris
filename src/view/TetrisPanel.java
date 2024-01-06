package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModelImpl;
import model.pieces.Brick;
import model.pieces.Tetra;

public class TetrisPanel extends JPanel {
  private final TetrisModelImpl model;

  public TetrisPanel(TetrisModelImpl model) {
    this.model = model;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    drawBoard(g2d);

    Tetra t = model.getCurrentPiece();
    this.drawTetra(g2d, t);
  }

  private void drawBoard(Graphics2D g2d) {
    for (int y = 0; y < model.getBoard().getHeight(); y++) {
      for (int x = 0; x < model.getBoard().getWidth(); x++) {
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x * 20, y * 20, 20, 20);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x * 20, y * 20, 20, 20);

        if (model.getBoard().isOccupied(x, y)) {
          Brick b = model.getBoard().getBrickAt(x, y);
          Color c = determineColor(b);
          g2d.setColor(Color.BLACK);
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

  private void drawTetra(Graphics2D g, Tetra t) {
    Color c = this.determineColor(t);
    for (Brick b : t.getBricks()) {
      g.setColor(Color.BLACK);
      g.drawRect(b.getX() * 20, b.getY() * 20, 20, 20);
      g.setColor(c);
      g.fillRect(b.getX() * 20, b.getY() * 20, 20, 20);
    }

  }

  public static Color determineColor(Tetra t) {
    return determineColor(t.getCenterBrick());
  }

  public static Color determineColor(Brick b) {
    switch (b.getTetraType()) {
      case I:
        return Color.CYAN;
      case J:
        return Color.BLUE;
      case L:
        return Color.ORANGE;
      case O:
        return Color.YELLOW;
      case S:
        return Color.GREEN;
      case T:
        return new Color(120, 7, 203);
      case Z:
        return Color.RED;
      default:
        throw new IllegalArgumentException("Invalid Tetra type");
    }
  }

  public void showMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }
}
