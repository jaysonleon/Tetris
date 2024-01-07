package model;

import model.pieces.Tetra;

public interface TetrisModel {
  /**
   * Adds the given features to the model.
   * @param features the features to add
   */
  void addFeatures(ModelFeatures features);

  /**
   * Updates the listeners of the model to the current state of the model.
   */
  void update();

  void updateLevel();

  /**
   * Moves the current piece down one row.
   */
  void moveDown();

  /**
   * Moves the current piece left one column.
   */
  void moveLeft();

  /**
   * Moves the current piece right one column.
   */
  void moveRight();

  /**
   * Rotates the current piece clockwise.
   */
  void rotateCW();

  /**
   * Rotates the current piece counter-clockwise.
   */
  void rotateCCW();

  /**
   * Drops the current piece to the bottom-most position on the board.
   */
  void drop();

  /**
   * Holds the current piece. A piece can only be held once.
   */
  void hold();

  /**
   * Returns the current game board.
   * @return the current game board
   */
  Board getBoard();

  /**
   * Returns the current piece.
   * @return the current piece
   */
  Tetra getCurrentPiece();

  /**
   * Returns the next piece.
   * @return the next piece
   */
  Tetra getNextPiece();

  /**
   * Returns the held piece
   * @return the held piece, or {@code null} if no piece is held
   */
   Tetra getHoldPiece();

  /**
   * Returns the score.
   * @return the score
   */
  int getScore();

  /**
   * Returns the current level.
   * @return the current level
   */
  int getLevel();

  /**
   * Returns the number of lines cleared.
   * @return the number of lines cleared
   */
  int getLinesCleared();

  /**
   * Returns whether the game is over. The game is over when a brick on the board
   * reaches the top of the board.
   * @return whether the game is over
   */
  boolean isGameOver();

  /**
   * Set the currentPiece of this model to the given piece.
   * @param currentPiece the piece to set the currentPiece to
   */
  void setCurrentPiece(Tetra currentPiece);

  /**
   * Calculate the number of points for a soft drop from the currentPiece's
   * current position. The number of points is equal to the number of bricks the
   * piece drops by.
   */
  void calcPointsSoftDrop();
}
