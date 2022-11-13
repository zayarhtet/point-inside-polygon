package shape.polygon;

import shape.Edge;
import shape.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegularHexagon extends Polygon {
    public RegularHexagon(Point center, double length) {
        super(center, length, 6);

        double halfLen = super.dimension/2.0;

        double heightFromCenterLine = Math.sqrt((super.dimension*super.dimension)-(halfLen*halfLen));

        Point right = new Point (super.center.getX()+super.dimension, super.center.getY());
        Point left = new Point (super.center.getX()-super.dimension, super.center.getY());
        Point rightTop = new Point (super.center.getX()+halfLen, super.center.getY()+heightFromCenterLine);
        Point leftTop = new Point (rightTop.getX() - super.dimension, rightTop.getY());
        Point leftBot = new Point (leftTop.getX(), leftTop.getY()-(heightFromCenterLine*2));
        Point rightBot = new Point (leftBot.getX()+super.dimension, leftBot.getY());

        super.edges = new ArrayList<> (Arrays.asList(
                new Edge(right, rightTop),
                new Edge (rightTop, leftTop),
                new Edge (leftTop, left),
                new Edge (left, leftBot),
                new Edge (leftBot, rightBot),
                new Edge (rightBot, right)
        ));
    }

    @Override
    public boolean isInside(Point p) {
        return isPointInside(edges, p);
    }

    @Override
    public String toString() {
        String result = "RegularHexagon with center: "+ super.center.toString() +"; and dimension: " + super.dimension + "\n";
        for (Edge edg : super.edges) {
            result += edg.toString() +"\n";
        }
        result += "\n";
        return result;
    }
}
