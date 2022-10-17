import fr.istic.m1.se.projet.graph.*;
import fr.istic.m1.se.projet.sequential.Karger;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph();

        Node zero = new Node();
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();

        g.addEdge(zero, one); // a
        g.addEdge(zero, two); // b
        g.addEdge(zero, three); // c
        g.addEdge(one, three); // d
        g.addEdge(two, three); // e

        /*
        Node zero = new Node(), one = new Node(), two=new Node(), three= new Node(), four=new Node(), five=new Node(), six=new Node(), seven=new Node();

        g.addEdge(zero, one);
        g.addEdge(one, two);
        g.addEdge(two,three);
        g.addEdge(three, four);
        g.addEdge(four, five);
        g.addEdge(five, six);
        g.addEdge(six, seven);
        g.addEdge(seven, zero);

        g.addEdge(zero, six);
        g.addEdge(one, six);
        g.addEdge(two, five);
        g.addEdge(two, four);
        g.addEdge(three, five);
        */

        Karger k = new Karger(g);
        int mincut = k.run();
        System.out.println("mincut of graph g is : "+mincut);

    }
}