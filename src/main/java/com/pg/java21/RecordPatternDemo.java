package com.pg.java21;

/**
 * Scala :
 * case class Point(x: Int, y: Int)
 *
 * def describePoint(point: Point): String = point match {
 *   case Point(0, 0) => "Point at the origin"
 *   case Point(x, y) => s"Point at ($x, $y)"
 * }
 * -----
 * Java 21:
 * public record Point(int x, int y) {}
 *
 * static String describePoint(Point point) {
 *     return switch (point) {
 *         case Point(int x, int y) when x == 0 && y == 0 -> "Point at the origin";
 *         case Point(int x, int y) -> "Point at (" + x + ", " + y + ")";
 *         default -> "Not a Point";
 *     };
 * }
 *
 */
// Define a simple record with two fields
//public record Point(int x, int y) {}
public class RecordPatternDemo {
    public static void main(String[] args) {
        // Create instances of the Point record
        Point point1 = new Point(3, 4);
        Point point2 = new Point(0, 0);
        Point point3 = new Point(10, -5);

        // Using pattern matching with instanceof
        System.out.println(describePoint(point1)); // "Point at (3, 4)"
        System.out.println(describePoint(point2)); // "Point at the origin"
        System.out.println(describePoint(point3)); // "Point with positive x"

        // Using record pattern in a switch expression
        System.out.println(classifyPoint(point1)); // "First Quadrant"
        System.out.println(classifyPoint(point2)); // "Origin"
        System.out.println(classifyPoint(point3)); // "Fourth Quadrant"
    }

    // Method to describe a point using pattern matching with instanceof
    static String describePoint(Object obj) {
        if (obj instanceof Point(int x, int y)) {
            if (x == 0 && y == 0) {
                return "Point at the origin";
            }
            return "Point at (" + x + ", " + y + ")";
        }
        return "Not a Point";
    }

    // Method to classify a point's location in a coordinate plane
    static String classifyPoint(Point point) {
        return switch (point) {
            case Point(int x, int y) when x > 0 && y > 0 -> "First Quadrant";
            case Point(int x, int y) when x < 0 && y > 0 -> "Second Quadrant";
            case Point(int x, int y) when x < 0 && y < 0 -> "Third Quadrant";
            case Point(int x, int y) when x > 0 && y < 0 -> "Fourth Quadrant";
            case Point(int x, int y) when x == 0 && y == 0 -> "Origin";
            default -> "On an axis";
        };
    }
}

