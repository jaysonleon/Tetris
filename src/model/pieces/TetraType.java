package model.pieces;

import java.awt.*;

/**
 * Represents the different types of tetrominoes.
 */
public enum TetraType {
  I(Color.CYAN), J(Color.BLUE), L(Color.ORANGE), O(Color.YELLOW), S(Color.GREEN), T(new Color(120, 7, 203)), Z(Color.RED);

  private final Color color;

  /**
   * Constructs a new TetraType.
   * @param c the color of the tetra
   */
  TetraType(Color c) {
    this.color = c;
  }

  /**
   * Gets the color of the tetra.
   * @return the color of the tetra
   */
  public Color getColor() {
    return this.color;
  }
}
