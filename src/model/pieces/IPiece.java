package model.pieces;

import java.util.List;

/**
 * Represents the I-shaped tetromino.
 * the centerBrick of this piece is:
 * 0 1 2 3 -> 1 is the centerBrick
 * -----------------------
 * After a clockwise rotation:
 * 0
 * 1 -> 1 is the centerBrick
 * 2
 * 3
 * -----------------------
 * After a counter-clockwise rotation:
 * 3
 * 2
 * 1 -> 1 is the centerBrick
 * 0
 */
public class IPiece extends Tetromino {

  /**
   * Constructs an I-piece, with the given bricks. Used primarily for testing.
   * @param bricks the bricks that make up the tetromino.
   */
  public IPiece(List<Brick> bricks) {
    super(bricks, TetraType.I);
  }

  /**
   * Constructs an I-piece, with the given center brick.
   * @param centerBrick the center brick of the tetromino
   */
  public IPiece(Brick centerBrick) {
    super(centerBrick, TetraType.I);
  }

//  public IPiece(Brick centerBrick, int rot) {
//    super(centerBrick, TetraType.I,  rot);
//  }
}
