package bfs;

public class App {
    public static void main(String[] args) {
        System.out.println("BFS");

        Graph graph = new Graph();

        // add nodes
        graph.addNode(new Node(0, 1));
        graph.addNode(new Node(1, 2));
        graph.addNode(new Node(2, 3));
        graph.addNode(new Node(3, 4));

        // add Edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);

        Bfs.bfs(graph, 0);

        String pathFrom0To3 = Bfs.getPath(graph, graph.getNode(0), graph.getNode(3));

        System.out.println(pathFrom0To3);
    }
}