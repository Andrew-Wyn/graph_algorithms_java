package bfs;

import java.util.*;

public class Bfs {

    public static void bfs(Graph G, int sIdx) {
        
        Node s = G.getNode(sIdx);

        s.setState(State.OPEN);
        s.setD(0);
        s.setPi(null);

        Queue<Node> queue = new Queue<>();

        queue.enqueue(s);

        while (!queue.isEmpty()) {
            Node u = queue.dequeue();

            List<Node> uAdj = u.getSuccessors();

            for (Node v : uAdj) {
                if (v.getState().equals(State.FRESH)) {
                    v.setState(State.OPEN);
                    v.setD(u.getD() + 1);
                    v.setPi(u);
                    queue.enqueue(v);
                }
            }
            u.setState(State.CLOSED);
        }

    }

    public static String getPath(Graph G, Node v, Node u) {
        String out = "";
        return getPath(G, v, u, out) + " ]";
    }

    private static String getPath(Graph G, Node v, Node u, String out) {
        if (v.equals(u)) {
            return out +=  "[ " + v.getId();
        } else if (u.getPi() == null) {
            return "None";
        } else {
            out += getPath(G, v, u.getPi(), out) + " ";
            return out += u.getId();
        }
    }
}
