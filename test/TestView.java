import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Text;

import model.Board;
import model.TetraFactory;
import model.TetrisModel;
import model.pieces.Brick;
import model.pieces.IPiece;
import model.pieces.JPiece;
import model.pieces.LPiece;
import model.pieces.OPiece;
import model.pieces.SPiece;
import model.pieces.TPiece;
import model.pieces.Tetra;
import model.pieces.ZPiece;
import view.TextView;

public class TestView {

  Brick b;
  Tetra iPiece, sPiece, jPiece, lPiece, zPiece, tPiece, oPiece;
  TetraFactory f;

  @Before
  public void setUp() {
    b = new Brick(4, 5);
    iPiece = new IPiece(b);
    sPiece = new SPiece(b);
    jPiece = new JPiece(b);
    lPiece = new LPiece(b);
    zPiece = new ZPiece(b);
    tPiece = new TPiece(b);
    oPiece = new OPiece(b);
    f = new TetraFactory(12345);
  }

  @Test
  public void testBoardToString() {
    Board b = new Board(10, 20);
//    iPiece.moveDown();
//    iPiece.moveDown();
//    iPiece.rotateCCW();
//    b.addPiece(iPiece);
//    sPiece.rotateCW();
//    sPiece.rotateCCW();
//    b.addPiece(sPiece);
//    jPiece.rotateCW();
//    jPiece.rotateCCW();
//    b.addPiece(jPiece);
//    lPiece.rotateCW();
//    lPiece.rotateCCW();
//    b.addPiece(lPiece);
//    zPiece.rotateCW();
//    zPiece.rotateCCW();
//    b.addPiece(zPiece);
//    tPiece.rotateCW();
//    tPiece.rotateCCW();
//    b.addPiece(tPiece);
//    oPiece.rotateCW();
//    oPiece.rotateCCW();
//    b.addPiece(oPiece);
    TextView t = new TextView(b);
    System.out.println(t.toString());
  }

  @Test
  public void testBuildingBoard() {
    Board b = new Board(10, 20);
    Tetra p1 = new IPiece(new Brick(4, 18));
    p1.rotateCCW();
    b.addPiece(p1);
    Tetra p2 = new IPiece(new Brick(4, 14));
    p2.rotateCCW();
    b.addPiece(p2);
    Tetra p3 = new IPiece(new Brick(4, 10));
    p3.rotateCCW();
    b.addPiece(p3);
    Tetra p4 = new IPiece(new Brick(4, 6));
    p4.rotateCCW();
    b.addPiece(p4);
    Tetra p5 = new IPiece(new Brick(4, 3));
    b.addPiece(p5);
  //    Tetra p6 = new JPiece(new Brick(4, 0));
  //    b.addPiece(p6);
    TextView t = new TextView(b);
    TetrisModel m = new TetrisModel(b);
    TextView t2 = new TextView(m);
    Assert.assertEquals(t.toString(), t2.toString());
  }
}
