package model.pieces;

import java.util.List;

import model.Board;

public class TPiece implements Tetra {

  private List<Brick> bricks; // List of bricks that make up the tetra
  private int rotation; // 0 = 0 degrees, 1 = 90 degrees, 2 = 180 degrees, 3 = 270 degrees
  private Brick centerBrick;

  public TPiece(List<Brick> bricks) {
    this.bricks = bricks;
    this.rotation = 0;
    this.centerBrick = bricks.get(0);
  }

  public TPiece(Brick centerBrick) {
    this.centerBrick = centerBrick;
    this.rotation = 0;
    this.bricks = List.of(centerBrick, new Brick(centerBrick.getX() - 1, centerBrick.getY()),
        new Brick(centerBrick.getX(), centerBrick.getY() - 1), new Brick(centerBrick.getX() + 1, centerBrick.getY()));
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
  public void rotateCW() {
    for (Brick brick : bricks) {
      int x = brick.getX() - centerBrick.getX();
      int y = brick.getY() - centerBrick.getY();
      brick.setX(centerBrick.getX() - y);
      brick.setY(centerBrick.getY() + x);
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
  }

  @Override
  public boolean canMoveDown(Board board) {
    if (bricks.get(0).getY() == board.getHeight() || board.isOccupied(bricks.get(0).getX(), bricks.get(0).getY() + 1)) {
      return false;
    }
    return true;
  }

  @Override
  public boolean canMoveLeft(Board board) {
    if (bricks.get(0).getX() == 0 || board.isOccupied(bricks.get(0).getX() - 1, bricks.get(0).getY())) {
      return false;
    }
    return true;
  }

  @Override
  public boolean canMoveRight(Board board) {
    if (bricks.get(0).getX() == board.getWidth() - 1 || board.isOccupied(bricks.get(0).getX() + 1, bricks.get(0).getY())) {
      return false;
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
