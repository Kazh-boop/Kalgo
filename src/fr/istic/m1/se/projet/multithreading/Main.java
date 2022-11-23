package fr.istic.m1.se.projet.multithreading;

import fr.istic.m1.se.projet.karger.Karger;
import fr.istic.m1.se.projet.graph.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Graph g = new Graph();
        if (args.length != 1) {
            System.err.println("Error argument. It has to be 1 or 2 or 3");
            System.exit(-1);
        }
        if (Integer.parseInt(args[0]) == 1) {
            /*
            for (int i=0;i<200;i++) {
                g.addEdge(getRandomInt(), getRandomInt());
            }*/


            g.addEdge(1, 2); // a
            g.addEdge(1, 3); // b
            g.addEdge(1, 4); // c
            g.addEdge(2, 4); // d
            g.addEdge(3, 4); // e

        }
        else if (Integer.parseInt(args[0]) == 2) {

            g.addEdge(1, 2);
            g.addEdge(2, 3);
            g.addEdge(3, 4);
            g.addEdge(4, 5);
            g.addEdge(5, 6);
            g.addEdge(6, 7);
            g.addEdge(7, 8);
            g.addEdge(8, 1);

            g.addEdge(1, 7);
            g.addEdge(2, 7);
            g.addEdge(3, 6);
            g.addEdge(3, 4);
            g.addEdge(4, 5);

        } else if (Integer.parseInt(args[0]) == 3) {

            g.addEdge(1, 2);
            g.addEdge(1, 3);
            g.addEdge(1, 4);
            g.addEdge(2, 3);
            g.addEdge(2, 5);
            g.addEdge(2, 6);
            g.addEdge(2, 4);
            g.addEdge(3, 7);
            g.addEdge(4, 6);
            g.addEdge(5, 7);
            g.addEdge(5, 8);
            g.addEdge(6, 7);
            g.addEdge(6, 8);
            g.addEdge(7, 8);

        }
        else if (Integer.parseInt(args[0]) == 4) {

            for (int i=0;i<100;i++) {
                g.addEdge(getRandomInt(), getRandomInt());
            }
        }
        else {
            System.err.println("Error argument. It has to be 1 or 2 or 3");
            System.exit(-1);
        }

        g.printGraph();
        System.out.println();
        int mini = 100000000;
        for (int i=0; i<10;i++) {
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
            //thread1.join();

            /*System.out.println("mincut thread 1 : " + karger1.getMincut());
            System.out.println("mincut thread 2 : " + karger2.getMincut());
            System.out.println("mincut thread 3 : " + karger3.getMincut());
            System.out.println("mincut thread 4 : " + karger4.getMincut());*/
            //mini = karger1.getMincut();
            mini = minimum(karger1.getMincut(), karger2.getMincut(), karger3.getMincut(), karger4.getMincut(), mini);
        }
        System.out.print("mincut of graph g is : "+mini);
    }

    public static int minimum(int a, int b, int c, int d) {
        int mini;
        mini = Math.min(a,b);
        mini = Math.min(mini, c);
        mini = Math.min(mini, d);
        return mini;
    }

    public static int minimum(int a, int b, int c, int d, int e) {
        int mini;
        mini = Math.min(a,b);
        mini = Math.min(mini, c);
        mini = Math.min(mini, d);
        mini = Math.min(mini, e);
        return mini;
    }

    public static Integer getRandomInt() {
        return ((int) (Math.random() * 25)) +1;
    }

}