package fr.istic.m1.se.projet.Karger;

import fr.istic.m1.se.projet.graph.Edge;
import fr.istic.m1.se.projet.graph.Graph;
import fr.istic.m1.se.projet.graph.Node;

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
                //System.out.println("merge "+ edge);
                merge(edge);
            }
        }
        int i=0;
        while (i<graph.getNbEdges()) {
            Edge e = graph.getEdge(i);
            if (e.isSelfLoop()) removeSelfLoop(e);
            else i++;
        }
        return graph.getNbEdges();
    }

    private void merge(Edge e) {
        graph.removeEdge(e);
        Node src = e.getN1();
        Node dest = e.getN2();
        dest.rename(src.getName()+dest.getName());
        for (int i=0; i<graph.getNbEdges(); i++) {
            Edge ed = graph.getEdge(i);
            if (src.equals(ed.getN1()) || src.equals(ed.getN2())) {
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
