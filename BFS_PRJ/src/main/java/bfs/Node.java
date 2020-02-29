package bfs;

import lombok.*;
import java.util.*;


@Setter
@Getter
public class Node implements GraphNodeIface<Integer, Node>, Comparable<Node> {
    
    private int id;
    private Integer value;
    private List<Node> successors;
    private State state;
    private int d;
    private Node pi;
    
    public Node(int id, int value) {
        this.id = id;
        this.value = value;
        this.successors = new ArrayList<>();
        this.state = State.FRESH;
        this.d = -1;
        this.pi = null;
    }

    @Override
    public String toString() {
        return "Node (ID: " + id + ")\nVALUE: " + value + "\nSTATE: " + state + "\nD: " + d;
    }

    // due nodi sono lo stesso se hanno lo stesso id --> settare univoque Id
    @Override
    public int compareTo(Node x) {

        if(x == null) throw new NullPointerException();
              
        return Integer.compare(this.id, x.getId());
    }
}