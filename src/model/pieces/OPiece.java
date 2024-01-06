package model.pieces;

import java.util.List;

/**
 * Represents the O-shaped tetromino.
 * the centerBrick of this piece is:
 * 2 3
 * 0 1 -> 0 is the centerBrick
 * -----------------------
 * After a clockwise rotation:
 * 0 2 -> 0 is the centerBrick
 * 1 3
 * -----------------------
 * After a counter-clockwise rotation:
 * 3 1
 * 2 0 -> 0 is the centerBrick
 *
 */
public class OPiece extends Tetromino {
  /**
   * Constructs an O-piece, with the given bricks. Used primarily for testing.
   * @param bricks the bricks that make up the tetromino.
   */
  public OPiece(List<Brick> bricks) {
    super(bricks, TetraType.O);
  }

  /**
   * Constructs an O-piece, with the given center brick.
   * @param centerBrick the center brick of the tetromino
   */
  public OPiece(Brick centerBrick) {
    super(centerBrick, TetraType.O);
  }

//  public OPiece(Brick centerBrick, int rot) {
//    super(centerBrick, TetraType.I,  rot);
//  }
}
