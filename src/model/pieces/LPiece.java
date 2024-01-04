package model.pieces;

import java.util.List;

public class LPiece extends Tetromino {

  public LPiece(List<Brick> bricks) {
    super(bricks);
  }

  public LPiece(Brick centerBrick) {
    super(centerBrick, TetraType.L);
  }
}
