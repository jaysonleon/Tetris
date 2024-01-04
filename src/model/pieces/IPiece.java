package model.pieces;

import java.util.List;

public class IPiece extends Tetromino {

  public IPiece(List<Brick> bricks) {
    super(bricks);
  }

  public IPiece(Brick centerBrick) {
    super(centerBrick, TetraType.I);
  }
}
