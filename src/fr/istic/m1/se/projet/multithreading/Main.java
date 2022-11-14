package fr.istic.m1.se.projet.multithreading;

import fr.istic.m1.se.projet.Karger.Karger;
import fr.istic.m1.se.projet.graph.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Graph g = new Graph();
        if (args.length != 1) {
            System.err.println("Error argument. It has to be 1 or 2 or 3");
            System.exit(-1);
        }
        if (Integer.parseInt(args[0]) == 1) {
            Node zero = new Node();
            Node one = new Node();
            Node two = new Node();
            Node three = new Node();

            g.addEdge(zero, one); // a
            g.addEdge(zero, two); // b
            g.addEdge(zero, three); // c
            g.addEdge(one, three); // d
            g.addEdge(two, three); // e

        } else if (Integer.parseInt(args[0]) == 2) {
            Node zero = new Node(), one = new Node(), two = new Node(), three = new Node(), four = new Node(), five = new Node(), six = new Node(), seven = new Node();

            g.addEdge(zero, one);
            g.addEdge(one, two);
            g.addEdge(two, three);
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

        } else if (Integer.parseInt(args[0]) == 3) {
            Node zero = new Node(), one = new Node(), two=new Node(), three= new Node(), four=new Node(), five=new Node(), six=new Node(), seven=new Node();

            g.addEdge(zero, one);
            g.addEdge(zero, two);
            g.addEdge(zero,three);
            g.addEdge(one, two);
            g.addEdge(one, four);
            g.addEdge(two, five);
            g.addEdge(two, three);
            g.addEdge(three, six);
            g.addEdge(four, five);
            g.addEdge(four, six);
            g.addEdge(four, seven);
            g.addEdge(five, six);
            g.addEdge(five, seven);
            g.addEdge(six, seven);

        } else {
            System.err.println("Error argument. It has to be 1 or 2 or 3");
            System.exit(-1);
        }

        Karger karger1 = new Karger(g);
        Karger karger2 = new Karger(g);
        Karger karger3 = new Karger(g);
        Karger karger4 = new Karger(g);

        Thread thread1 = new Thread(karger1, "Thread 1");
        Thread thread2 = new Thread(karger2, "Thread 2");
        Thread thread3 = new Thread(karger3, "Thread 3");
        Thread thread4 = new Thread(karger4, "Thread 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        int mini = minimum(karger1.getMincut(), karger2.getMincut(), karger3.getMincut(), karger4.getMincut());

        System.out.println("mincut of graph g is : "+mini);
    }

    public static int minimum(int a, int b, int c, int d) {
        int mini;
        mini = Math.min(a,b);
        mini = Math.min(mini, c);
        mini = Math.min(mini, d);
        return mini;
    }

}