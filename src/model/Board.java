package model;

import model.pieces.Brick;
import model.pieces.IPiece;
import model.pieces.Tetra;

public class Board {
  private Brick[][] board;
  private int width, height;

  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    board = new Brick[width][height];
  }

  public void addPiece(Tetra piece) {
    for (Brick brick : piece.getBricks()) {
      board[brick.getX()][brick.getY()] = brick;
    }
  }

  public void removePiece(IPiece piece) {
    for (Brick brick : piece.getBricks()) {
      board[brick.getX()][brick.getY()] = null;
    }
  }

  public boolean isOccupied(int x, int y) {
    return this.getBrickAt(x, y) != null;
  }

  public boolean isOccupied(Brick brick) {
    return isOccupied(brick.getX(), brick.getY());
  }

  public boolean isOccupied(IPiece piece) {
    for (Brick brick : piece.getBricks()) {
      if (isOccupied(brick)) {
        return true;
      }
    }
    return false;
  }

  public boolean isOccupied(int[][] bricks) {
    for (int[] brick : bricks) {
      if (isOccupied(brick[0], brick[1])) {
        return true;
      }
    }
    return false;
  }

  public boolean isOccupied(Brick[] bricks) {
    for (Brick brick : bricks) {
      if (isOccupied(brick)) {
        return true;
      }
    }
    return false;
  }

  public boolean isOccupied(IPiece[] pieces) {
    for (IPiece piece : pieces) {
      if (isOccupied(piece)) {
        return true;
      }
    }
    return false;
  }

  public boolean isOccupied(int x, int y, int[][] bricks) {
    for (int[] brick : bricks) {
      if (isOccupied(x + brick[0], y + brick[1])) {
        return true;
      }
    }
    return false;
  }

  public boolean isOccupied(int x, int y, Brick[] bricks) {
    for (Brick brick : bricks) {
      if (isOccupied(x + brick.getX(), y + brick.getY())) {
        return true;
      }
    }
    return false;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public int clearLines() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public Brick getBrickAt(int x, int y) {
    return board[x][y];
  }

  public boolean isFull(Tetra piece) {
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        Brick b = this.getBrickAt(i, j);
        if (b == null) {
          return false;
        }
        if (b.getY() == 0) {
          return true;
        } else {
          return false;
        }
      }
    }

    return false;
  }


}
