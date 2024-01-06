package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModelImpl;

public class SidePanel1 extends JPanel {
  private JPanel score, nextPiece;
  private JLabel l1;

  public SidePanel1(TetrisModelImpl model) {
    this.setLayout(new BorderLayout());

    this.setBackground(Color.WHITE);

    l1 = new JLabel("Next Piece:");
    score = new ScorePanel(model);
    nextPiece = new NextPiecePanel(model);

    this.add(l1, BorderLayout.NORTH);
    this.add(score, BorderLayout.SOUTH);
    this.add(nextPiece, BorderLayout.CENTER);

    this.setVisible(true);
  }
}
