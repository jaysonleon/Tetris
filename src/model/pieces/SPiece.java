package model.pieces;

import java.util.List;

public class SPiece extends Tetromino {
  public SPiece(List<Brick> bricks) {
    super(bricks);
  }

  public SPiece(Brick centerBrick) {
    super(centerBrick, TetraType.S);
  }
}
