package fr.istic.m1.se.projet.graph;

public class Node {

    private final int id;
    private String name;
    private static int counter = 0;

    public Node(String name) {
        this.id = counter++;
        this.name = name;
    }

    public Node() {
        this.id = counter++;
        this.name = String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void rename(String n) { this.name = n; }

    @Override
    public String toString() {
        return name;
    }


    public boolean equals(Node other) {
        return id == other.id;
    }
}
