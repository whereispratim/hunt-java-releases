// File: ImplicitClassDemo.java

// No explicit class declaration needed

// Instance fields
String greeting = "Hello, Java 22!";
int count = 5;

// Instance main method
void main() {
    System.out.println("Starting the program...");

    // Using instance members directly
    printGreeting();

    // Calling other instance methods
    countDown();

    System.out.println("Program finished!");
}

// Instance method
void printGreeting() {
    System.out.println(greeting);
}

// Another instance method
void countDown() {
    System.out.println("Counting down:");
    for (int i = count; i > 0; i--) {
        System.out.println(i);
    }
}

// You can add more instance methods and fields as needed