import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Board;
import model.TetraFactory;
import model.TetrisModelImpl;
import model.pieces.Brick;
import model.pieces.IPiece;
import model.pieces.JPiece;
import model.pieces.LPiece;
import model.pieces.OPiece;
import model.pieces.SPiece;
import model.pieces.TPiece;
import model.pieces.Tetra;
import model.pieces.TetraType;
import model.pieces.ZPiece;
import view.TextView;
import view.TextualView;

public class TestBoard {

  Board b;
  TetraFactory f;
  TetrisModelImpl m;
  TextualView v;


  @Before
  public void setUp() {
    b = new Board(10, 20);
    f = new TetraFactory(12345);
    m = new TetrisModelImpl(b);
    v = new TextView(m);

  }

  @Test
  public void testClearLines() {
    Tetra p1 = new IPiece(new Brick(1, 19, TetraType.I));
    Tetra p2 = new IPiece(new Brick(5, 19, TetraType.I));
    Tetra p3 = new OPiece(new Brick(8, 19, TetraType.O));
    b.addPiece(p1);
    b.addPiece(p2);
    b.addPiece(p3);

    Assert.assertEquals(1, b.clearLines());
    System.out.println(v.toString());
  }

  @Test
  public void testMultLines() {
    Tetra p1 = new LPiece(new Brick(0, 19, TetraType.L));
    Tetra p2 = new ZPiece(new Brick(2, 18, TetraType.Z));
    Tetra p3 = new TPiece(new Brick(5, 19, TetraType.T));
    Tetra p4 = new SPiece(new Brick(4, 18, TetraType.S));
    Tetra p5 = new JPiece(new Brick(8, 19, TetraType.J));
    Tetra p6 = new OPiece(new Brick(6, 18, TetraType.O));
    Tetra p7 = new IPiece(new Brick(7, 13, TetraType.I));
    b.addPiece(p1);
    b.addPiece(p2);
    b.addPiece(p3);
    b.addPiece(p4);
    b.addPiece(p5);
    b.addPiece(p6);

    p7.rotateCW();
    p7.moveRight();
    p7.moveRight();

    int count = 0;
    while (count < 4) {
      p7.moveDown();
      count+= 1;
    }

    b.addPiece(p7);

    Assert.assertEquals(2, b.clearLines());
    System.out.println(v.toString());
  }
}
