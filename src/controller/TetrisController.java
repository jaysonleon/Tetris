package controller;

import java.util.Timer;
import java.util.TimerTask;

import model.ModelFeatures;
import model.TetrisModelImpl;
import view.TetrisView;

public class TetrisController implements ViewFeatures, ModelFeatures {

  private final TetrisModelImpl model;
  private final TetrisView view;

  public TetrisController(TetrisModelImpl model, TetrisView view) {
    this(model, view, "easy");
  }

  public TetrisController(TetrisModelImpl model, TetrisView view, String diff) {
    this.model = model;
    this.view = view;
    view.addFeatures(this);
    model.addFeatures(this);

    int i = this.selectDifficulty(diff);

    Timer timer = new Timer(); {
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          if (!model.isGameOver()) {
            model.moveDown();
          }
        }
      }, 0, i);
    }
  }

  @Override
  public void moveLeft() {
    model.moveLeft();
  }

  @Override
  public void moveRight() {
    model.moveRight();
  }

  @Override
  public void moveDown() {
    model.moveDown();
  }

  @Override
  public void rotateCW() {
    model.rotateCW();
  }

  @Override
  public void rotateCCW() {
    model.rotateCCW();
  }

  @Override
  public void drop() {
    model.drop();
  }

  @Override
  public void hold() { model.hold(); }

  @Override
  public void run() {
    try {
      boolean gameStarted = true;
      while (gameStarted) {
        if (model.isGameOver()) {
          view.showMessage("Game Over!");
          gameStarted = false;
        }

      }
    } catch (Exception ignored) {
      // do nothing
    }
  }

  @Override
  public void exitProgram() {
    System.exit(0);
  }

  @Override
  public void updateView() {
    view.updateView();
  }

  private int selectDifficulty(String diff) {
    return switch (diff.toLowerCase()) {
      case "medium", "m" -> 500;
      case "hard", "h" -> 250;
      default -> 1000;
    };
  }

  @Override
  public void calcPointsSoftDrop() {
    model.calcPointsSoftDrop();
  }
}
