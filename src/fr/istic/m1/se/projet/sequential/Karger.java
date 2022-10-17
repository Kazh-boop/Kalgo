package fr.istic.m1.se.projet.sequential;

import fr.istic.m1.se.projet.graph.*;

public class Karger {

    private Graph graph;

    public Karger(Graph graph) {
        this.graph = graph;
    }

    public int run() {
        return getMinCut();
    }

    private int getMinCut() {
        while (graph.getNbNodes() > 2) {
            int i = getRandomNumber();
            Edge edge = graph.getEdge(i);
            if (edge.isSelfLoop()) {
                removeSelfLoop(edge);
            } else {
                // System.out.println("merge "+ edge);
                merge(edge);
            }
        }
        return graph.getNbEdges();
    }

    private void merge(Edge e) {
        graph.removeEdge(e);
        Node src = e.getN1();
        Node dest = e.getN2();
        dest.rename(src.getName()+dest.getName());
        for (int i=0; i < graph.getNbEdges(); i++) {
            Edge ed = graph.getEdge(i);
            if (src.equals(ed.getN1()) || src.equals(ed.getN2())) {
                ed.replaceNode(src, dest);
            }
            if (ed.isSelfLoop()) removeSelfLoop(ed);
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
