package fr.istic.m1.se.projet.karger;

import fr.istic.m1.se.projet.graph.Edge;
import fr.istic.m1.se.projet.graph.Graph;
import fr.istic.m1.se.projet.graph.Vertex;

/**
 * Implementation of Karger's algorithm
 * It is a randomized algorithm to compute a minimum cut of a connected graph
 *
 * It implements Runnable to allow the use of the algorithm for multithreading
 */
public class Karger implements Runnable {

    /**
     * Graph used for the algorithm
     */
    private Graph graph;

    /**
     * minimum cut of graph which initialized to a default value
     */
    private int mincut;


    /**
     * Constructor
     * @param graph : Graph, graph to copy to avoid modification at the end of the algorithm
     */
    public Karger(Graph graph) {
        this.graph = new Graph(graph); // copy of the graph
        this.mincut = -1;
    }

    /**
     * Set mincut by launching the algorithm
     */
    @Override
    public void run() {
        this.mincut = findMinCut();
    }

    /**
     * Get the minimum cut of the graph
     * @return mincut
     */
    public int getMincut() {
        return mincut;
    }

    /**
     * Calculate the minimum cut of graph
     * @return
     */
    private int findMinCut() {
        while (graph.getNbVertices() > 2) { // continue until there are 2 vertices left in the graph
            int i = getRandomNumber();
            Edge edge = graph.getEdge(i); // select a random edge
            if (edge.isSelfLoop()) {
                graph.removeEdge(edge); // remove if self loop
            } else {
                //System.out.println("merge "+ edge);
                merge(edge); // merge else
            }
        }
        int i=0;
        while (i<graph.getNbEdges()) { // remove self loop which are still in the graph
            Edge e = graph.getEdge(i);
            if (e.isSelfLoop()) graph.removeEdge(e);
            else i++;
        }
        return graph.getNbEdges(); // minimum cut is the number of edges which are still in the graph at the end of
    }

    /**
     * Merge two vertices of the edge in parameter
     * the vertex src merge with the vertex dest
     * @param e : Edge, edge where the vertices are merge
     */
    private void merge(Edge e) {
        graph.removeEdge(e); // remove the edge from the graph
        Vertex src = e.getSrc(); // get the vertices from the graph
        Vertex dest = e.getDest();
        dest.rename(src.getName()+dest.getName()); // merge their name / use for debug
        for (int i=0; i<graph.getNbEdges(); i++) { // replace src with dest
            Edge ed = graph.getEdge(i);
            if (src.equals(ed.getSrc()) || src.equals(ed.getDest())) {
                ed.replaceVertex(src, dest);
            }
        }
        graph.removeVertex(src); // remove src from the graph
    }

    /**
     * Get a random number
     * @return random number
     */
    private int getRandomNumber() {
        return ((int)(Math.random()*100)) % graph.getNbEdges();
    }

}
