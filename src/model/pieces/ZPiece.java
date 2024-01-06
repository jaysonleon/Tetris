package model.pieces;

import java.util.List;

/**
 * Represents the Z-shaped tetromino.
 * the centerBrick of this piece is:
 * 0 1
 *   2 3 -> 2 is the centerBrick
 * -----------------------
 * After a clockwise rotation:
 *   0
 * 2 1 -> 2 is the centerBrick
 * 3
 * -----------------------
 * After a counter-clockwise rotation:
 *   0
 * 2 1 -> 1 is the centerBrick
 * 3
 */
public class ZPiece extends Tetromino {

  /**
   * Constructs a Z-piece, with the given bricks. Used primarily for testing.
   * @param bricks the bricks that make up the tetromino.
   */
  public ZPiece(List<Brick> bricks) {
    super(bricks, TetraType.Z);
  }

  /**
   * Constructs a Z-piece, with the given center brick.
   * @param centerBrick the center brick of the tetromino
   */
  public ZPiece(Brick centerBrick) {
    super(centerBrick, TetraType.Z);
  }

//  public ZPiece(Brick centerBrick, int rot) {
//    super(centerBrick, TetraType.I,  rot);
//  }
}
