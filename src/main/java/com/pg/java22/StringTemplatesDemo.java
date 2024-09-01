package com.pg.java22;

import static java.lang.StringTemplate.RAW;

public class StringTemplatesDemo {

    public static void main(String[] args) {
        basicUsage();
        multilineTemplates();
        expressionsInTemplates();
        customProcessor();
        rawTemplates();
    }

    private static void basicUsage() {
        String name = "Pratim";
        int age = 30;
        String greeting = STR."Hello, \{name}! You are \{age} years old.";
        System.out.println(greeting);
    }

    private static void multilineTemplates() {
        String name = "Jack";
        int score = 95;
        String html = STR."""
            <html>
                <body>
                    <h1>Welcome, \{name}!</h1>
                    <p>Your score is: \{score}</p>
                </body>
            </html>
            """;
        System.out.println(html);
    }

    private static void expressionsInTemplates() {
        int x = 10, y = 20;
        String math = STR."\{x} + \{y} = \{x + y}";
        System.out.println(math);

        boolean isAdult = true;
        String status = STR."Status: \{isAdult ? "Adult" : "Minor"}";
        System.out.println(status);
    }

    private static void customProcessor() {
        record Person(String name, int age) {}
        Person person = new Person("Angela", 25);

        StringTemplate.Processor<String, RuntimeException> upperCase =
                (StringTemplate st) -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < st.fragments().size(); i++) {
                        sb.append(st.fragments().get(i));
                        if (i < st.values().size()) {
                            sb.append(String.valueOf(st.values().get(i)).toUpperCase());
                        }
                    }
                    return sb.toString();
                };

        String result = upperCase.process(StringTemplate.of(STR."Name: \{person.name()}, Age: \{person.age()}"));
        System.out.println(result);
    }

    private static void rawTemplates() {
        int a = 5, b = 7;
        StringTemplate template = RAW."The sum of \{a} and \{b} is \{a + b}";

        System.out.println("Fragments:");
        for (String fragment : template.fragments()) {
            System.out.println(fragment);
        }

        System.out.println("\nValues:");
        for (Object value : template.values()) {
            System.out.println(value);
        }
    }
}
