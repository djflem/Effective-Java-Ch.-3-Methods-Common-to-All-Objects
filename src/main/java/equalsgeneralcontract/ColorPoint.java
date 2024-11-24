package equalsgeneralcontract;

import java.awt.*;

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
