package model.pieces;

import java.util.List;

/**
 * Represents a J piece in Tetris.
 * the centerBrick of this piece is:
 *   2 3
 * 0 1   -> 1 is the centerBrick
 * -----------------------
 * After a clockwise rotation:
 * 0
 * 1 2 -> 1 is the centerBrick
 *   3
 * -----------------------
 * After a counter-clockwise rotation:
 * 3
 * 2 1 -> 1 is the centerBrick
 *   0
 */
public class SPiece extends Tetromino {
  /**
   * Constructs an S piece, with the given bricks. Used primarily for testing.
   * @param bricks the bricks that make up the tetromino.
   */
  public SPiece(List<Brick> bricks) {
    super(bricks, TetraType.S);
  }

  /**
   * Constructs an S piece, with the given center brick.
   * @param centerBrick the center brick of the tetromino
   */
  public SPiece(Brick centerBrick) {
    super(centerBrick, TetraType.S);
  }

//  public SPiece(Brick centerBrick, int rot) {
//    super(centerBrick, TetraType.I,  rot);
//  }
}
