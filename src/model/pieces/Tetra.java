package model.pieces;

import model.Board;

public interface Tetra {
  public void moveDown();
  public void moveLeft();
  public void moveRight();
  public void rotateCW();
  public void rotateCCW();
  public boolean canMoveDown(Board board);
  public boolean canMoveLeft(Board board);
  public boolean canMoveRight(Board board);
  public boolean canRotateCW(Board board);
  public boolean canRotateCCW(Board board);
  public Brick[] getBricks();
  public Brick getCenterBrick();
  public int getX();
  public int getY();

}
