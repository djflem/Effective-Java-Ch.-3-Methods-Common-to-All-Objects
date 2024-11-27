package org.example.equalsgeneralcontract;

import java.awt.*;
import java.util.Objects;

// Refactor favoring composition over inheritance (no longer extends)
// Adds a value component without violating the equals contract
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    // Returns the point-view of this color point.
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}

/*
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        // If o is a normal Point, do a color-blind comparison
        // Refactor attempt 1: Symmetry fixed at the cost of transitivity
        // Unfortunately, there is no way to extend an instantiable class and add a value component while preserving the equals contract
        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}
*/
