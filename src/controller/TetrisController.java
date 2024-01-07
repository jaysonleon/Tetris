package controller;

import java.util.Timer;
import java.util.TimerTask;

import model.ModelFeatures;
import model.TetrisModelImpl;
import view.TetrisView;

public class TetrisController implements ViewFeatures, ModelFeatures {

  private final TetrisModelImpl model;
  private final TetrisView view;
  private Timer timer;
  private Difficulty diff;

  // the current delay between ticks of the timer
  private int period;

  public TetrisController(TetrisModelImpl model, TetrisView view) {
    this(model, view, "easy");
  }

  public TetrisController(TetrisModelImpl model, TetrisView view, String diff) {
    this.model = model;
    this.view = view;
    this.diff = selectDifficulty(diff);
    view.addFeatures(this);
    model.addFeatures(this);

    this.period = this.diff.getDelay();

    timer = new Timer(); {
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          if (!model.isGameOver()) {
            model.moveDown();
          }
        }
      }, 0, this.period);
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

  private Difficulty selectDifficulty(String diff) {
    return switch (diff.toLowerCase()) {
      case "medium", "m" -> Difficulty.MEDIUM;
      case "hard", "h" -> Difficulty.HARD;
      default -> Difficulty.EASY;
    };
  }

  @Override
  public void calcPointsSoftDrop() {
    model.calcPointsSoftDrop();
  }

  @Override
  public void updateLevel() {
    int i = model.getLevel();
    int diff = this.diff.getDelay();
    this.period = diff - ((i - 1) * diff / 20);

    if (this.period < 100) {
      this.period -= 10;
      if (this.period < 50) {
        this.period = 50;
      }
    }

    timer.cancel();
    timer = new Timer(); {
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          if (!model.isGameOver()) {
            model.moveDown();
          }
        }
      }, 0, this.period);
    }
  }
}
