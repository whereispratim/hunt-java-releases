# Java 21 Features

Java 21 is a Long-Term Support (LTS) release that introduces several new features and improvements. Here's a summary of the key features:

## 1. Virtual Threads (Project Loom)
Virtual Threads are lightweight threads managed by the JVM, designed to dramatically improve application throughput and scalability.
Java 21 introduced two notable changes to the virtual threads:

-Virtual threads now always support thread-local variables.
-Virtual threads are created through the Thread.Builder APIs are also monitored through their lifetime and observable in the new thread dump

## 2. Record Patterns
Enhances pattern matching for records, allowing nested deconstruction of record components, making it easier to work with complex data structures.

## 3. Pattern Matching for switch (Finalized)
This feature allows pattern matching in switch statements and expressions, enabling more expressive and concise code.

## 4. Sequenced Collections
Introduces new collection interfaces that provide direct access to the first and last elements of an ordered collection, improving ease of use.

## 5. String Templates (Preview)
A new way to create strings with embedded expressions, enhancing string manipulation capabilities.

## 6. Unnamed Patterns and Variables (Preview)
Allows the use of underscore '_' for unnamed patterns and variables, improving code readability in certain scenarios.

## 7. Unnamed Classes and Instance Main Methods (Preview)
Simplifies writing small programs by allowing methods to be defined outside of explicit class declarations, making Java more accessible for beginners.

## 8. Scoped Values (Preview)
Provides a way to safely and efficiently share immutable data within and across threads, offering an alternative to ThreadLocal with better performance characteristics.

## 9. Structured Concurrency (Preview)
Simplifies multithreaded programming by treating multiple related tasks running in different threads as a single unit of work.

## 10. Generational ZGC
Improvements to the Z Garbage Collector, enhancing performance and reducing pause times.

## 11. Foreign Function & Memory API (Third Preview)
Allows Java programs to interoperate with code and data outside of the Java runtime, improving integration with native libraries.

## 12. Vector API (Sixth Incubator)
Provides vector computations that reliably compile at runtime to optimal vector hardware instructions, boosting performance for numerical applications.

## 13. Key Encapsulation Mechanism API
Introduces a new API for key encapsulation mechanisms, enhancing Java's cryptographic capabilities.

---

These features collectively aim to improve Java's performance, concurrency handling, expressiveness, and interoperability with non-Java code. Some features are fully implemented, while others are in preview or incubator status, meaning they may evolve in future releases.

For more detailed information, refer to the official [Java 21 documentation](https://docs.oracle.com/en/java/javase/21/).
---
## Key Differences between Java `Record` vs Scala `case`:

1. Pattern Matching: Both Scala's case class pattern matching and Java's record patterns allow you to destructure objects and match their components directly within a match or switch expression.
2. Immutable Data Carriers: In Scala, case classes are used to create immutable data carriers with built-in pattern matching capabilities. Similarly, in Java, records are immutable data carriers that can be used in pattern matching with record patterns.
3. Conciseness: Both languages provide a concise syntax for working with data classes (records in Java and case classes in Scala) and allow you to directly access and work with the fields of these classes within pattern matching constructs.
```java
public record Point(int x, int y) {}

static String describePoint(Point point) {
    return switch (point) {
        case Point(int x, int y) when x == 0 && y == 0 -> "Point at the origin";
        case Point(int x, int y) -> "Point at (" + x + ", " + y + ")";
        default -> "Not a Point";
    };
}

```
```scala
case class Point(x: Int, y: Int)

def describePoint(point: Point): String = point match {
  case Point(0, 0) => "Point at the origin"
  case Point(x, y) => s"Point at ($x, $y)"
}

```