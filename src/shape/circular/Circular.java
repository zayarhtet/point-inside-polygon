package shape.circular;

import shape.Point;
import shape.Shape;

public abstract class Circular extends Shape {
    public Circular() {}
    public Circular(Point p, double radius) {
        super(p, radius);
    }
}
