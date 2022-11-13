package shape.circular;

import shape.Point;

public class Circle extends Circular {

    public Circle () {}

    public Circle(Point center, double radius) {
        super(center, radius);
    }

    @Override
    public boolean isInside(Point p) {
        return Point.distance(super.center, p) < super.dimension;
    }

    @Override
    public String toString() {
        return "Circle with center: "+ super.center.toString() + "; and dimension: " + super.dimension;
    }
}
