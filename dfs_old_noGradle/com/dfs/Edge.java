package com.dfs;

public class Edge {
    private int from;
    private int to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getFrom() {
        return this.from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTo() {
        return this.to;
    }

    @Override
    public String toString() {
        return "from: " + this.from + " to: " + this.to; 
    }
}