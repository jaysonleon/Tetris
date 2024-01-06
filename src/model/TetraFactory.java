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
import model.pieces.TetraType;
import model.pieces.ZPiece;

/**
 * Represents a factory for tetras. Used to generate random tetras.
 */
public class TetraFactory {
  // The seed for randomization, used for testing for pseudo-randomness.
  private static Random rand;

  /**
   * Constructs a tetra factory with the given seed.
   * @param seed the seed for randomization
   */
  public TetraFactory(int seed) {
    rand = new Random(seed);
  }

  /**
   * Returns a random tetra at the top and middle of the board.
   * @return a random tetra at the top and middle of the board
   */
  public static Tetra getRandomTetra() {
    int index = rand.nextInt(7);
    switch (index) {
      case 0:
        return new OPiece(new Brick(4, 1, TetraType.O));
      case 1:
        return new IPiece(new Brick(4, 0, TetraType.I));
      case 2:
        return new JPiece(new Brick(4, 2, TetraType.J));
      case 3:
        return new LPiece(new Brick(4, 2, TetraType.L));
      case 4:
        return new SPiece(new Brick(4, 1, TetraType.S));
      case 5:
        return new TPiece(new Brick(4, 0, TetraType.T));
      case 6:
        return new ZPiece(new Brick(4, 0, TetraType.Z));
      default:
        return null;
    }
  }

}
