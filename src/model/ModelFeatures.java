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

  /**
   * Updates pieces sent from one player to another player.
   * 
   * @param num the number of lines to send 
   */
  void updateAndSend(int num); 
}
