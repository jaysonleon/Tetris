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
import model.pieces.OPiece;
import model.pieces.Tetra;
import model.pieces.TetraType;

public class TestJPiece {
  Brick b;
  Tetra jPiece;
  TetrisModelImpl m;
  TetraFactory f;

  @Before
  public void setUp() {
    b = new Brick(4, 5, TetraType.J);
    jPiece = new JPiece(b);
    f = new TetraFactory(12345);
    m = new TetrisModelImpl();
  }

  // test getters, setters, & equality methods
  @Test
  public void testJPieceGetters() {
    setUp();
    Assert.assertEquals(jPiece.getX(), 4);
    Assert.assertEquals(jPiece.getY(), 5);
  }

  @Test
  public void testJPieceGetCenterPiece() {
    setUp();
    Assert.assertEquals(jPiece.getCenterBrick(), new Brick(4, 5, TetraType.J));
    jPiece.moveDown();
    Assert.assertEquals(jPiece.getCenterBrick(), new Brick(4, 6, TetraType.J));
    jPiece.moveLeft();
    Assert.assertEquals(jPiece.getCenterBrick(), new Brick(3, 6, TetraType.J));
    jPiece.moveRight();
    Assert.assertEquals(jPiece.getCenterBrick(), new Brick(4, 6, TetraType.J));
    jPiece.rotateCW();
    Assert.assertEquals(jPiece.getCenterBrick(), new Brick(4, 6, TetraType.J));
    jPiece.rotateCCW();
    Assert.assertEquals(jPiece.getCenterBrick(), new Brick(4, 6, TetraType.J));
  }

  @Test
  public void testJPieceEquals() {
    setUp();
    Tetra test = new JPiece(new Brick(4, 5, TetraType.J));
    Assert.assertEquals(jPiece, test);
    Assert.assertNotEquals(jPiece, null);
    Assert.assertNotEquals(test, new Brick(4, 5, TetraType.J));
    Assert.assertNotEquals(jPiece, new OPiece(new Brick(4, 5, TetraType.J)));
    Assert.assertNotEquals(jPiece, new JPiece(new Brick(4, 6, TetraType.J)));
    Assert.assertEquals(jPiece, jPiece);
  }

  @Test
  public void testJPieceHashCode() {
    setUp();
    Tetra test = new JPiece(new Brick(4, 5, TetraType.J));
    Assert.assertEquals(jPiece.hashCode(), test.hashCode());
    Assert.assertNotEquals(jPiece.hashCode(), new OPiece(new Brick(4, 5, TetraType.J)).hashCode());
    Assert.assertNotEquals(jPiece.hashCode(), new JPiece(new Brick(4, 6, TetraType.J)).hashCode());
    Assert.assertEquals(jPiece.hashCode(), jPiece.hashCode());
  }

  @Test
  public void testJPieceIsMadeCorrectly() {
    setUp();
    Tetra exp = new JPiece(List.of(new Brick(4, 5, TetraType.J), new Brick(4, 4, TetraType.J),
            new Brick(4, 3, TetraType.J), new Brick(3, 5, TetraType.J)));
    Assert.assertEquals(exp, jPiece);
  }

  @Test
  public void testJPieceMoves() {
    setUp();
    Tetra exp = new JPiece(new Brick(4, 6, TetraType.J));
    jPiece.moveDown();
    Assert.assertEquals(exp, jPiece);
    exp = new JPiece(new Brick(3, 6, TetraType.J));
    jPiece.moveLeft();
    Assert.assertEquals(exp, jPiece);
    exp = new JPiece(new Brick(4, 6, TetraType.J));
    jPiece.moveRight();
    Assert.assertEquals(exp, jPiece);
  }

  @Test
  public void testJPieceRotCW() {
    setUp();
    Tetra exp = new JPiece(List.of(new Brick(4, 5, TetraType.J), new Brick(4, 4, TetraType.J),
            new Brick(4, 3, TetraType.J), new Brick(3, 5, TetraType.J)));
    exp.rotateCW();
    jPiece.rotateCW();
    Assert.assertEquals(exp, jPiece);

    for (Brick b : exp.getBricks()) {
      for (Brick bs : jPiece.getBricks()) {
        if (b.equals(bs)) {
          Assert.assertEquals(b, bs);
        }
      }
    }

  }

  @Test
  public void testJPieceRotCCW() {
    setUp();
    Tetra exp = new JPiece(List.of(new Brick(4, 5, TetraType.J), new Brick(4, 4, TetraType.J),
            new Brick(4, 3, TetraType.J), new Brick(3, 5, TetraType.J)));
    exp.rotateCCW();
    jPiece.rotateCCW();
    Assert.assertEquals(exp, jPiece);

    for (Brick b : exp.getBricks()) {
      for (Brick bs : jPiece.getBricks()) {
        if (b.equals(bs)) {
          Assert.assertEquals(b, bs);
        }
      }
    }
  }

  @Test
  public void testJPieceCanMoveDown() {
    setUp();

    jPiece = new JPiece(new Brick(4, 18, TetraType.J));
    Tetra p1 = new IPiece(new Brick(4, 19, TetraType.J));
    Assert.assertFalse(p1.canMoveDown(m.getBoard()));

    Board b = m.getBoard();
    b.addPiece(p1);
    b.addPiece(jPiece);

    Assert.assertFalse(jPiece.canMoveDown(b));
  }

  @Test
  public void testJPieceCanMoveLeft() {
    setUp();

    jPiece = new JPiece(new Brick(1, 5, TetraType.J));
    Board b = m.getBoard();

    Assert.assertFalse(jPiece.canMoveLeft(b));
    Assert.assertTrue(jPiece.canMoveRight(b));

    jPiece.moveRight();
    Assert.assertTrue(jPiece.canMoveLeft(b));
  }

  @Test
  public void testJPieceCanMoveRight() {
    setUp();

    jPiece = new JPiece(new Brick(8, 5, TetraType.J));
    Board b = m.getBoard();

    Assert.assertTrue(jPiece.canMoveRight(b));
    Assert.assertTrue(jPiece.canMoveLeft(b));

    jPiece.moveRight();
    Assert.assertFalse(jPiece.canMoveRight(b));

    jPiece.moveLeft();
    Assert.assertTrue(jPiece.canMoveRight(b));
  }

  @Test
  public void testJPieceCanRotateCW() {
    setUp();
    Board b = new Board(10, 20);
    Tetra test = new JPiece(new Brick(7, 4, TetraType.J));
    Assert.assertTrue(test.canRotateCW(b));
    test.rotateCW();
    Assert.assertFalse(test.canMoveRight(b));

    test.rotateCCW();
    test.moveRight();
    test.moveRight();

    Assert.assertFalse(test.canRotateCW(m.getBoard()));
  }

  @Test
  public void testJPieceCanRotCCW() {
    setUp();
    Board b = new Board(10, 20);
    Tetra test = new JPiece(new Brick(1, 4, TetraType.J));
    Assert.assertFalse(test.canRotateCCW(b));
    test.moveRight();
    test.rotateCCW();
    Assert.assertTrue(test.canRotateCCW(b));
    Assert.assertFalse(test.canMoveLeft(b));

    test.rotateCW();
    test.moveLeft();
  }
}
