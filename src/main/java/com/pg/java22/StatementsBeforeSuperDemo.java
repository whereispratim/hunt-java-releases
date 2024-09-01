package com.pg.java22;

// File: StatementsBeforeSuperDemo.java

class Parent {
    private final String name;
    private final int age;

    Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Parent{name='" + name + "', age=" + age + "}";
    }
}

class Child extends Parent {
    private final String hobby;

    Child(String name, int age, String hobby) {
        // Statements before super(...)
        //Java x < 22, we can't do this directly in the constructor; we need the extra factory method.
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        // Call to super(...) after validation and preparation
        super(capitalizedName, age);

        // Rest of the constructor
        this.hobby = hobby;
    }



    @Override
    public String toString() {
        return "Child{" + super.toString() + ", hobby='" + hobby + "'}";
    }
}

public class StatementsBeforeSuperDemo {
    public static void main(String[] args) {
        try {
            Child child1 = new Child("alice", 10, "reading");
            System.out.println(child1);

            // This will throw an exception
            Child child2 = new Child("", -5, "invalid");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
