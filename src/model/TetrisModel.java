package model;

import model.pieces.Tetra;

public class TetrisModel {
  private Board board;
  private Tetra currentPiece;
  private Tetra nextPiece;
  private int score;
  private int level;
  private int linesCleared;
  private boolean gameOver;

  public TetrisModel() {
    board = new Board(10, 20);
    currentPiece = TetraFactory.getRandomTetra();
    nextPiece = TetraFactory.getRandomTetra();
    score = 0;
    level = 1;
    linesCleared = 0;
    gameOver = false;
  }

  public TetrisModel(Board b) {
    board = b;
    currentPiece = TetraFactory.getRandomTetra();
    nextPiece = TetraFactory.getRandomTetra();
    score = 0;
    level = 1;
    linesCleared = 0;
    gameOver = false;
  }

  public void moveDown() {
    if (currentPiece.canMoveDown(board)) {
      currentPiece.moveDown();
    } else {
      board.addPiece(currentPiece);
//            int lines = board.clearLines();
//            linesCleared += lines;
//            score += lines * 100;
      if (linesCleared >= 10) {
        level++;
        linesCleared -= 10;
      }
      currentPiece = nextPiece;
      nextPiece = TetraFactory.getRandomTetra();
      if (board.isFull(currentPiece)) {
        gameOver = true;
      }
    }
  }

  public void moveLeft() {
    if (currentPiece.canMoveLeft(board)) {
      currentPiece.moveLeft();
    }
  }

  public void moveRight() {
    if (currentPiece.canMoveRight(board)) {
      currentPiece.moveRight();
    }
  }

  public void rotateCW() {
    if (currentPiece.canRotateCW(board)) {
      currentPiece.rotateCW();
    }
  }

  public void rotateCCW() {
    if (currentPiece.canRotateCCW(board)) {
      currentPiece.rotateCCW();
    }
  }

  public Board getBoard() {
    return board;
  }

  public Tetra getCurrentPiece() {
    return currentPiece;
  }

  public Tetra getNextPiece() {
    return nextPiece;
  }

  public int getScore() {
    return score;
  }

  public int getLevel() {
    return level;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public void setCurrentPiece(Tetra currentPiece) {
    this.currentPiece = currentPiece;
  }
}
