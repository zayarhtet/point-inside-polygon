import shape.Point;
import shape.Shape;
import shape.exception.CouldNotReadShapeException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //String filename = "testfiles/FirstQuadrant";          // (9,7)   -> 4
        //String filename = "testfiles/SecondQuadrant";           // (-9,7)  -> 4
        //String filename = "testfiles/ThirdQuadrant";          // (-9,-7) -> 4
        //String filename = "testfiles/FourthQuadrant";         // (9,-7)  -> 4

        //String filename = "testfiles/AllShape";               // (9,7) -> 4
        //String filename = "testfiles/NoneShape";              // (9,7) -> 0
        //String filename = "testfiles/OnEdge";                 // (9,7) -> 0
        //String filename = "testfiles/FirstShape";             // (9,7) -> 1
        //String filename = "testfiles/LastShape";              // (9,7) -> 1

        String filename = "testfiles/EmptyShape";             // (9,7) -> 0
        //String filename = "testfiles/NullFile";               // throw null
        //String filename = "testfiles/ExceptionShape";          // throw CouldNotReadShapeException

        try {
            List<Shape> shapes = Shape.readShapeFromFile(filename);
            Point p = inputPoint("Please enter the point: ");

            int result = shapes.stream().filter(shape -> {
                System.out.print(shape.toString());
                boolean isInsideOf = shape.isInside(p);
                System.out.println("Is inside of p: " + isInsideOf +"\n");
                return isInsideOf;
            } ).collect(Collectors.toList()).size();

            System.out.println("Number of shape containing the point p: " + result);

        } catch (IOException | CouldNotReadShapeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
            System.out.println("Cannot parse the values of the shape from "+ filename);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Point inputPoint(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        System.out.print("x value: ");
        int x = scanner.nextInt();
        System.out.print("y value: ");
        int y = scanner.nextInt();
        return new Point(x,y);
    }
}
