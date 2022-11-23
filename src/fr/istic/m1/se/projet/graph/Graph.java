package fr.istic.m1.se.projet.graph;

import java.util.*;

public class Graph {

    private List<Edge> edges;

    private Set<Integer> nodes;

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
        nodes.addAll(source.nodes);
        for (Edge ed : source.edges) { // ca pique le nombre de boucle
            for (Integer src : this.nodes) {
                for (Integer dest : this.nodes) {
                    if (src.equals(ed.getSrc()) && dest.equals(ed.getDest()))
                        addEdge(src, dest);
                }
            }
        }
    }


    public int getNbNodes() {
        return nodes.size();
    }

    public int getNbEdges() { return edges.size(); }

    public void addEdge(Integer src, Integer dest) {
        edges.add(new Edge(src, dest));
        nodes.add(src);
        nodes.add(dest);
    }

    public void removeEdge(Edge e) {
        edges.remove(e);
    }

    public void removeNode(Integer n) {
        nodes.remove(n);
    }

    public Edge getEdge(int i) {
        return edges.get(i);
    }

    public void addNode(Integer n) { nodes.add(n); }

    public void printGraph() {
        for (Edge e : edges) {
            System.out.println(e);
        }
    }

    public void printNodes() {
        for (Integer n : nodes) {
            System.out.print(n+" ");
        }
        System.out.println();
    }

}
