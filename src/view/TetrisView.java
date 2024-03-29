package view;

import controller.ViewFeatures;

/**
 * Represents the view for the Tetris game.
 */
public interface TetrisView {
  /**
   * Adds the given features to the view.
   * @param features the features to be added
   */
  void addFeatures(ViewFeatures features);

  /**
   * Updates the view.
   */
  void updateView();

  /**
   * Shows the given message.
   * @param message the message to be shown
   */
  void showMessage(String message);
}
