package model.pieces;

public class Brick {
  private int x, y;

  public Brick(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void moveDown() {
    y++;
  }

  public void moveLeft() {
    x--;
  }

  public void moveRight() {
    x++;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void rotateCW() {
    int temp = x;
    x = y;
    y = -temp;
  }

  public void rotateCCW() {
    int temp = x;
    x = -y;
    y = temp;
  }

  public void setX(int x) {
    this.x = x;
  }

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
      return x == b.x && y == b.y;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return x * 100 + y * 100;
  }


}
