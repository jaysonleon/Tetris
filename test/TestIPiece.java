import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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

public class TestIPiece {

  Brick b;
  Tetra iPiece, sPiece, jPiece, lPiece, zPiece, tPiece, oPiece;
  TetrisModelImpl m;
  TetraFactory f;

  @Before
  public void setUp() {
    b = new Brick(4, 5, TetraType.I);
    iPiece = new IPiece(b);
    sPiece = new SPiece(b);
    jPiece = new JPiece(b);
    lPiece = new LPiece(b);
    zPiece = new ZPiece(b);
    tPiece = new TPiece(b);
    oPiece = new OPiece(b);
    f = new TetraFactory(12345);
    m = new TetrisModelImpl();

  }

  // tests for getters, setters, & equality methods
  @Test
  public void testIPieceGetCenterPiece() {
    setUp();
    Assert.assertEquals(iPiece.getCenterBrick(), new Brick(4, 5, TetraType.I));
    iPiece.moveDown();
    Assert.assertEquals(iPiece.getCenterBrick(), new Brick(4, 6, TetraType.I));
    iPiece.moveLeft();
    Assert.assertEquals(iPiece.getCenterBrick(), new Brick(3, 6, TetraType.I));
    iPiece.moveRight();
    Assert.assertEquals(iPiece.getCenterBrick(), new Brick(4, 6, TetraType.I));
    iPiece.rotateCW();
    Assert.assertEquals(iPiece.getCenterBrick(), new Brick(4, 6, TetraType.I));
    iPiece.rotateCCW();
    Assert.assertEquals(iPiece.getCenterBrick(), new Brick(4, 6, TetraType.I));
  }

  @Test
  public void testIPieceGetters() {
    setUp();
    Assert.assertEquals(iPiece.getX(), 4);
    Assert.assertEquals(iPiece.getY(), 5);
  }

  @Test
  public void testIPieceEquals() {
    setUp();
    Tetra test = new IPiece(new Brick(4, 5, TetraType.I));
    Assert.assertEquals(iPiece, test);
    Assert.assertNotEquals(iPiece, null);
    Assert.assertNotEquals(iPiece, new OPiece(new Brick(4, 5, TetraType.O)));
    Assert.assertNotEquals(iPiece, new IPiece(new Brick(4, 6, TetraType.I)));
    Assert.assertEquals(iPiece, iPiece);
  }

  @Test
  public void testIPieceHashCode() {
    setUp();
    Tetra test = new IPiece(new Brick(4, 5, TetraType.I));
    Assert.assertEquals(iPiece.hashCode(), test.hashCode());
    test.rotateCCW();
    Assert.assertNotEquals(iPiece.hashCode(), test.hashCode());
  }

  @Test
  public void extraTests() {
    setUp();
    Board b = new Board(10, 20);
    Assert.assertTrue(iPiece.canMoveLeft(b));
    Assert.assertTrue(iPiece.canMoveRight(b));
  }

  @Test
  public void testIPieceMoves() {
    setUp();
    Tetra exp = new IPiece(List.of(new Brick(4, 6, TetraType.I), new Brick(3, 6, TetraType.I),
            new Brick(5, 6, TetraType.I), new Brick(6, 6, TetraType.I)));
    iPiece.moveDown();
    Assert.assertEquals(exp, iPiece);
    Assert.assertEquals(new Brick(4, 6, TetraType.I), iPiece.getCenterBrick());
    exp = new IPiece(new Brick(3, 6, TetraType.I));
    iPiece.moveLeft();
    Assert.assertEquals(exp, iPiece);
    Assert.assertEquals(new Brick(3, 6, TetraType.I), iPiece.getCenterBrick());
    exp = new IPiece(new Brick(4, 6, TetraType.I));
    iPiece.moveRight();
    Assert.assertEquals(exp, iPiece);
    Assert.assertEquals(new Brick(4, 6, TetraType.I), iPiece.getCenterBrick());
  }

  @Test
  public void testIPieceMoves2() {
    setUp();
    Board b = makeCustomBoard();
    TetrisModelImpl m = new TetrisModelImpl(b);
    TextualView t = new TextView(m);
    Tetra testPiece = new IPiece(new Brick(5, 1, TetraType.I));

    testPiece.moveDown();
    Assert.assertFalse(testPiece.canMoveDown(b));
    Assert.assertFalse(testPiece.canRotateCW(b));
    Assert.assertFalse(testPiece.canRotateCCW(b));

    b.addPiece(testPiece);
    System.out.println(t.toString());

  }

  @Test
  public void testIPieceRotCW() {
    setUp();
    Tetra exp = new IPiece(List.of(new Brick(4, 5, TetraType.I), new Brick(3, 5, TetraType.I),
            new Brick(5, 5, TetraType.I), new Brick(6, 5, TetraType.I)));
    exp.rotateCW();
    iPiece.rotateCW();
    Assert.assertEquals(exp, iPiece);

    for (Brick b : exp.getBricks()) {
      for (Brick bs : iPiece.getBricks()) {
        boolean res = false;
        if (b.getX() == bs.getX() && b.getY() == bs.getY()) {
          res = true;
          Assert.assertTrue(res);
        }
      }
    }
  }

  @Test
  public void testIPieceRotCCW() {
    setUp();
    Tetra exp2 = new IPiece(List.of(new Brick(4, 5, TetraType.I), new Brick(4, 4, TetraType.I),
            new Brick(4, 3, TetraType.I), new Brick(4, 6, TetraType.I)));
    iPiece.rotateCCW();
    iPiece.rotateCCW();

    for (Brick b : exp2.getBricks()) {
      for (Brick bs : iPiece.getBricks()) {
        boolean res = false;
        if (b.getX() == bs.getX() && b.getY() == bs.getY()) {
          res = true;
          Assert.assertTrue(res);
        }
      }
    }
  }

  @Test
  public void testIPieceCanMoveDown() {
    setUp();

    Board b = m.getBoard();
    List<Tetra> pieces = List.of(iPiece, sPiece, jPiece, lPiece, zPiece, tPiece, oPiece);
    for (Tetra t : pieces) {
      Assert.assertTrue(t.canMoveDown(b));
    }
    for (int i = 0; i < 14; i++) {
      iPiece.moveDown();
    }
    Assert.assertFalse(iPiece.canMoveDown(b));
    Assert.assertEquals(iPiece.getY(), 19);

  //    m.setCurrentPiece(iPiece);
  //    m.moveDown();
  }

  @Test
  public void testCanMoveLeft() {
    setUp();
    Board b = m.getBoard();
    Tetra testPiece = new JPiece(new Brick(1, 2, TetraType.J));
    Assert.assertFalse(testPiece.canMoveLeft(b));
    testPiece.moveRight();
    Assert.assertTrue(testPiece.canMoveLeft(b));
  }

  @Test
  public void testCanMoveRight() {
    setUp();
    Board b = m.getBoard();
    Tetra testPiece = new LPiece(new Brick(8, 2, TetraType.L));
    Assert.assertFalse(testPiece.canMoveRight(b));
    testPiece.moveLeft();
    Assert.assertTrue(testPiece.canMoveRight(b));
  }

  @Test
  public void testReachTop() {
    Board b = makeCustomBoard();
    Tetra p6 = new JPiece(new Brick(4, 2, TetraType.J));
    Assert.assertFalse(p6.canMoveDown(b));
  }

  @Test
  public void testIPieceCanRotCW() {
    setUp();
    Board b = new Board(10, 20);
    Tetra test = new IPiece(new Brick(7, 4, TetraType.I));

    Assert.assertTrue(test.canRotateCW(b));

    test.rotateCW();
    test.moveRight();
    test.moveRight();
    b.addPiece(test);

    Assert.assertFalse(test.canRotateCW(m.getBoard()));
  }

  @Test
  public void testIPieceCanRotCCW() {
    setUp();
    Board b = new Board(10, 20);
    Tetra test = new IPiece(new Brick(1, 4, TetraType.I));

    Assert.assertTrue(test.canRotateCCW(b));

    test.rotateCCW();
    b.addPiece(test);

    Assert.assertFalse(test.canRotateCCW(m.getBoard()));
  }

  @Test
  public void testConstructor() {
    Board b = makeCustomBoard();
    TetrisModelImpl model = new TetrisModelImpl(b);
    Assert.assertEquals(model.getBoard(), b);
  }

  private static Board makeCustomBoard() {
    Board b = new Board(10, 20);
    Tetra p1 = new IPiece(new Brick(4, 18, TetraType.I));
    p1.rotateCCW();
    b.addPiece(p1);
    Tetra p2 = new IPiece(new Brick(4, 14, TetraType.I));
    p2.rotateCCW();
    b.addPiece(p2);
    Tetra p3 = new IPiece(new Brick(4, 10, TetraType.I));
    p3.rotateCCW();
    b.addPiece(p3);
    Tetra p4 = new IPiece(new Brick(4, 6, TetraType.I));
    p4.rotateCCW();
    b.addPiece(p4);
    Tetra p5 = new IPiece(new Brick(4, 3, TetraType.I));
    b.addPiece(p5);
    return b;
  }
}
