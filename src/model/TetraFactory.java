package model;

import java.util.Random;

import model.pieces.Brick;
import model.pieces.IPiece;
import model.pieces.JPiece;
import model.pieces.LPiece;
import model.pieces.OPiece;
import model.pieces.SPiece;
import model.pieces.TPiece;
import model.pieces.Tetra;
import model.pieces.ZPiece;

public class TetraFactory {

  static Random rand;

  public TetraFactory(int seed) {
    rand = new Random(seed);
  }

  public static Tetra getRandomTetra() {
    int index = rand.nextInt(6);
    switch (index) {
      case 0:
        return new OPiece(new Brick(5, 0));
      case 1:
        return new IPiece(new Brick(5, 0));
      case 2:
        return new JPiece(new Brick(5, 0));
      case 3:
        return new LPiece(new Brick(5, 0));
      case 4:
        return new SPiece(new Brick(5, 0));
      case 5:
        return new TPiece(new Brick(5, 0));
      case 6:
        return new ZPiece(new Brick(5, 0));
      default:
        return null;
    }
  }

}
