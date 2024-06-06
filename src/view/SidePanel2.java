package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModel;

/**
 * Represents the drawing panel for the right side of the GUI. Contains the HoldPanel and its label.
 */
public class SidePanel2 extends JPanel {
  /**
   * Constructs a new SidePanel2.
   * @param m the model to be used
   */
  public SidePanel2(TetrisModel m) {
    this.setLayout(new BorderLayout());

    this.setBackground(Color.BLACK);

    JLabel l1 = new JLabel("Hold Piece:");
    JPanel hold = new HoldPanel(m);

    this.add(l1, BorderLayout.NORTH);
    l1.setForeground(Color.WHITE);
    this.add(hold, BorderLayout.CENTER);

    this.setVisible(true);
  }
}
