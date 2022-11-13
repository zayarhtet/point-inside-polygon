package shape.polygon;

import shape.Point;
import shape.Shape;

public abstract class Polygon extends Shape {
    protected int sideCount;

    public Polygon() {}
    public Polygon(Point center, double length, int sideCount) {
        super(center, length);
        this.sideCount = sideCount;
    }
}
