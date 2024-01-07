package view;

import model.Board;
import model.TetrisModelImpl;

/**
 * Represents a text-based view of the game.
 */
public class TextView implements TextualView {
  //
  private final Board board;

  /**
   * Constructs a new TextView.
   * @param board the board to be used
   */
  public TextView(Board board) {
    this.board = board;
  }

  /**
   * Constructs a new TextView.
   * @param model the model to be used
   */
  public TextView(TetrisModelImpl model) {
    this.board = model.getBoard();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int y = 0; y < board.getHeight(); y++) {
      for (int x = 0; x < board.getWidth(); x++) {
        if (board.isOccupied(x, y)) {
          sb.append("X").append(" ");
        } else {
          sb.append("_").append(" ");
        }
      }
      sb.append("\n");
    }

    return sb.toString();
  }
}
