import java.util.Random;

import controller.TetrisController;
import model.TetraFactory;
import model.TetrisModelImpl;
import view.TetrisGUI;
import view.TetrisView;

public class Main {
  public static void main(String[] args) {
  //    Random rand = new Random();
  //    TetraFactory f = new TetraFactory(rand.nextInt());
    TetraFactory f = new TetraFactory(12345);
    TetrisModelImpl m = new TetrisModelImpl();
    TetrisView v = new TetrisGUI(m);
    TetrisController c = new TetrisController(m, v, "medium");
    c.run();
  }
}