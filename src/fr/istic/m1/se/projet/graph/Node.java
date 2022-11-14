package fr.istic.m1.se.projet.graph;

import java.util.Objects;

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

    public Node(Node n) {
        this.id = n.id;
        this.name = n.name;
    }

    public String getName() {
        return name;
    }

    public void rename(String n) { this.name = n; }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        Node node = (Node) o;
        return id == node.id || name.equals(node.name);
    }

}
