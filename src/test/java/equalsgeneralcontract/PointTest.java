package equalsgeneralcontract;

import org.junit.Test;

import java.awt.*;
import java.util.Set;
import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void testOnUnitCircle() {
        Point po1 = new Point(1, 0); // On the unit circle
        Point po2 = new Point(0, 1); // On the unit circle
        Point po3 = new Point(-1, 0); // On the unit circle
        Point po4 = new Point(0, -1); // On the unit circle
        Point po5 = new Point(2, 0); // Not on the unit circle
        assertTrue(Point.onUnitCircle(po1));
        assertTrue(Point.onUnitCircle(po2));
        assertTrue(Point.onUnitCircle(po3));
        assertTrue(Point.onUnitCircle(po4));
        assertFalse(Point.onUnitCircle(po5));
    }

    // For any non-null reference value x, x.equals(x) must return true.
    @Test
    public void testReflexivity() {
        Point p = new Point(1, 0);
        Point pp = new Point(3, 0);
        assertTrue("Reflexivity failed: a point should equal itself", p.equals(p));
        assertFalse("Reflexivity failed: a point should not equal a different point", p.equals(pp));
    }

    // For any non-null reference values x and y, x.equals(y) must return true if and only if y.equals(x) returns true.
    @Test
    public void testSymmetry() {
        ColorPoint cp1 = new ColorPoint(1, 0, Color.RED);
        ColorPoint cp2 = new ColorPoint(1, 0, Color.RED);
        ColorPoint cp3 = new ColorPoint(1, 0, Color.BLUE);
        assertTrue("Symmetry failed: p1 should equal p2", cp1.equals(cp2));
        assertTrue("Symmetry failed: p2 should equal p1", cp2.equals(cp1));
        assertFalse("Symmetry failed: p1 should not equal p3", cp1.equals(cp3));
    }

    // For any non-null reference values x,y,z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) must return true.
    @Test
    public void testTransitivity() {
        CounterPoint cp1 = new CounterPoint(1, 0);
        System.out.println("CounterPoint AtomicInteger counter: " + CounterPoint.getNumberCreated());
        CounterPoint cp2 = new CounterPoint(1, 0);
        System.out.println("CounterPoint AtomicInteger counter: " + CounterPoint.getNumberCreated());
        CounterPoint cp3 = new CounterPoint(1, 0);
        System.out.println("CounterPoint AtomicInteger counter: " + CounterPoint.getNumberCreated());
        assertTrue("Transitivity failed: p1 should equal p2", cp1.equals(cp2));
        assertTrue("Transitivity failed: p2 should equal p3", cp2.equals(cp3));
        assertTrue("Transitivity failed: p1 should equal p3", cp1.equals(cp3));
        // Tests still passing despite number incrementing for each instantiation (This is good).
    }

    // For any non-nul reference values x and y, multiple invocations of x.equals(y) must consistently return true or consistently return false,
    // provided no information used in equals comparisons is modified.
    @Test
    public void testConsistency() {
        ColorPoint cp1 = new ColorPoint(1, 0, Color.ORANGE);
        ColorPoint cp2 = new ColorPoint(1, 0, Color.ORANGE);
        assertTrue("Consistency failed: first call", cp1.equals(cp2));
        assertTrue("Consistency failed: second call", cp1.equals(cp2));
        assertTrue("Consistency failed: third call", cp1.equals(cp2));
    }

    // For any non-null reference value x, x.equals(null) must return false.
    @Test
    public void testNullComparison() {
        Point p = new Point(1, 0);
        assertFalse("Null comparison failed", p.equals(null));
    }
}
