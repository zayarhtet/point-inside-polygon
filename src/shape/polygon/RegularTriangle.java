package shape.polygon;

import shape.Edge;
import shape.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegularTriangle extends Polygon{
    public RegularTriangle(Point center, double length) {
        super(center, length, 3);

        double halfLen = super.dimension/2.0;
        double height = Math.sqrt((halfLen*halfLen)+(super.dimension*super.dimension));
        double centerToBase = height/3.0; double centerToTop = (height*2)/3.0;

        Point rightBot = new Point (super.center.getX()+halfLen, super.center.getY()-centerToBase);
        Point leftBot = new Point (rightBot.getX() - super.dimension, rightBot.getY());
        Point top = new Point(super.center.getX(), super.center.getY()+centerToTop);

        super.edges = new ArrayList<> (Arrays.asList(
                new Edge(top, leftBot),
                new Edge(leftBot, rightBot),
                new Edge(rightBot, top)
        ));
    }
    @Override
    public boolean isInside(Point p) {
        return isPointInside(edges, p);
    }

    @Override
    public String toString() {
        String result = "RegularTriangle with center "+ super.center.toString() +"; and dimension: " + super.dimension + "\n";
        for (Edge edg : super.edges) {
            result += edg.toString() +"\n";
        }
        result += "\n";
        return result;
    }
}
