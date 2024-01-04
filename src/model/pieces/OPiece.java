package model.pieces;

import java.util.List;

public class OPiece extends Tetromino {
  public OPiece(List<Brick> bricks) {
    super(bricks);
  }

  public OPiece(Brick centerBrick) {
    super(centerBrick, TetraType.O);
  }
}
