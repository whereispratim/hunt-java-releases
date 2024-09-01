package com.pg.java21;

public class PatternMatchingForSwitchDemo {

    public static void main(String[] args) {
        testShape(new Circle(5));
        testShape(new Rectangle(4, 6));
        testShape(new Triangle(3, 4));
        testShape("Not a shape");
        testShape(null);

        testResponse("YES");
        testResponse("no");
        testResponse("Maybe");
        testResponse(null);
    }

    static void testShape(Object shape) {
        String result = switch (shape) {
            case Circle c -> String.format("Circle with radius %.2f", c.radius);
            case Rectangle r -> String.format("Rectangle with width %.2f and height %.2f", r.width, r.height);
            case Triangle t -> String.format("Triangle with base %.2f and height %.2f", t.base, t.height);
            case null -> "Shape is null";
            default -> "Unknown shape";
        };
        System.out.println(result);
    }

    static void testResponse(String response) {
        switch (response) {
            case null -> System.out.println("No response given");
            case String s when s.equalsIgnoreCase("YES") -> System.out.println("Positive response");
            case String s when s.equalsIgnoreCase("NO") -> System.out.println("Negative response");
            case String s -> System.out.println("Unknown response: " + s);
        }
    }
}

class Circle {
    double radius;
    Circle(double radius) { this.radius = radius; }
}

class Rectangle {
    double width, height;
    Rectangle(double width, double height) { this.width = width; this.height = height; }
}

class Triangle {
    double base, height;
    Triangle(double base, double height) { this.base = base; this.height = height; }
}