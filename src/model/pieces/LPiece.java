package model.pieces;

import java.util.List;

import model.Board;

public class LPiece implements Tetra {
  private List<Brick> bricks; // List of bricks that make up the tetra
  private int rotation; // 0 = 0 degrees, 1 = 90 degrees, 2 = 180 degrees, 3 = 270 degrees
  private Brick centerBrick;

  public LPiece(List<Brick> bricks) {
    this.bricks = bricks;
    this.rotation = 0;
    this.centerBrick = bricks.get(0);
  }

  public LPiece(Brick centerBrick) {
    this.centerBrick = centerBrick;
    this.rotation = 0;
    this.bricks = List.of(centerBrick, new Brick(centerBrick.getX() + 1, centerBrick.getY()),
        new Brick(centerBrick.getX(), centerBrick.getY() - 1), new Brick(centerBrick.getX(), centerBrick.getY() - 2));
  }

  @Override
  public void moveDown() {
    for (Brick b : bricks) {
      b.moveDown();
    }
  }

  @Override
  public void moveLeft() {
    for (Brick b : bricks) {
      b.moveLeft();
    }
  }

  @Override
  public void moveRight() {
    for (Brick b : bricks) {
      b.moveRight();
    }
  }

  @Override
  public void rotateCW() {
    for (Brick b : bricks) {
      int x = b.getX() - centerBrick.getX();
      int y = b.getY() - centerBrick.getY();
      b.setX(centerBrick.getX() - y);
      b.setY(centerBrick.getY() + x);
    }
  }

  @Override
  public void rotateCCW() {
    for (Brick b : bricks) {
      int x = b.getX() - centerBrick.getX();
      int y = b.getY() - centerBrick.getY();
      b.setX(centerBrick.getX() + y);
      b.setY(centerBrick.getY() - x);
    }
  }

  @Override
  public boolean canMoveDown(Board board) {
    for (Brick b : bricks) {
      if (b.getY() == board.getHeight() || board.isOccupied(b.getX(), b.getY() + 1)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean canMoveLeft(Board board) {
    for (Brick b : bricks) {
      if (b.getX() == 0 || board.isOccupied(b.getX() - 1, b.getY())) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean canMoveRight(Board board) {
    for (Brick b : bricks) {
      if (b.getX() == board.getWidth() - 1 || board.isOccupied(b.getX() + 1, b.getY())) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean canRotateCW(Board board) {
    return false;
  }

  @Override
  public boolean canRotateCCW(Board board) {
    return false;
  }

  @Override
  public Brick[] getBricks() {
    Brick[] brickArray = new Brick[bricks.size()];
    for (int i = 0; i < bricks.size(); i++) {
      brickArray[i] = bricks.get(i);
    }
    return brickArray;
  }

  @Override
  public int getX() {
    return centerBrick.getX();
  }

  @Override
  public int getY() {
    return centerBrick.getY();
  }

  @Override
  public Brick getCenterBrick() {
    return centerBrick;
  }
}
