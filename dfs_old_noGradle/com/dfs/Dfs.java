package com.dfs;

import java.util.*;


public class Dfs {

    /**
    * Not discovered node
    */
    private static final int FRESH = 0;
    /**
    * Open node
    */
    private static final int OPEN = 1;
    /**
    * Closed node
    */
    private static final int CLOSED = 2;

    private static int timer = 0;

    private static List<Edge> copertureTree = new ArrayList<>();
    private static List<Edge> backwardTree =  new ArrayList<>();
    private static List<Edge> forwardTree = new ArrayList<>();
    private static List<Edge> crossTree = new ArrayList<>();

    /**
    * Recursive form of depth-first search
    *
    * @param graph
    */
    public static void depthFirstSearch(GraphIface graph) {
        //perform depth first search of all connected components
        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (graph.getNode(i).getState().equals(State.FRESH)) {
                doDFS(graph, i);
            }
        }
    }

    /**
    * Perform depth-first search
    *
    * @param graph graph
    * @param vertexNr node identifier
    * @param state array of node states
    */

    // non serve il controllo del padre (quindi non lo memorizzo), in quando dfs su grafo orientato

    private static void doDFS(GraphIface graph, int vertexNr) {
        GraphNodeIface u = graph.getNode(vertexNr);
        
        u.setState(State.OPEN);

        u.setInitTimer(++timer);
        
        List<GraphNodeIface> succ = graph.getNode(vertexNr).getSuccessors();
        for (GraphNodeIface n : succ) {

            Edge edge = new Edge(vertexNr, n.getId());

            if (n.getState().equals(State.FRESH)) {
                doDFS(graph, n.getId());
                copertureTree.add(edge);
            } else {
                if (n.getState().equals(State.OPEN)) {
                    backwardTree.add(edge);
                } else {
                    if (u.getInitTimer() < n.getInitTimer()) {
                        forwardTree.add(edge);
                    } else {
                        crossTree.add(edge);
                    }
                }
            }
        }
        graph.getNode(vertexNr).setState(State.CLOSED);
    }

    // only debug purpose 
    private static void printStates(int[] state) {
        for (int i = 0; i < state.length; i++) {
            System.out.print(state[i] + " ");
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("***** DFS *****");

        List<GraphNodeIface> listaAdj = new ArrayList<>();

        listaAdj.add(new Node(0, 1));
        listaAdj.add(new Node(1, 2));
        listaAdj.add(new Node(2, 3));
        listaAdj.add(new Node(3, 4));

        Graph graph = new Graph(listaAdj);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.addEdge(1, 3);

        depthFirstSearch(graph);

        System.out.println(graph+"\n\n");
        System.out.println(copertureTree);
        System.out.println(backwardTree);
        System.out.println(forwardTree);
        System.out.println(crossTree);

    }

}