package fr.istic.m1.se.projet.graph;

public class Edge {

    private Node n1, n2;

    public Edge(Node n1, Node n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public Edge(Edge e) {
        this.n1 = new Node(e.getN1());
        this.n2 = new Node(e.getN2());
    }

    public Node getN1() {
        return n1;
    }

    public Node getN2() {
        return n2;
    }

    public boolean isSelfLoop() {
        return n1.equals(n2);
    }

    public void replaceNode(Node old, Node neo) {
        if (old.equals(n1)) n1 = neo;
        else n2 = neo;
    }

    @Override
    public String toString() {
        return n1+" --- "+n2;
    }

    public boolean equals(Edge other) {
        return n1.equals(other.n1) || n1.equals(other.n2) || n2.equals(other.n1) || n2.equals(other.n1);
    }
}
