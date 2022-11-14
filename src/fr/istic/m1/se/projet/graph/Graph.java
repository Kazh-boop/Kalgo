package fr.istic.m1.se.projet.graph;

import java.util.*;

public class Graph {

    private List<Edge> edges;

    private Set<Node> nodes;

    public Graph() {
        edges = new LinkedList<>();
        nodes = new HashSet<>();
    }

    /**
     * Deep copy, a lot of difficult to do
     * @param source graph to copy
     */
    public Graph(Graph source) {
        nodes = new HashSet<>();
        edges = new LinkedList<>();
        for (Node n : source.nodes) nodes.add(new Node(n));
        for (Edge ed : source.edges) { // ca pique le nombre de boucle
            for (Node src : this.nodes) {
                for (Node dest : this.nodes) {
                    if (src.equals(ed.getN1()) && dest.equals(ed.getN2()))
                        addEdge(src, dest);
                }
            }
        }
    }


    public int getNbNodes() {
        return nodes.size();
    }

    public int getNbEdges() { return edges.size(); }

    public void addEdge(Node n1, Node n2) {
        edges.add(new Edge(n1, n2));
        nodes.add(n1);
        nodes.add(n2);
    }

    public void removeEdge(Edge e) {
        edges.remove(e);
    }

    public void removeNode(Node n) {
        nodes.remove(n);
    }

    public Edge getEdge(int i) {
        return edges.get(i);
    }


    public void printGraph() {
        for (Edge e : edges) {
            System.out.println(e);
        }
    }

    public void printNodes() {
        for (Node n : nodes) {
            System.out.print(n+" ");
        }
        System.out.println();
    }

}
