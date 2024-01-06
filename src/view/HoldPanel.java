package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModelImpl;
import model.pieces.Brick;
import model.pieces.Tetra;

public class HoldPanel extends JPanel {
  private final TetrisModelImpl model;

  public HoldPanel(TetrisModelImpl model) {
    this.model = model;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    this.setBackground(Color.WHITE);

    g2d.setColor(Color.BLACK);
    g2d.drawRect(0, 0, 100, 100);

    g2d.translate(50, 50);

    Tetra t = model.getHoldPiece();
    if (t == null) {
      return;
    } else {
      drawTetra(g2d, model.getHoldPiece());
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(100, 100);
  }

  private void drawTetra(Graphics2D g, Tetra t) {
    Color c = TetrisPanel.determineColor(t);
    for (Brick b : t.getBricks()) {
      Brick center = t.getCenterBrick();
      int x = b.getX() - center.getX();
      int y = b.getY() - center.getY();
      g.setColor(Color.BLACK);
      g.drawRect(x * 15,y * 15,15, 15);
      g.setColor(c);
      g.fillRect(x * 15, y * 15,15, 15);
    }
  }
}
