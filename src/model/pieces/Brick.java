package model.pieces;

import model.pieces.TetraType;

/**
 * Represents a brick in the tetris game. A tetra is made up of 4 bricks.
 * A brick has a position and a type.
 */
public class Brick {
  // position of the brick
  private int x, y;
  // type of tetra the brick belongs to
  private final TetraType type;
  // Player .... 
  private PieceType pType; 

  /**
   * Constructs a brick with the given position and type.
   * @param x the x position
   * @param y the y position
   * @param type the type of tetra the brick belongs to
   */
  public Brick(int x, int y, TetraType type) {
    this.x = x;
    this.y = y;
    this.type = type;
    this.pType = PieceType.PLAYER;
  }

  /**
   * Move this brick down 1 cell.
   */
  public void moveDown() {
    y++;
  }

  /**
   * Move this brick left 1 cell.
   */
  public void moveLeft() {
    x--;
  }

  /**
   * Move this brick right 1 cell.
   */
  public void moveRight() {
    x++;
  }

  /**
   * Move this brick up 1 cell.
   */
  public void moveUp() { y--; }

  /**
   * Returns the x position of this brick.
   * @return the x position of this brick
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the y position of this brick.
   * @return the y position of this brick
   */
  public int getY() {
    return y;
  }

  /**
   * Returns the type of tetra this brick belongs to.
   * @return the type of tetra this brick belongs to
   */
  public TetraType getType() {
    return type;
  }

  public void setPType(PieceType type) {
    this.pType = type;
  }

  /**
   * Rotates this brick clockwise.
   */
  public void rotateCW() {
    int temp = x;
    x = y;
    y = -temp;
  }

  /**
   * Rotates this brick counter-clockwise.
   */
  public void rotateCCW() {
    int temp = x;
    x = -y;
    y = temp;
  }

  /**
   * Sets the x position of this brick.
   * @param x the new x position of this brick
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Sets the y position of this brick.
   * @param y the new y position of this brick
   */
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (o == null) {
      return false;
    }
    if (o instanceof Brick) {
      Brick b = (Brick) o;
      return x == b.x && y == b.y && type == b.type;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return x * 100 + y * 100 + type.hashCode();
  }


}
