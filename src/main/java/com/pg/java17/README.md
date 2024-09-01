# Java 17 Features

Java 17 is a Long-Term Support (LTS) release that brings several new features and enhancements to the Java programming language. Here's a summary of the key features:

## 1. Sealed Classes (Finalized)
Sealed classes and interfaces restrict which other classes or interfaces can extend or implement them. This feature provides more control over the class hierarchy.

## 2. Pattern Matching for switch (Preview)
Enhances the `switch` statement and expression with pattern matching capabilities, allowing more expressive and concise code.

## 3. Enhanced Pseudo-Random Number Generators
Introduces new interfaces and implementations for random number generators, providing more flexibility and performance improvements.

## 4. New macOS Rendering Pipeline
Introduces a new rendering pipeline for macOS using the Apple Metal API, replacing the deprecated OpenGL pipeline.

## 5. macOS/AArch64 Port
Adds support for macOS on Apple Silicon (AArch64), ensuring Java runs efficiently on the latest Apple hardware.

## 6. Deprecate the Security Manager for Removal
Deprecates the Security Manager, marking it for potential removal in a future release, as it is rarely used and has been superseded by other security mechanisms.

## 7. Context-Specific Deserialization Filters
Introduces a mechanism for defining context-specific deserialization filters, enhancing security by allowing applications to validate incoming serialized data.

## 8. Pattern Matching for `switch` (Preview)
Adds pattern matching to `switch` statements and expressions, simplifying code by allowing more complex data queries and transformations.

## 9. JEP 411: Deprecate the Security Manager for Removal
Marks the Security Manager for deprecation and potential removal in a future release, encouraging the use of more modern security practices.

## 10. Foreign Function & Memory API (Incubator)
Introduces an API for interacting with native code and memory, providing a safer and more efficient alternative to JNI.

## 11. Vector API (Second Incubator)
Enhances the Vector API, enabling developers to express vector computations that compile to optimal vector instructions on supported hardware.

## 12. Enhanced Pseudo-Random Number Generators
Provides new interfaces and implementations for random number generators, offering more flexibility and performance improvements.

## 13. New macOS Rendering Pipeline
Introduces a new rendering pipeline for macOS using the Apple Metal API, replacing the deprecated OpenGL pipeline.

---

These features collectively enhance the Java programming language by providing more control over class hierarchies, improving performance, and adding new capabilities for working with native code and memory. For more detailed information, refer to the official [Java 17 documentation](https://docs.oracle.com/en/java/javase/17/).

---
## Key Differences between Java `sealed` vs Scala `case`:

Java Sealed Classes are focused on controlling inheritance and ensuring type safety through exhaustive pattern matching. They are a more recent addition to the language, adding flexibility and security in designing closed type hierarchies.
```java
public abstract sealed class Shape permits Circle, Rectangle, Square {}

public final class Circle extends Shape {}
public final class Rectangle extends Shape {}
public final class Square extends Shape {}
```
Scala Case Classes are designed for functional programming, offering a concise and powerful way to model immutable data. They come with automatic features and integrate seamlessly with Scala's pattern matching, making them a versatile tool for working with data in a functional style.
```scala
sealed trait Shape
case class Circle(radius: Double) extends Shape
case class Rectangle(width: Double, height: Double) extends Shape
case class Square(side: Double) extends Shape
```