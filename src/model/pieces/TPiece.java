package model.pieces;

import java.util.List;

public class TPiece extends Tetromino {

  public TPiece(List<Brick> bricks) {
    super(bricks);
  }

  public TPiece(Brick centerBrick) {
    super(centerBrick, TetraType.T);
  }
}
