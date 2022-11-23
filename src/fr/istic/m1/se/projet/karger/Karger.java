package fr.istic.m1.se.projet.karger;

import fr.istic.m1.se.projet.graph.Edge;
import fr.istic.m1.se.projet.graph.Graph;

public class Karger implements Runnable {

    private Graph graph;

    private int mincut;


    public Karger(Graph graph) {
        this.graph = new Graph(graph);
        this.mincut = -1;
    }

    @Override
    public void run() {
        this.mincut = findMinCut();
    }

    public int getMincut() {
        return mincut;
    }

    private int findMinCut() {
        while (graph.getNbNodes() > 2) {
            int i = getRandomNumber();
            Edge edge = graph.getEdge(i);
            if (edge.isSelfLoop()) {
                removeSelfLoop(edge);
            } else {
                //System.out.println("merge : "+edge);
                merge(edge);
                //graph.printGraph();
            }
        }
        int i=0;
        while (i<graph.getNbEdges()) {
            Edge e = graph.getEdge(i);
            if (e.isSelfLoop()) removeSelfLoop(e);
            else i++;
        }
        //graph.printGraph();
        //graph.printNodes();
        //System.out.println();
        return graph.getNbEdges();
    }

    private void merge(Edge e) {
        graph.removeEdge(e);
        Integer src = e.getSrc();
        Integer dest = e.getDest();
        for (int i=0; i<graph.getNbEdges(); i++) {
            Edge ed = graph.getEdge(i);
            if (src.equals(ed.getSrc())) {
                ed.replaceNode(src, dest);
            }
            if (src.equals(ed.getDest())) {
                ed.replaceNode(src, dest);
            }
        }
        graph.removeNode(src);
    }

    private void removeSelfLoop(Edge e) {
        graph.removeEdge(e);
    }

    private int getRandomNumber() {
        return ((int)(Math.random()*10)) % graph.getNbEdges();
    }

}
