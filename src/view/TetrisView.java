package view;

import controller.ViewFeatures;

public interface TetrisView {
  void addFeatures(ViewFeatures features);
  void updateView();

  void showMessage(String message);
}
