package bfs;

import java.util.*;


// memorizzazione grafo tramite liste di adiacenza

public class Graph implements GraphIface<Integer, Node> {

    private List<Node> listNode;

    public Graph() {
        this.listNode = new ArrayList();
    }

    // ---------------- interface methods

    public void addEdge(int from, int to) {

        if (listNode.get(from) != null && listNode.get(to) != null && !listNode.get(from).getSuccessors().contains(listNode.get(to))) {            
            listNode.get(from).getSuccessors().add(listNode.get(to));
            Collections.sort(listNode.get(from).getSuccessors());
        }
    }

    public int getEdgeCount() {
        int out = 0;

        for (Node node : listNode) {
            out += node.getSuccessors().size();
        }

        return out;
    }

    public void addNode(Node newNode){
        for (Node node : listNode) {
            if (node.equals(newNode)) {
                return;
            }
        }
        listNode.add(newNode);
    }

    // return node for his univoke id
    public Node getNode(int id) {
        for (Node node : listNode) {
            if (node.getId() == id)
                return node;
        }
        return null;
    }

    

    public int getVertexCount() {
        return listNode.size();
    }

    public void removeEdge(int from, int to) {
        if (listNode.get(from) != null) {
            listNode.get(from).getSuccessors().remove(listNode.get(to));
        }
    }

    // ----------------------------------------

    @Override
    public String toString() {
        String out = "NODI:  ";

        for (Node node : listNode) {
            out += "\n" + node;
        }

        out += "\n\nEDGES:  ";

        for (Node node : listNode) {
            List<Node> successors = node.getSuccessors();

            for (Node succ : successors) {
                out += "\nfrom: " + node.getId() + " to: " + succ.getId();
            }
        }

        return out;
    }
}