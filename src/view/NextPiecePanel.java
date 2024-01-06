package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModelImpl;
import model.pieces.Brick;
import model.pieces.Tetra;

import static view.TetrisPanel.determineColor;

public class NextPiecePanel extends JPanel {
  private final TetrisModelImpl model;

  public NextPiecePanel(TetrisModelImpl model) {
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

    g2d.translate(40, 30);
    drawTetra(g2d, model.getNextPiece());
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(100, 100);
  }

  private void drawTetra(Graphics2D g, Tetra t) {
    Color c = determineColor(t);
    for (Brick b : t.getBricks()) {
      Brick center = t.getCenterBrick();
      int x = center.getX() - b.getX();
      int y = center.getY() - b.getY();
      g.setColor(Color.BLACK);
      g.drawRect(x * 15, y * 15, 15, 15);
      g.setColor(c);
      g.fillRect(x * 15, y * 15, 15, 15);
    }

  }
}
