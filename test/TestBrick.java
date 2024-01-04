import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.pieces.Brick;
import model.pieces.OPiece;
import model.pieces.Tetra;

public class TestBrick {

  Brick b;
  @Before
  public void setUp() {
    b = new Brick(4, 5);
  }

  @Test
  public void testBrickSettersAndGetters() {
    setUp();
    Assert.assertEquals(4, b.getX());
    Assert.assertEquals(5, b.getY());
    b.setX(6);
    b.setY(7);
    Assert.assertEquals(6, b.getX());
    Assert.assertEquals(7, b.getY());
  }

  @Test
  public void testBrickMove() {
    setUp();
    b.moveDown();
    Assert.assertEquals(6, b.getY());
    b.moveLeft();
    Assert.assertEquals(3, b.getX());
    b.moveRight();
    Assert.assertEquals(4, b.getX());
  }

  @Test
  public void testBrickRotCW() {
    setUp();
    b.rotateCW();
    Assert.assertEquals(5, b.getX());
    Assert.assertEquals(-4, b.getY());
  }

  @Test
  public void testBrickRotCCW() {
    setUp();
    b.rotateCCW();
    Assert.assertEquals(-5, b.getX());
    Assert.assertEquals(4, b.getY());
  }

  @Test
  public void testBrickEquals() {
    setUp();
    Brick b2 = new Brick(4, 5);
    Assert.assertEquals(b, b2);
    Assert.assertNotEquals(b, null);
    Assert.assertNotEquals(b, new OPiece(b));
    Assert.assertEquals(b, b);
  }

  @Test
  public void testBrickHashCode() {
    setUp();
    Brick b2 = new Brick(4, 5);
    Assert.assertEquals(900, b.hashCode());
    Assert.assertEquals(b.hashCode(), b2.hashCode());
  }
}
