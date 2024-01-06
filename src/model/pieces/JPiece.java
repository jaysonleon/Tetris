package model.pieces;

import java.util.List;

/**
 * Represents a J-shaped Tetromino in Tetris.
 * the centerBrick of this piece is:
 *   3
 *   2
 * 0 1 -> 1 is the centerBrick
 * -----------------------
 * After a clockwise rotation:
 * 0
 * 1 2 3 -> 1 is the centerBrick
 * -----------------------
 * After a counter-clockwise rotation:
 * 3 2 1 -> 1 is the centerBrick
 *     0
 */
public class JPiece extends Tetromino {

  /**
   * Constructs a J piece based on the given list of bricks. Used primarily for testing.
   * @param bricks the list of bricks that make up the piece
   */
  public JPiece(List<Brick> bricks) {
    super(bricks, TetraType.J);
  }

  /**
   * Constructs a J piece based on the given center brick.
   * @param centerBrick the center brick of the piece
   */
  public JPiece(Brick centerBrick) {
    super(centerBrick, TetraType.J);
  }

//  public JPiece(Brick centerBrick, int rot) {
//    super(centerBrick, TetraType.I,  rot);
//  }
}
