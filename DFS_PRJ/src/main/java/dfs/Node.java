package dfs;

import java.util.*;

public class Node implements GraphNodeIface<Integer> {
    
    private int id;
    private Integer value;
    private List<GraphNodeIface> successors;
    private State state;
    private int initTimer;
    private int endTimer;

    public Node(int id, int value) {
        this.id = id;
        this.value = value;
        this.successors = new ArrayList<>();
        this.state = State.FRESH;
        this.initTimer = 0;
        this.endTimer = 0;
    }

    public void setSuccessors(List<GraphNodeIface> successors) {
        this.successors = successors;
    }

    // interface methods

    public int getId(){
        return this.id;
    }

    public List<GraphNodeIface> getSuccessors() {
        return successors;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void setInitTimer(int initTimer) {
        this.initTimer = initTimer;
    }

    public int getInitTimer() {
        return this.initTimer;
    }

    public void setEndTimer(int endTimer) {
        this.endTimer = endTimer;
    }

    public int getEndTimer() {
        return this.endTimer;
    }

    @Override
    public String toString() {
        return "Node (ID: " + id + ")\nVALUE: " + value + "\nSTATE: " + state + "\nTimer: " + initTimer + " - " + endTimer;
    }

    // due nodi sono lo stesso se hanno lo stesso id
    @Override
    public int compareTo(Object x) {

        if(x == null) throw new NullPointerException();
  
        if(!(x instanceof Node)) throw new ClassCastException();
            
        Node node = (Node) x;

        return Integer.compare(id, node.getId());
    }
}