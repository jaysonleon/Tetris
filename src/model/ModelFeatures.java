package model;

/**
 * Represents the features that the model can call on the view.
 */
public interface ModelFeatures {
  /**
   * Update the view to reflect the current state of the game.
   */
  void updateView();

  /**
   * Updates the timer delay, according to the current level.
   */
  void updateLevel();
}
