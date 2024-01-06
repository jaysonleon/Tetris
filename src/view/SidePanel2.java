package view;

import java.awt.*;

import javax.swing.*;

import model.TetrisModelImpl;

public class SidePanel2 extends JPanel {
  private JPanel hold;
  private JLabel l1;

  public SidePanel2(TetrisModelImpl m) {
    this.setLayout(new BorderLayout());

    this.setBackground(Color.WHITE);

    l1 = new JLabel("Hold Piece:");
    hold = new HoldPanel(m);

    this.add(l1, BorderLayout.NORTH);
    this.add(hold, BorderLayout.CENTER);

    this.setVisible(true);
  }

}
