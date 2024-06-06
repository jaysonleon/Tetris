package view;

import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.ViewFeatures;
import model.TetrisModel;

/**
 * Represents the main frame of the Tetris game.
 */
public class TetrisGUI extends JFrame implements TetrisView {

  JPanel sidePanel1, sidePanel2;
  TetrisPanel panel;

  /**
   * Constructs a new TetrisGUI object.
   * @param m the model to be used
   */
  public TetrisGUI(TetrisModel m) {
    super("Tetris");
    setFocusable(true);
    setResizable(false);

    this.setBackground(Color.BLACK);
    this.setLayout(new BorderLayout());

    panel = new TetrisPanel(m);
    sidePanel1 = new SidePanel1(m);
    sidePanel2 = new SidePanel2(m);

    add(panel, BorderLayout.CENTER);
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
        switch (e.getKeyCode()) {
          case KeyEvent.VK_LEFT:
            features.moveLeft();
            break;
          case KeyEvent.VK_RIGHT:
            features.moveRight();
            break;
          case 's', 'S', KeyEvent.VK_DOWN:
            features.moveDown();
            features.calcPointsSoftDrop();
            break;
          case KeyEvent.VK_UP:
            features.rotateCW();
            break;
          default:
            break;
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
  public void sendLines(int lines) {
    panel.repaint(); 
    sidePanel1.repaint();
    sidePanel2.repaint();
  }

  @Override
  public void showMessage(String message) {
    panel.showMessage(message);
  }
}
