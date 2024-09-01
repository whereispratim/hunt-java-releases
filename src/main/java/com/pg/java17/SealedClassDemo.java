package com.pg.java17;
sealed interface Shape permits Circle, Rectangle, Square {}

record Circle(double radius) implements Shape {}
record Rectangle(double width, double height) implements Shape {}

record Square(double side) implements Shape {}

public class SealedClassDemo {
    public static String classifyShape(Shape shape) {
        return switch (shape) {
            case Circle(double radius) -> "Circle with radius " + radius;
            case Rectangle(double width, double height) -> "Rectangle with width " + width + " and height " + height;
            case Square(double side) -> "Square with side " + side;
        };
    }

    public static void main(String[] args) {
        Shape shape = new Circle(5.0);
        System.out.println(classifyShape(shape));  // Output: Circle with radius 5.0
    }
}
