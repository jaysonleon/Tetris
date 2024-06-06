package model.pieces;

import java.util.ArrayList;
import java.util.List;

import model.Board;

/**
 * Represents a tetromino.
 */
public abstract class Tetromino implements Tetra {
  // List of bricks that make up the tetra
  private List<Brick> bricks;
  // 0 = 0 degrees, 1 = 90 degrees, 2 = 180 degrees, 3 = 270 degrees
  private int rotation;
  // The center brick of the tetra
  private Brick centerBrick;
  // The type of tetra
  private final TetraType type;
  // True if this tetra has been held, false otherwise
  private boolean hasBeenHeld;
  // Represents if a piece is sent from another player or from the native game 
  // private final PieceType pieceType;

  /**
   * Constructs a tetromino with the given bricks and type. Used primarily for testing.
   *
   * @param bricks the bricks that make up the tetromino
   * @param type   the type of tetromino
   */
  public Tetromino(List<Brick> bricks, TetraType type) {
    this.bricks = bricks;
    this.rotation = 0;
    this.centerBrick = bricks.get(0);
    this.type = type;
    this.hasBeenHeld = false;
  }

  /** 
   * Constructs a tetromino with the given tetra.
   * 
   * @param t the tetra to construct the tetromino from
   */
  public Tetromino(Tetra t) {
    this.bricks = List.of(t.getBricks());
    this.rotation = t.getRotation();
    this.centerBrick = t.getCenterBrick();
    this.type = t.getType();
    this.hasBeenHeld = t.hasBeenHeld();
  }

  /**
   * Constructs a tetromino with the given centerBrick and type.
   *
   * @param centerBrick the centerBrick of the tetromino
   * @param type        the type of tetromino
   */
  public Tetromino(Brick centerBrick, TetraType type) {
    this.centerBrick = centerBrick;
    this.rotation = 0;
    this.bricks = new ArrayList<>();
    this.type = type;
    this.hasBeenHeld = false;
    this.makeTetra();
  }

  /** 
   * Constructs a tetromino with the given center brick, type, and rotation.
   * 
   * @param b the center brick of the tetromino
   * @param type the type of tetromino
   * @param rot the rotation of the tetromino
   */
  public Tetromino(Brick b, TetraType type, int rot) {
    this.centerBrick = b;
    this.rotation = rot;
    this.bricks = new ArrayList<>();
    this.type = type; 
    this.makeTetra();
  }

  public Tetromino(Tetra t, PieceType type) {
    this.bricks = List.of(t.getBricks());
    this.rotation = t.getRotation();
    this.centerBrick = t.getCenterBrick();
    this.type = t.getType();
    this.hasBeenHeld = t.hasBeenHeld();
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
  public void moveUp() {
    for (Brick b : bricks) {
      b.moveUp();
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
      int newX = centerBrick.getX() - y;
      int newY = centerBrick.getY() + x;
      if (newX < 0 || newX >= board.getWidth() || newY < 0 || newY >= board.getHeight() || board.isOccupied(newX, newY)) {
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
      int newX = centerBrick.getX() + y;
      int newY = centerBrick.getY() - x;
      if (newX < 0 || newX >= board.getWidth() || newY < 0 || newY >= board.getHeight() || board.isOccupied(newX, newY)) {
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
  public int getY() { return centerBrick.getY(); }

  @Override
  public TetraType getType() { return this.type; }

  @Override
  public int getRotation() { return this.rotation; }

  @Override
  public boolean hasBeenHeld() {
    return this.hasBeenHeld;
  }

  @Override
  public void changeHoldState() {
    this.hasBeenHeld = !this.hasBeenHeld;
  }


  @Override
  public void resetPosition(Board b) {
    this.moveToTop(b);
    this.moveToMiddle(b);
  }

  /**
   * Move this tetra to the top of the given board.
   * @param b the board used to align the piece
   */
  private void moveToTop(Board b) {
    while (this.getY() > 2) {
      this.moveUp();
    }
  }

  /**
   * Move this tetra to the middle of the given board.
   * @param b the board used to align the piece
   */
  private void moveToMiddle(Board b) {
    while (this.getX() != 4) {
      if (this.getX() > 4) {
        this.moveLeft();
      } else {
        this.moveRight();
      }
    }
  }

  @Override
  public int hashCode() {
    int hash = 0;
    for (Brick brick : bricks) {
      hash += brick.hashCode();
    }
    hash += centerBrick.hashCode();
    hash += rotation * 10;

    if (this.hasBeenHeld) {
      hash += 100;
    }
    return hash;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (o == null) {
      return false;
    }
    if (o instanceof Tetromino) {
      Tetromino other = (Tetromino) o;
      return this.bricksEquals(other) && this.centerBrick.equals(other.centerBrick) && this.rotation == other.rotation;
    }
    return false;
  }

  public void changePType(Tetra t, PieceType type) {
    for (Brick b : t.getBricks()) {
      b.setPType(type);
    }
  }

  /**
   * Returns true if the bricks of this tetromino are equal to the bricks of the given tetromino.
   * @param other the tetromino to compare to
   * @return true if the bricks of this tetromino are equal to the bricks of the given tetromino
   */
  private boolean bricksEquals(Tetromino other) {
    for (Brick brick : bricks) {
      boolean found = false;
      for (Brick otherBrick : other.getBricks()) {
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

  /**
   * Makes a tetromino based on the center brick and the type of tetromino.
   */
  private void makeTetra() {
    switch (this.type) {
      case I:
        bricks.add(this.centerBrick);
        bricks.add(new Brick(this.centerBrick.getX() - 1, this.centerBrick.getY(), TetraType.I));
        bricks.add(new Brick(this.centerBrick.getX() + 1, this.centerBrick.getY(), TetraType.I));
        bricks.add(new Brick(this.centerBrick.getX() + 2, this.centerBrick.getY(), TetraType.I));
        break;
      case J:
        bricks.add(this.centerBrick);
        bricks.add(new Brick(this.centerBrick.getX() - 1, this.centerBrick.getY(), TetraType.J));
        bricks.add(new Brick(this.centerBrick.getX(), this.centerBrick.getY() - 1, TetraType.J));
        bricks.add(new Brick(this.centerBrick.getX(), this.centerBrick.getY() - 2, TetraType.J));
        break;
      case L:
        bricks.add(this.centerBrick);
        bricks.add(new Brick(this.centerBrick.getX() + 1, this.centerBrick.getY(), TetraType.L));
        bricks.add(new Brick(this.centerBrick.getX(), this.centerBrick.getY() - 1, TetraType.L));
        bricks.add(new Brick(this.centerBrick.getX(), this.centerBrick.getY() - 2, TetraType.L));
        break;
      case O:
        bricks.add(this.centerBrick);
        bricks.add(new Brick(this.centerBrick.getX() + 1, this.centerBrick.getY(), TetraType.O));
        bricks.add(new Brick(this.centerBrick.getX(), this.centerBrick.getY() - 1, TetraType.O));
        bricks.add(new Brick(this.centerBrick.getX() + 1, this.centerBrick.getY() - 1, TetraType.O));
        break;
      case S:
        bricks.add(this.centerBrick);
        bricks.add(new Brick(this.centerBrick.getX() - 1, this.centerBrick.getY(), TetraType.S));
        bricks.add(new Brick(this.centerBrick.getX(), this.centerBrick.getY() - 1, TetraType.S));
        bricks.add(new Brick(this.centerBrick.getX() + 1, this.centerBrick.getY() - 1, TetraType.S));
        break;
      case T:
        bricks.add(this.centerBrick);
        bricks.add(new Brick(this.centerBrick.getX() - 1, this.centerBrick.getY(), TetraType.T));
        bricks.add(new Brick(this.centerBrick.getX() + 1, this.centerBrick.getY(), TetraType.T));
        bricks.add(new Brick(this.centerBrick.getX(), this.centerBrick.getY() - 1, TetraType.T));
        break;
      case Z:
        bricks.add(this.centerBrick);
        bricks.add(new Brick(this.centerBrick.getX() - 1, this.centerBrick.getY(), TetraType.Z));
        bricks.add(new Brick(this.centerBrick.getX(), this.centerBrick.getY() + 1, TetraType.Z));
        bricks.add(new Brick(this.centerBrick.getX() + 1, this.centerBrick.getY() + 1, TetraType.Z));
      default:
        break;
    }
    if (this.rotation != 0) {
      for (int i = 0; i < this.rotation; i++) {
        this.rotateCW();
      }
    }
  }
}

