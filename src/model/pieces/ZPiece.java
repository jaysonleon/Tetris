package model.pieces;

import java.util.List;

public class ZPiece extends Tetromino {

  public ZPiece(List<Brick> bricks) {
    super(bricks);
  }

  public ZPiece(Brick centerBrick) {
    super(centerBrick, TetraType.Z);
  }
}
