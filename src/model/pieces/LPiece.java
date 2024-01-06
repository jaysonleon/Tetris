package model.pieces;

import java.util.List;

/**
 * Represents an L-shaped tetromino.
 * the centerBrick of this piece is:
 * 3
 * 2
 * 1 0 -> 1 is the centerBrick
 * -----------------------
 * After a clockwise rotation:
 * 1 2 3 -> 1 is the centerBrick
 * 0
 * -----------------------
 * After a counter-clockwise rotation:
 *     0
 * 3 2 1 -> 1 is the centerBrick
 */
public class LPiece extends Tetromino {

  /**
   * Constructs an L-piece based on the given list of bricks. Used primarily for testing.
   * @param bricks the list of bricks that make up the L-piece
   */
  public LPiece(List<Brick> bricks) {
    super(bricks, TetraType.L);
  }

  /**
   * Constructs an L-piece, with the given center brick.
   * @param centerBrick the center brick of the tetromino
   */
  public LPiece(Brick centerBrick) {
    super(centerBrick, TetraType.L);
  }

//  public LPiece(Brick centerBrick, int rot) {
//    super(centerBrick, TetraType.I,  rot);
//  }
}
