package model;

import java.util.ArrayList;
import java.util.List;

import model.pieces.Brick;
import model.pieces.Tetra;

/**
 * Represents the game board. The board is a 2D array of bricks.
 * The board is 10 x 20. The top left corner is (0, 0), incrementing down and to the right..
 */
public class Board {
  private Brick[][] board;
  private int width, height;

  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    board = new Brick[width][height];
  }

  /**
   * adds the given piece to the board.
   *
   * @param piece the piece to add
   */
  public void addPiece(Tetra piece) {
    for (Brick brick : piece.getBricks()) {
      board[brick.getX()][brick.getY()] = brick;
    }
  }

  /**
   * Checks if the given coordinates are occupied by a brick.
   *
   * @param x the x coordinate
   * @param y the y coordinate
   * @return true if the given coordinates are occupied by a brick, false otherwise
   */
  public boolean isOccupied(int x, int y) {
    return this.getBrickAt(x, y) != null;
  }

  /**
   * Returns the height of the board.
   *
   * @return the height of the board
   */
  public int getHeight() {
    return height;
  }

  /**
   * Returns the width of the board.
   *
   * @return the width of the board
   */
  public int getWidth() {
    return width;
  }

  /**
   * Clears all full rows on the board. This method is called after a piece is placed.
   *
   * @return the number of lines cleared
   */
  public int clearLines() {
    int count = 0;
    for (int i = this.getHeight() - 1; i >= 0; i--) {
      if (isRowFull(i)) {
        count += 1;
        clearLine(i);
        moveRestDown(i);
        return count + clearLines();
      }
    }

    return count;
  }

  public Brick getBrickAt(int x, int y) {
    if (x < 0 || y < 0 || x > this.getWidth() - 1 || y > this.getHeight() - 1) {
      throw new IllegalArgumentException("Invalid coordinates.");
    }
    return board[x][y];
  }

  /**
   * Checks if the board is full. The board is full when there is a brick occupying the top row (y = 0).
   *
   * @return true if the board is full, false otherwise
   */
  public boolean isFull() {
    boolean ans = false;
    for (int i = 0; i < this.width; i++) {
      if (this.isOccupied(i, 0)) {
        ans = true;
        break;
      } else {
        ans = false;
      }
    }

    return ans;

//    for (int i = 0; i < this.width; i++) {
//      for (int j = 0; j < this.height; j++) {
//        if (this.isOccupied(i, j)) {
//          Brick b = this.getBrickAt(i, j);
//          if (b.getY() == 0) {
//            ans = true;
//            break;
//          } else {
//            ans = false;
//          }
//        }
//      }
//    }
//
//    return ans;
  }

  /**
   * Checks if the given row is full.
   *
   * @param row the row to check
   * @return true if the row is full, false otherwise
   */
  private boolean isRowFull(int row) {
    for (int i = 0; i < this.width; i++) {
      if (this.getBrickAt(i, row) == null) {
        return false;
      }
    }

    return true;
  }

  /**
   * Clears the given row.
   *
   * @param i the row to clear
   */
  private void clearLine(int i) {
    for (int j = 0; j < this.getWidth(); j++) {
      this.board[j][i] = null;
    }
  }

  /**
   * Move the rest of the board, starting from above the given row, down one row. This method is
   * called after a row is cleared.
   *
   * @param i the row to be cleared
   */
  private void moveRestDown(int i) {
    for (int j = i - 1; j >= 0; j--) {
      for (int k = 0; k < this.getWidth(); k++) {
        Brick b = this.getBrickAt(k, j);
        if (b != null) {
          b.setY(b.getY() + 1);
          this.board[k][j + 1] = b;
          this.board[k][j] = null;
        }
      }
    }
  }

  /**
   * Returns the y coordinate of the lowest possible position this tetra can move without moving left or right,
   * or rotating (i.e. the lowest possible position this tetra can move without colliding with another tetra).
   *
   * @param t the tetra to check
   * @return the y coordinate of the lowest possible position this tetra can move without moving left or right,
   */
  public int findDistToBottom(Tetra t) {
    List<Integer> xCoords = this.getXCoords(t);
    List<Integer> answers = new ArrayList<>();
    int x;
    int ans = 0;


    for (Integer i : xCoords) {
      x = i;
      for (int j = this.getHeight() - 1; j >= 0; j--) {
        if (!this.isOccupied(x, j)) {

        }
      }


      for (int j = 0; j < this.getHeight() - 1; j++) {
        if (this.isOccupied(x, j)) {
          answers.add(j);
        } else {
          ans += 1;
        }

      }


    }
    return ans;
  }


//    int dist = 0;
//    for (Brick b : t.getBricks()) {
//      int x = b.getX();
//      int y = b.getY();
//      while (y < this.getHeight() - 1 && !this.isOccupied(x, y + 1)) {
//        y += 1;
//      }
//      if (this.isOccupied(x, y)) {
//        y -= 1;
//      } else {
//        dist = y;
//      }
//    }
//
//    return dist;

  private List<Integer> getXCoords(Tetra t) {
    List<Integer> xCoords = new ArrayList<>();
    for (Brick b : t.getBricks()) {
      int x = b.getX();
      int y = b.getY();
      if (xCoords.contains(x)) {
        continue;
      } else {
        xCoords.add(x);
      }
    }

    return xCoords;
  }
}
