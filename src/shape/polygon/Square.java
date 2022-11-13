package shape.polygon;

import shape.Edge;
import shape.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square extends Polygon {

    public Square(Point center, double length) {
        super(center, length, 4);

        double halfLen = super.dimension/2.0;
        Point rightTop = new Point(super.center.getX()+halfLen, super.center.getY()+halfLen);
        Point leftTop = new Point (rightTop.getX()-super.dimension, rightTop.getY());
        Point leftBot = new Point (leftTop.getX(), leftTop.getY()-super.dimension);
        Point rightBot = new Point(leftBot.getX()+super.dimension, leftBot.getY());

        super.edges = new ArrayList<>(Arrays.asList(
                new Edge(leftTop, leftBot),
                new Edge(leftBot, rightBot),
                new Edge(rightBot, rightTop),
                new Edge(rightTop, leftTop)
        ));
    }

    @Override
    public boolean isInside(Point p) {
        return isPointInside(super.edges, p);
    }

    @Override
    public String toString() {
        String result = "Square with center "+ super.center.toString() +"; and dimension: " + super.dimension + "\n";
        for (Edge edg : super.edges) {
            result += edg.toString() +"\n";
        }
        result += "\n";
        return result;
    }
}
