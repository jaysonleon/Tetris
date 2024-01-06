package model;

import java.util.ArrayList;
import java.util.List;

import model.pieces.Tetra;

/**
 * Represents a tetris game.
 */
public class TetrisModelImpl implements TetrisModel {
  // The board
  private final Board board;
  // The current piece that is falling down, can be moved, rotated, or held once.
  private Tetra currentPiece;
  // The next piece in the queue
  private Tetra nextPiece;
  // The piece that has been held
  private Tetra holdPiece;
  // The score
  private int score;
  // The level
  private int level;
  // The number of lines cleared
  private int linesCleared;
  // True if the game is over, false otherwise
  private boolean gameOver;
  // List of listeners
  private final List<ModelFeatures> listeners;

  /**
   * Constructs a TetrisModelImpl with a default (10x20) empty board.
   */
  public TetrisModelImpl() {
    board = new Board(10, 20);
    currentPiece = TetraFactory.getRandomTetra();
    nextPiece = TetraFactory.getRandomTetra();
    holdPiece = null;
    score = 0;
    level = 1;
    linesCleared = 0;
    gameOver = false;
    listeners = new ArrayList<>();
  }

  /**
   * Convenience constructor for testing. Constructs a TetrisModelImpl with the given board.
   * @param b the board
   */
  public TetrisModelImpl(Board b) {
    board = b;
    currentPiece = TetraFactory.getRandomTetra();
    nextPiece = TetraFactory.getRandomTetra();
    holdPiece = null;
    score = 0;
    level = 1;
    linesCleared = 0;
    gameOver = false;
    listeners = new ArrayList<>();
  }

  @Override
  public void addFeatures(ModelFeatures features) {
    listeners.add(features);
  }

  @Override
  public void update() {
    for (ModelFeatures listener : listeners) {
      listener.updateView();
    }
  }

  @Override
  public void moveDown() {
    if (gameOver) {
      throw new IllegalStateException("Game is over.");
    }
    if (currentPiece.canMoveDown(board)) {
      currentPiece.moveDown();
      this.update();
    } else {
      board.addPiece(currentPiece);
      int lines = board.clearLines();
      linesCleared += lines;
      this.determineScore(lines);
      if (linesCleared >= 10) {
        level++;
        this.update();
        linesCleared -= 10;
      }
      currentPiece = nextPiece;
      nextPiece = TetraFactory.getRandomTetra();
      this.isGameOver();
      this.update();
    }
  }

  @Override
  public void moveLeft() {
    if (gameOver) {
      throw new IllegalStateException("Game is over.");
    }
    if (currentPiece.canMoveLeft(board)) {
      currentPiece.moveLeft();
    }
    this.update();
  }

  @Override
  public void moveRight() {
    if (gameOver) {
      throw new IllegalStateException("Game is over.");
    }
    if (currentPiece.canMoveRight(board)) {
      currentPiece.moveRight();
    }
    this.update();
  }

  @Override
  public void rotateCW() {
    if (gameOver) {
      throw new IllegalStateException("Game is over.");
    }
    if (currentPiece.canRotateCW(board)) {
      currentPiece.rotateCW();
    }
    this.update();
  }

  @Override
  public void rotateCCW() {
    if (gameOver) {
      throw new IllegalStateException("Game is over.");
    }
    if (currentPiece.canRotateCCW(board)) {
      currentPiece.rotateCCW();
    }
    this.update();
  }

  @Override
  public Board getBoard() {
    return board;
  }

  @Override
  public Tetra getCurrentPiece() {
    return currentPiece;
  }

  @Override
  public Tetra getNextPiece() {
    return nextPiece;
  }

  @Override
  public Tetra getHoldPiece() {
    return holdPiece;
  }

  @Override
  public int getScore() {
    return score;
  }

  @Override
  public int getLevel() {
    return level;
  }

  @Override
  public boolean isGameOver() {
    if (board.isFull()) {
      gameOver = true;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void setCurrentPiece(Tetra currentPiece) {
    this.currentPiece = currentPiece;
  }

  @Override
  public void drop() {
    if (gameOver) {
      throw new IllegalStateException("Game is over.");
    }

    while (currentPiece.canMoveDown(board)) {
      currentPiece.moveDown();
      score += 2;
    }
    this.update();
  }

  @Override
  public void hold() {
    if (gameOver) {
      throw new IllegalStateException("Game is over.");
    }
    if (this.holdPiece == null && !this.currentPiece.hasBeenHeld()) {
      this.currentPiece.moveToTop(board);
      this.currentPiece.changeHoldState();
      this.holdPiece = this.currentPiece;
      this.currentPiece = this.nextPiece;
      this.nextPiece = TetraFactory.getRandomTetra();
    } else {
      if (this.currentPiece.hasBeenHeld()) {
        return;
      } else {
        this.currentPiece.moveToTop(board);
        this.currentPiece.changeHoldState();
        Tetra temp = this.currentPiece;
        this.currentPiece = this.holdPiece;
        this.holdPiece = temp;
      }
    }
    this.update();
  }

  @Override
  public void calcPointsSoftDrop() {
    score += 1;
  }

  /**
   * Helper method to determine score based on the given number of lines cleared.
   * @param linesCleared the number of lines cleared
   */
  private void determineScore(int linesCleared) {
    switch (linesCleared) {
      case 1:
        score += 100;
      case 2:
        score += 300;
      case 3:
        score += 500;
      case 4:
        score += 800;
    }
  }

}
