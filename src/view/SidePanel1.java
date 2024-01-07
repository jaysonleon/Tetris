package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModelImpl;

/**
 * Represents the drawing panel for the right side of the GUI. Contains the NextPiecePanel, its label,
 * and the ScorePanel.
 */
public class SidePanel1 extends JPanel {
  /**
   * Constructs a new SidePanel1.
   * @param model the model to be used
   */
  public SidePanel1(TetrisModelImpl model) {
    this.setLayout(new BorderLayout());

    this.setBackground(Color.BLACK);

    JLabel l1 = new JLabel("Next Piece:");
    l1.setForeground(Color.WHITE);
    JPanel score = new ScorePanel(model);
    JPanel nextPiece = new NextPiecePanel(model);

    this.add(l1, BorderLayout.NORTH);
    this.add(score, BorderLayout.SOUTH);
    this.add(nextPiece, BorderLayout.CENTER);

    this.setVisible(true);
  }
}
