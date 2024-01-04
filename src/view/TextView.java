package view;

import model.Board;
import model.TetrisModel;

public class TextView {
  private final Board board;

  public TextView(Board board) {
    this.board = board;
  }

  public TextView(TetrisModel model) {
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
