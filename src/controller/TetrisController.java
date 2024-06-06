package controller;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

import model.ModelFeatures;
import model.TetrisModel;
import view.TetrisView;

public class TetrisController implements ViewFeatures, ModelFeatures {
  // represents the player's game model 
  private final TetrisModel pModel;
  // represents the opponent's game model(s)
  private ArrayList<TetrisModel> oppModels; 
  private final TetrisView view;
  private Timer timer;
  private Difficulty diff;
  private Random rand; 

  // the current delay between ticks of the timer
  private int period;

  public TetrisController(TetrisModel model, TetrisView view) {
    this(model, view, "easy", null);
  }

  public TetrisController(TetrisModel model, TetrisView view, String diff, ArrayList<TetrisModel> opps) {
    this.pModel = model;
    this.view = view;
    this.diff = selectDifficulty(diff);
    this.oppModels = opps;
    rand = new Random(); 
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
    pModel.moveLeft();
  }

  @Override
  public void moveRight() {
    pModel.moveRight();
  }

  @Override
  public void moveDown() {
    pModel.moveDown();
  }

  @Override
  public void rotateCW() {
    pModel.rotateCW();
  }

  @Override
  public void rotateCCW() {
    pModel.rotateCCW();
  }

  @Override
  public void drop() {
    pModel.drop();
  }

  @Override
  public void hold() { pModel.hold(); }

  @Override
  public void run() {
    try {
      boolean gameStarted = true;
      while (gameStarted) {
        int playersLeft; 
        playersLeft = oppModels.size();
        if (pModel.isGameOver()) {
          view.showMessage("Game Over!");
          gameStarted = false;
        }
        for (TetrisModel oppModel : oppModels) {
          if (oppModel.isGameOver()) {
            playersLeft--;
          }
        }
        if (playersLeft == 0) {
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
    switch (diff.toLowerCase()) {
      case "medium":
      case "m":
        return Difficulty.MEDIUM;
      case "hard":
      case "h":
        return Difficulty.HARD;
      default:
        return Difficulty.EASY;
    }
  }

  @Override
  public void calcPointsSoftDrop() {
    pModel.calcPointsSoftDrop();
  }

  @Override
  public void updateLevel() {
    int i = pModel.getLevel();
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
          if (!pModel.isGameOver()) {
            pModel.moveDown();
          }
        }
      }, 0, this.period);
    }
  }

  @Override 
  public void updateAndSend(int num) {
    if (pModel.isGameOver()) {
      throw new IllegalStateException("Game is over.");
    } else { 
    view.updateView();
    // pick (random) opponent model to send lines to 
    TetrisModel oppModel = oppModels.get(rand.nextInt(oppModels.size()));
    // send lines to the model 
    oppModel.receiveLines(num); 
    // update the appropriate view with the number of lines to send
    view.sendLines(num);
    }
  }
}
