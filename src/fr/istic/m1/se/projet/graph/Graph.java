package fr.istic.m1.se.projet.graph;

import java.util.*;

/**
 * Simple representation of a graph
 */
public class Graph {

    /**
     * All edges of the graph (vertices are in
     */
    private List<Edge> edges;

    /**
     * All vertices of the graph
     */
    private Set<Vertex> vertices;

    /**
     * Constructor which initialize empty collections/attributes
     */
    public Graph() {
        edges = new LinkedList<>();
        vertices = new HashSet<>();
    }

    /**
     * Deep copy
     * @param source graph to copy
     */
    public Graph(Graph source) {
        vertices = new HashSet<>();
        edges = new LinkedList<>();
        for (Vertex n : source.vertices) vertices.add(new Vertex(n));
        for (Edge ed : source.edges) { // maybe too many loop but couldn't find another way
            for (Vertex src : this.vertices) {
                for (Vertex dest : this.vertices) {
                    if (src.equals(ed.getSrc()) && dest.equals(ed.getDest()))
                        addEdge(src, dest);
                }
            }
        }
    }

    /**
     * Get the number of vertices in the graph
     * @return number of vertices : int
     */
    public int getNbVertices() {
        return vertices.size();
    }

    /**
     * Get the number of edges in the graph
     * @return number of edges : int
     */
    public int getNbEdges() { return edges.size(); }

    /**
     * Add an edge in the graph through vertices
     * @param src : Vertex, vertex source of the edge
     * @param dest : Vertex, vertex dest of the edge
     */
    public void addEdge(Vertex src, Vertex dest) {
        edges.add(new Edge(src, dest));
        vertices.add(src);
        vertices.add(dest);
    }

    /**
     * Remove an edge from the graph
     * @param edge : Edge, edge to remove
     */
    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    /**
     * Remove a vertex from the graph
     * @param vertex : Vertex, vertex to remove
     */
    public void removeVertex(Vertex vertex) {
        vertices.remove(vertex);
    }

    /**
     * Get the i edge from the graph
     * @param i : int, index of the edge
     * @return i edge
     */
    public Edge getEdge(int i) {
        return edges.get(i);
    }


    // Use for debug
    public void printGraph() {
        for (Edge e : edges) {
            System.out.println(e);
        }
    }

    // Use for debug
    public void printNodes() {
        for (Vertex n : vertices) {
            System.out.print(n+" ");
        }
        System.out.println();
    }

}
