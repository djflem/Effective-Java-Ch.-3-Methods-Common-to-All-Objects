package equalsgeneralcontract;

import java.util.Set;

// Reminder: Do not write an equals method that depends on unreliable resources.
public class Point {
    private final int x;
    private final int y;
    // Initialize unitCircle to contain all Points on the unit circle
    private static final Set<Point> unitCircle = Set.of(
            new Point(1, 0),
            new Point(0, 1),
            new Point(-1, 0),
            new Point(0, -1)
    );

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    // Why hashCode Matters:
    // 1. Set.contains() uses hashCode first to locate potential matches in the set.
    // 2. If the hash codes of two objects do not match, equals is never called.
    // 3. Since hashCode defaults to Object's implementation (based on memory address), two logically equal Point objects (same x and y) can have different hash codes unless hashCode is overridden.
    // Always override hashCode when you override equals
    @Override
    public int hashCode() {
        return 31 * x + y; // Combine x and y with a prime multiplier
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    /*
    // Broken - violates Liskov substitution principle
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
    */
}
