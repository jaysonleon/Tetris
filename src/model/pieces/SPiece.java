package model.pieces;

import java.util.List;

import model.Board;

public class SPiece implements Tetra {
  private List<Brick> bricks; // List of bricks that make up the tetra
  private int rotation; // 0 = 0 degrees, 1 = 90 degrees, 2 = 180 degrees, 3 = 270 degrees
  private Brick centerBrick; // The center brick of the tetra

  public SPiece(List<Brick> bricks) {
    this.bricks = bricks;
    this.rotation = 0;
    this.centerBrick = bricks.get(0);
  }

  public SPiece(Brick centerBrick) {
    this.centerBrick = centerBrick;
    this.rotation = 0;
    this.bricks = List.of(centerBrick, new Brick(centerBrick.getX() - 1, centerBrick.getY()),
        new Brick(centerBrick.getX(), centerBrick.getY() - 1), new Brick(centerBrick.getX() + 1, centerBrick.getY() - 1));
  }

  @Override
  public void moveDown() {
    for (Brick brick : bricks) {
      brick.moveDown();
    }
  }

  @Override
  public void moveLeft() {
    for (Brick brick : bricks) {
      brick.moveLeft();
    }
  }

  @Override
  public void moveRight() {
    for (Brick brick : bricks) {
      brick.moveRight();
    }
  }

  @Override
  public void rotateCCW() {
    for (Brick brick : bricks) {
      int x = brick.getX() - centerBrick.getX();
      int y = brick.getY() - centerBrick.getY();
      brick.setX(centerBrick.getX() + y);
      brick.setY(centerBrick.getY() - x);
    }
    rotation = (rotation + 1) % 4;
  }

  @Override
  public void rotateCW() {
    for (Brick brick : bricks) {
      int x = brick.getX() - centerBrick.getX();
      int y = brick.getY() - centerBrick.getY();
      brick.setX(centerBrick.getX() - y);
      brick.setY(centerBrick.getY() + x);
    }
    rotation = (rotation + 3) % 4;
  }

  @Override
  public boolean canMoveDown(Board board) {
    for (Brick brick : bricks) {
      if (brick.getY() == board.getHeight() - 1 || board.isOccupied(brick.getX(), brick.getY() + 1)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean canMoveLeft(Board board) {
    for (Brick brick : bricks) {
      if (brick.getX() == 0 || board.isOccupied(brick.getX() - 1, brick.getY())) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean canMoveRight(Board board) {
    for (Brick brick : bricks) {
      if (brick.getX() == board.getWidth() - 1 || board.isOccupied(brick.getX() + 1, brick.getY())) {
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
