package controller;

public interface ViewFeatures {
  /**
   * Moves the current piece left one cell.
   */
  void moveLeft();

  /**
   * Moves the current piece right one cell.
   */
  void moveRight();

  /**
   * Moves the current piece down one cell.
   */
  void moveDown();

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
   * Runs the game.
   */
  void run();

  /**
   * Exits the program.
   */
  void exitProgram();

  /**
   * Updates the score for a soft drop. The score for a soft drop is calculated by the number
   * of cells the piece is soft-dropped, vertically.
   */
  void calcPointsSoftDrop();

  //  void updateTimerDelay();
}
