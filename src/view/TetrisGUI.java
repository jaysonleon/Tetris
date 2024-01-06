package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.ViewFeatures;
import model.TetrisModelImpl;

import static java.awt.event.KeyEvent.VK_LEFT;

public class TetrisGUI extends JFrame implements TetrisView {

  JPanel nextPiece, score, holdPiece, sidePanel1, sidePanel2;
  TetrisPanel panel;

  public TetrisGUI(TetrisModelImpl m) {
    super("Tetris");
    setFocusable(true);
//    setResizable(false);

    this.setLayout(new BorderLayout());

    panel = new TetrisPanel(m);
    add(panel, BorderLayout.CENTER);

//    nextPiece = new NextPiecePanel(m);
//    score = new ScorePanel(m);
//    holdPiece = new HoldPanel(m);
//
//    add(nextPiece, BorderLayout.EAST);
//    add(score, BorderLayout.NORTH);
//    add(holdPiece, BorderLayout.WEST);

    sidePanel1 = new SidePanel1(m);
    sidePanel2 = new SidePanel2(m);
    add(sidePanel1, BorderLayout.EAST);
    add(sidePanel2, BorderLayout.WEST);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }

  @Override
  public void addFeatures(ViewFeatures features) {
    this.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
          case 'a', 'A':
            features.moveLeft();
            break;
          case 'd', 'D':
            features.moveRight();
            break;
          case 's', 'S':
            features.moveDown();
            break;
          case 'z', 'Z':
            features.rotateCCW();
            break;
          case 'x', 'X':
            features.rotateCW();
            break;
          case 'c', 'C':
            features.hold();
            break;
          case ' ':
            features.drop();
            break;
          case 'q', 'Q':
            features.exitProgram();
            break;
          default:
            break;
        }
      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
          features.calcPointsSoftDrop();
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
        // do not care for keyReleased event
      }
    });
  }

  @Override
  public void updateView() {
    panel.repaint();
    sidePanel1.repaint();
    sidePanel2.repaint();
  }

  @Override
  public void showMessage(String message) {
    panel.showMessage(message);
  }


}
