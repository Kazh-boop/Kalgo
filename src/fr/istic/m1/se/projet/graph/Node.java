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

    public int getId() {
        return id;
    }

    public void rename(String n) { this.name = n; }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id == node.id;
    }

}
