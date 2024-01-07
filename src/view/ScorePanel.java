package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModelImpl;

/**
 * Represents the drawing panel for the score.
 */
public class ScorePanel extends JPanel {
  private final TetrisModelImpl model;
  private final JLabel l1, l2, l3;

  /**
   * Constructs a new ScorePanel.
   * @param model the model to be used
   */
  public ScorePanel(TetrisModelImpl model) {
    this.model = model;

    this.setBackground(Color.BLACK);
    l1 = new JLabel();
    l1.setForeground(Color.WHITE);
    l2 = new JLabel();
    l2.setForeground(Color.WHITE);
    l3 = new JLabel();
    l3.setForeground(Color.WHITE);
    this.add(l1);
    this.add(l2);
    this.add(l3);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    l1.setText("Score: " + model.getScore());
    l2.setText("Level: " + model.getLevel());
    l3.setText("Lines Cleared: " + ((model.getLevel() - 1) * 10 + model.getLinesCleared()));
  }

  @Override
  public Dimension getPreferredSize() {
    Dimension d = new Dimension();
    d.setSize(125, 100);
    return d;
  }
}
