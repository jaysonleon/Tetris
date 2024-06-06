package view;

import java.awt.*;
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
        char keyChar = Character.toLowerCase(e.getKeyChar());
        switch (keyChar) {
          case 'a':
          case 'A':
            features.moveLeft();
            break;
          case 'd':
          case 'D':
            features.moveRight();
            break;
          case 's':
          case 'S':
            features.moveDown();
            break;
          case 'z':
          case 'Z':
            features.rotateCCW();
            break;
          case 'x':
          case 'X':
            features.rotateCW();
            break;
          case 'c':
          case 'C':
            features.hold();
            break;
          case ' ':
            features.drop();
            break;
          case 'q':
          case 'Q':
            features.exitProgram();
            break;
          default:
            break;
        }
      }

      @Override
      public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
          case KeyEvent.VK_LEFT:
            features.moveLeft();
            break;
          case KeyEvent.VK_RIGHT:
            features.moveRight();
            break;
          case KeyEvent.VK_DOWN:
          case 's':
          case 'S':
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
