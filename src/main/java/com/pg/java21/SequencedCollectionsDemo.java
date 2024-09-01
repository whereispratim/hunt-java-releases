package com.pg.java21;

import java.util.*;

//direct access to the first and last elements of an ordered collection
public class SequencedCollectionsDemo {

    public static void main(String[] args) {
        demonstrateSequencedList();
        demonstrateSequencedSet();
        demonstrateSequencedMap();
    }

    private static void demonstrateSequencedList() {
        System.out.println("Demonstrating SequencedCollection with ArrayList:");
        SequencedCollection<String> players = new ArrayList<>();

        players.addFirst("A");
        players.addLast("B");
        players.addLast("C");

        System.out.println("Players: " + players);
        System.out.println("First player: " + players.getFirst());
        System.out.println("Last player: " + players.getLast());

        System.out.println("Reversed players: " + players.reversed());

        players.removeFirst();
        players.removeLast();
        System.out.println("After removing first and last: " + players);

        System.out.println();
    }

    private static void demonstrateSequencedSet() {
        System.out.println("Demonstrating SequencedSet with LinkedHashSet:");
        SequencedSet<String> students = new LinkedHashSet<>();

        students.addFirst("R");
        students.add("G");
        students.addLast("B");

        System.out.println("students: " + students);
        System.out.println("First sudent: " + students.getFirst());
        System.out.println("Last sudent: " + students.getLast());

        System.out.println("Reversed students: " + students.reversed());

        students.removeFirst();
        System.out.println("After removing first: " + students);

        System.out.println();
    }

    private static void demonstrateSequencedMap() {
        System.out.println("Demonstrating SequencedMap with LinkedHashMap:");
        SequencedMap<String, Integer> scores = new LinkedHashMap<>();

        scores.putFirst("A", 95);
        scores.put("B", 87);
        scores.putLast("C", 91);

        System.out.println("Scores: " + scores);
        System.out.println("First entry: " + scores.firstEntry());
        System.out.println("Last entry: " + scores.lastEntry());

        System.out.println("Reversed scores: " + scores.reversed());

        scores.pollFirstEntry();
        System.out.println("After removing first entry: " + scores);

        System.out.println("Keys in order: " + scores.sequencedKeySet());
        System.out.println("Values in order: " + scores.sequencedValues());
    }
}