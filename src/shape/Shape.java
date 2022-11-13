package shape;

import shape.circular.Circle;
import shape.exception.CouldNotReadShapeException;
import shape.polygon.RegularHexagon;
import shape.polygon.RegularTriangle;
import shape.polygon.Square;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    protected List<Edge> edges;
    protected double dimension;
    protected Point center;
    public Shape() {}
    public Shape(Point p, double dimension) {
        center = new Point(p.getX(), p.getY());
        this.dimension = dimension;
    }

    public abstract boolean isInside(Point p);

    public static List<Shape> readShapeFromFile(String filename) throws IOException, CouldNotReadShapeException, NumberFormatException {
        List<Shape> shapes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            //System.out.println(line);
            String[] data = line.split(" ");
            Point center = new Point(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
            int dimension = Integer.parseInt(data[3]);

            switch(data[0]) {
                case "c":
                    shapes.add(new Circle(center, dimension));
                    break;
                case "t":
                    shapes.add(new RegularTriangle(center, dimension));
                    break;
                case "h":
                    shapes.add(new RegularHexagon(center, dimension));
                    break;
                case "s":
                    shapes.add(new Square(center, dimension));
                    break;
                default:
                    throw new CouldNotReadShapeException("Line "+ (i+2) +" of "+filename +" could not be read.");
            }
        }
        return shapes;
    }

    protected static boolean isPointInside(List<Edge> edges, Point target) {
        if (edges.isEmpty()) return false;
        boolean isInside = true;
        for (Edge edge: edges) {
            Point p1 = edge.getStartPoint();
            Point p2 = edge.getEndPoint();
            double x = (p2.getX()-p1.getX())*(target.getY()-p1.getY()) - (target.getX() - p1.getX()) * (p2.getY() - p1.getY());
            isInside = isInside && x > 0;
            if (!isInside) break;
        }
        return isInside;
    }
    public abstract String toString();
}
