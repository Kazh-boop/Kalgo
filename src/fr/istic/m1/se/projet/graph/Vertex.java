package fr.istic.m1.se.projet.graph;

/**
 * Representation of vertex in a Graph
 */
public class Vertex {

    /**
     * id of the vertex
     */
    private final int id;

    /**
     * Name of the vertex
     */
    private String name;

    /**
     * Use to generate id
     */
    private static int counter = 0;

    /**
     * Constructor to instantiate a vertex with a name
     * @param name : String, name of the vertex
     */
    public Vertex(String name) {
        this.id = counter++;
        this.name = name;
    }

    /**
     * Constructor to instantiate a vertex where the name take the value of id
     */
    public Vertex() {
        this.id = counter++;
        this.name = String.valueOf(id);
    }

    /**
     * Constructor to copy
     * @param v : Vertex, vertex to copy
     */
    public Vertex(Vertex v) {
        this.id = v.id;
        this.name = v.name;
    }

    /**
     * Get the name of the vertex
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * change the name of the graph
     * @param n : String, new name of the graph
     */
    public void rename(String n) { this.name = n; }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id || name.equals(vertex.name);
    }

}
