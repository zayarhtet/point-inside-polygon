package shape;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p2.getX()-p1.getX())*(p2.getX()-p1.getX())+(p2.getY()-p1.getY())*(p2.getY()-p1.getY()));
    }

    public double getX() { return x; }

    public void setX(int x) { this.x = x; }

    public double getY() { return y; }

    public void setY(int y) { this.y = y; }

    public String toString() {
        return "("+x + "," + y +")";
    }
}
