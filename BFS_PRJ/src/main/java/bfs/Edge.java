package bfs;

import lombok.*;

@Getter
@Setter
public class Edge {
    private int from;
    private int to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "from: " + this.from + " to: " + this.to; 
    }
}