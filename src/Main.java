import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

import controller.TetrisController;
import model.TetraFactory;
import model.TetrisModelImpl;
import model.TetrisModel; 
import view.TetrisGUI;
import view.TetrisView;

public class Main {
  public static void main(String[] args) {
    Random rand = new Random();
    TetraFactory f = new TetraFactory(rand.nextInt());
    TetrisController c1;
    TetrisController c2; 
    TetrisModel m1 = new TetrisModelImpl();
    TetrisModel m2 = new TetrisModelImpl();
    TetrisView v1 = new TetrisGUI(m1);
    TetrisView v2 = new TetrisGUI(m2);
    ArrayList<TetrisModel> oppsP1 = new ArrayList<>();
    oppsP1.add(m2);
    ArrayList<TetrisModel> oppsP2 = new ArrayList<>();
    oppsP2.add(m1);
    if (args.length != 1) {
      c1 = new TetrisController(m1, v1, "easy", oppsP1);
      c2 = new TetrisController(m2, v2, "easy", oppsP2);
    } else {
      String s = args[0];
      c1 = new TetrisController(m1, v1, s, oppsP1);
      c2 = new TetrisController(m2, v2, s, oppsP2);
    }
    c1.run();
    c2.run(); 
  }
}