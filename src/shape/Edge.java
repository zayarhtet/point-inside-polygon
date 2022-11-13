package shape;

public class Edge {
    private Point startPoint;
    private Point endPoint;

    public Edge (Point startPoint, Point endPoint) {
        this.startPoint = new Point(startPoint.getX(), startPoint.getY());
        this.endPoint = new Point(endPoint.getX(), endPoint.getY());
    }

    public Point getStartPoint() {
        return new Point(startPoint.getX(), startPoint.getY());
    }

    public Point getEndPoint() {
        return new Point(endPoint.getX(), endPoint.getY());
    }

    public String toString() {
        return startPoint.toString() + " --> " + endPoint.toString();
    }
}
