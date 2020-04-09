package dfs;

import java.util.*;

// memorizzazione grafo tramite liste di adiacenza

public class Graph implements GraphIface<Integer> {

    private List<GraphNodeIface<Integer>> listaAdj;

    public Graph(List<GraphNodeIface<Integer>> listaAdj) {
        this.listaAdj = listaAdj;
    }

    // interface methods

    public void addEdge(int from, int to) {

        if (listaAdj.get(from) != null && listaAdj.get(to) != null && !listaAdj.get(from).getSuccessors().contains(listaAdj.get(to))) {            
            listaAdj.get(from).getSuccessors().add(listaAdj.get(to));
            Collections.sort(listaAdj.get(from).getSuccessors());
        }
    }

    public int getEdgeCount() {
        int out = 0;

        for (GraphNodeIface<Integer> node : listaAdj) {
            out += node.getSuccessors().size();
        }

        return out;
    }

    public GraphNodeIface<Integer> getNode(int id) {
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

        for (GraphNodeIface<Integer> node : listaAdj) {
            out += "\n" + node;
        }

        out += "\n\nEDGES:  ";

        for (GraphNodeIface<Integer> node : listaAdj) {
            List<GraphNodeIface<Integer>> successors = node.getSuccessors();

            for (GraphNodeIface<Integer> succ : successors) {
                out += "\nfrom: " + node.getId() + " to: " + succ.getId();
            }
        }

        return out;
    }
}