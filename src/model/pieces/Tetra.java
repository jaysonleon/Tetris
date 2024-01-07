package model.pieces;

import model.Board;

public interface Tetra {
  /**
   * Move this tetra down 1 cell. If it cannot move down, do nothing.
   * @throws IllegalStateException if the game is over
   */
  public void moveDown();

  /**
   * Move this tetra left 1 cell. If it cannot move left, do nothing.
   * @throws IllegalStateException if the game is over
   */
  public void moveLeft();

  /**
   * Move this tetra right 1 cell. If it cannot move right, do nothing.
   * @throws IllegalStateException if the game is over
   */
  public void moveRight();


  public void moveUp();
  /**
   * Rotate this tetra clockwise 90 degrees. If it cannot rotate, do nothing.
   * @throws IllegalStateException if the game is over
   */
  public void rotateCW();

  /**
   * Rotate this tetra counter-clockwise 90 degrees. If it cannot rotate, do nothing.
   * @throws IllegalStateException if the game is over
   */
  public void rotateCCW();

  /**
   * Can this tetra move down 1 cell on the given board? A tetra can move down if it is not touching the bottom of the board,
   * or if any part of this tetra is touching any brick currently on the board.
   * @param board the board to check
   * @return true if this tetra can move down, false otherwise
   */
  public boolean canMoveDown(Board board);

  /**
   * Can this tetra move left 1 cell on the given board? A tetra can move left if it is not touching the left side of the board,
   * or if any part of this tetra is touching any brick currently on the board.
   * @param board the board to check
   * @return true if this tetra can move left, false otherwise
   */
  public boolean canMoveLeft(Board board);

  /**
   * Can this tetra move right 1 cell on the given board? A tetra can move right if it is not touching the right side of the board,
   * or if any part of this tetra is touching any brick currently on the board.
   * @param board the board to check
   * @return true if this tetra can move right, false otherwise
   */
  public boolean canMoveRight(Board board);

  /**
   * Can this tetra rotate clockwise 90 degrees on the given board? A tetra can rotate if rotating
   * the piece does not result in the piece ending outside the bounds of the given board.
   * @param board the board to check
   * @return true if this tetra can rotate, false otherwise
   */
  public boolean canRotateCW(Board board);

  /**
   * Can this tetra rotate counter-clockwise 90 degrees on the given board? A tetra can rotate if rotating
   * the piece does not result in the piece ending outside the bounds of the given board.
   * @param board the board to check
   * @return true if this tetra can rotate, false otherwise
   */
  public boolean canRotateCCW(Board board);

  /**
   * Returns the bricks that make up this tetra.
   * @return the bricks that make up this tetra
   */
  public Brick[] getBricks();

  /**
   * Returns the brick that is the center of this tetra.
   * @return the brick that is the center of this tetra
   */
  public Brick getCenterBrick();

  /**
   * Returns the x coordinate of this tetra's center brick.
   * @return the x coordinate of this tetra's center brick
   */
  public int getX();

  /**
   * Returns the y coordinate of this tetra's center brick.
   * @return the y coordinate of this tetra's center brick
   */
  public int getY();

  /**
   * Returns the type of this tetra.
   * @return the type of this tetra
   */
  public TetraType getType();

  /**
   * Returns the rotation of this tetra.
   * @return the rotation of this tetra
   */
  public int getRotation();

  /**
   * Returns true if this tetra has been held, false otherwise.
   * @return true if this tetra has been held, false otherwise
   */
  public boolean hasBeenHeld();

  /**
   * Returns true if this tetra is currently being held, false otherwise.
   */
  public void changeHoldState();


//  public void moveToTop(Board b);
//
//  public void moveToMiddle(Board b);

  /**
   * Resets the position of this tetra to the top and middle of the board.
   * @param b the board used to reset the position of the piece
   */
  public void resetPosition(Board b);

}
