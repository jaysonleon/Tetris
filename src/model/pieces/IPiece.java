package model.pieces;

import java.util.ArrayList;
import java.util.List;

import model.Board;

public class IPiece implements Tetra {
  private List<Brick> bricks; // List of bricks that make up the tetra
  private int rotation; // 0 = 0 degrees, 1 = 90 degrees, 2 = 180 degrees, 3 = 270 degrees
  private Brick centerBrick; // The center brick of the tetra

  public IPiece(List<Brick> bricks) {
    this.bricks = bricks;
    this.rotation = 0;
    this.centerBrick = bricks.get(0);
  }

  public IPiece(Brick centerBrick) {
    this.centerBrick = centerBrick;
    this.rotation = 0;
    this.bricks = new ArrayList<>();
    bricks.add(centerBrick);
    bricks.add(new Brick(centerBrick.getX() - 1, centerBrick.getY()));
    bricks.add(new Brick(centerBrick.getX() + 1, centerBrick.getY()));
    bricks.add(new Brick(centerBrick.getX() + 2, centerBrick.getY()));
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

  public Brick[] getBricks() {
    Brick[] brickArray = new Brick[bricks.size()];
    for (int i = 0; i < bricks.size(); i++) {
      brickArray[i] = bricks.get(i);
    }
    return brickArray;
  }

  @Override
  public Brick getCenterBrick() {
    return centerBrick;
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
    for (Brick brick : bricks) {
      int x = brick.getX() - centerBrick.getX();
      int y = brick.getY() - centerBrick.getY();
      int newX = centerBrick.getX() + y;
      int newY = centerBrick.getY() - x;
      if (newX < 0 || newX >= board.getWidth() || newY < 0 || newY >= board.getHeight() || board.isOccupied(newX, newY) || y < 0) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean canRotateCCW(Board board) {
    for (Brick brick : bricks) {
      int x = brick.getX() - centerBrick.getX();
      int y = brick.getY() - centerBrick.getY();
      int newX = centerBrick.getX() - y;
      int newY = centerBrick.getY() + x;
      if (newX < 0 || newX >= board.getWidth() || newY < 0 || newY >= board.getHeight() || board.isOccupied(newX, newY) || y < 0) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int getX() {
    return centerBrick.getX();
  }

  @Override
  public int getY() {
    return centerBrick.getY();
  }

  private boolean bricksEquals(IPiece other) {
    for (Brick brick : bricks) {
      boolean found = false;
      for (Brick otherBrick : other.bricks) {
        if (brick.equals(otherBrick)) {
          found = true;
          break;
        }
      }
      if (!found) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (o == null) {
      return false;
    }
    if (o instanceof IPiece) {
      IPiece other = (IPiece) o;
      return this.bricksEquals(other) && this.centerBrick.equals(other.centerBrick) && this.rotation == other.rotation;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    for (Brick brick : bricks) {
      hash += brick.hashCode();
    }
    hash += centerBrick.hashCode();
    hash += rotation * 10;
    return hash;
  }
}
