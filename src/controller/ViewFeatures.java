package controller;

public interface ViewFeatures {
  void moveLeft();
  void moveRight();
  void moveDown();
  void rotateCW();
  void rotateCCW();
  void drop();
  void hold();

  void run();

  void exitProgram();

  void calcPointsSoftDrop();

  //  void updateTimerDelay();
}
