package model.pieces;

import java.util.List;

/**
 * Represents the T-shaped tetromino.
 * the centerBrick of this piece is:
 *   3
 * 0 1 2 -> 1 is the centerBrick
 * -----------------------
 * After a clockwise rotation:
 * 0
 * 1 3 -> 1 is the centerBrick
 * 2
 * -----------------------
 * After a counter-clockwise rotation:
 *   0
 * 3 1 -> 1 is the centerBrick
 *   2
 */
public class TPiece extends Tetromino {

  /**
   * Constructs a T-piece, with the given bricks. Used primarily for testing.
   * @param bricks the bricks that make up the tetromino.
   */
  public TPiece(List<Brick> bricks) { super(bricks, TetraType.T); }

  /**
   * Constructs a T-piece, with the given center brick.
   * @param centerBrick the center brick of the tetromino
   */
  public TPiece(Brick centerBrick) {
    super(centerBrick, TetraType.T);
  }

//  public TPiece(Brick centerBrick, int rot) {
//    super(centerBrick, TetraType.I,  rot);
//  }
}
