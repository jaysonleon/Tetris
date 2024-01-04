package model.pieces;

import java.util.List;

public class JPiece extends Tetromino {

  public JPiece(List<Brick> bricks) {
    super(bricks);
  }

  public JPiece(Brick centerBrick) {
    super(centerBrick, TetraType.J);
  }
}
