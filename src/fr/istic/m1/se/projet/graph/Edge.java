package fr.istic.m1.se.projet.graph;

public class Edge {

    private Integer src, dest;

    public Edge(Integer src, Integer dest) {
        this.src = src;
        this.dest = dest;
    }

    public Edge(Edge e) {
        this.src = e.getSrc();
        this.dest = e.getDest();
    }

    public Integer getSrc() {
        return src;
    }

    public Integer getDest() {
        return dest;
    }

    public boolean isSelfLoop() {
        return src.equals(dest);
    }

    public void replaceNode(Integer old, Integer neo) {
        if (old.equals(src)) src = neo;
        else dest = neo;
    }

    @Override
    public String toString() {
        return src+" --- "+dest;
    }

}
