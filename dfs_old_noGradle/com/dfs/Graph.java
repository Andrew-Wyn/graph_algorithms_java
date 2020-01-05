package com.dfs;

import java.util.*;

import com.dfs.GraphNodeIface;

// memorizzazione grafo tramite liste di adiacenza

public class Graph implements GraphIface<Integer> {

    private List<GraphNodeIface> listaAdj;

    public Graph(List<GraphNodeIface> listaAdj) {
        this.listaAdj = listaAdj;
    }

    // interface methods

    public void addEdge(int from, int to) {

        if (listaAdj.get(from) != null && listaAdj.get(to) != null && !listaAdj.get(from).getSuccessors().contains(listaAdj.get(to))) {            
            listaAdj.get(from).getSuccessors().add(listaAdj.get(to));
        }
    }

    public int getEdgeCount() {
        int out = 0;

        for (GraphNodeIface node : listaAdj) {
            out += node.getSuccessors().size();
        }

        return out;
    }

    public GraphNodeIface getNode(int id) {
        return listaAdj.get(id);
    }

    public int getVertexCount() {
        return listaAdj.size();
    }

    public void removeEdge(int from, int to) {
        if (listaAdj.get(from) != null) {
            listaAdj.get(from).getSuccessors().remove(listaAdj.get(to));
        }
    }

    @Override
    public String toString() {
        String out = "NODI:  ";

        for (GraphNodeIface node : listaAdj) {
            out += "\n" + node;
        }

        out += "\n\nEDGES:  ";

        for (GraphNodeIface node : listaAdj) {
            List<GraphNodeIface> successors = node.getSuccessors();

            for (GraphNodeIface succ : successors) {
                out += "\nfrom: " + node.getId() + " to: " + succ.getId();
            }
        }

        return out;
    }
}