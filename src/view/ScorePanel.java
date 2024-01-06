package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModelImpl;

public class ScorePanel extends JPanel {
  private final TetrisModelImpl model;
  private final JLabel l1, l2;

  public ScorePanel(TetrisModelImpl model) {
    this.model = model;

    this.setBackground(Color.WHITE);
    l1 = new JLabel();
    l2 = new JLabel();
    this.add(l1);
    this.add(l2);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    l1.setText("Score: " + model.getScore());
    l2.setText("Level: " + model.getLevel());
  }

  @Override
  public Dimension getPreferredSize() {
    Dimension d = new Dimension();
    d.setSize(100, 100);
    return d;
  }



}
