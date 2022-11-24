package fr.istic.m1.se.projet.graph;

/**
 * Representation of an edge in the class Graph
 */
public class Edge {

    /**
     * Vertices which compose the edge
     */
    private Vertex src, dest;

    /**
     * Constructor
     * @param src : Vertex
     * @param dest : Vertex
     */
    public Edge(Vertex src, Vertex dest) {
        this.src = src;
        this.dest = dest;
    }

    /**
     * Get the vertex src
     * @return src
     */
    public Vertex getSrc() {
        return src;
    }

    /**
     * Get the vertex dest
     * @return dest
     */
    public Vertex getDest() {
        return dest;
    }

    /**
     * Check if the edge is a self loop
     * @return true if edge is a self loop, else false
     */
    public boolean isSelfLoop() {
        return src.equals(dest);
    }

    /**
     * Change one of the vertices with a new one
     * @param old : Vertex, vertex to change
     * @param neo : Vertex, new vertex of the edge
     */
    public void replaceVertex(Vertex old, Vertex neo) {
        if (old.equals(src)) src = neo;
        else dest = neo;
    }

    @Override
    public String toString() {
        return src +" --- "+ dest;
    }

}
