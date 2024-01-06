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
    TetrisController c;
    TetraFactory f = new TetraFactory(12345);
    TetrisModelImpl m = new TetrisModelImpl();
    TetrisView v = new TetrisGUI(m);
    if (args.length != 1) {
      c = new TetrisController(m, v, "medium");
    } else {
      String s = args[0];
      c = new TetrisController(m, v, s);
    }
    c.run();
  }
}