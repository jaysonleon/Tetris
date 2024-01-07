package controller;

/**
 * Represents the difficulty of the game.
 */
public enum Difficulty {
  EASY(1000), MEDIUM(500), HARD(250);

  private final int delay;

  /**
   * Constructs a Difficulty with the given delay.
   * @param delay the delay
   */
  Difficulty(int delay) {
    this.delay = delay;
  }

  public int getDelay() {
    return delay;
  }
}
