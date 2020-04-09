package binsearchtree;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();

        List<Node<Integer>> nodes = new ArrayList<>();

        nodes.add(new Node<Integer>(2));
        nodes.add(new Node<Integer>(1));
        nodes.add(new Node<Integer>(3));
        nodes.add(new Node<Integer>(-2));
        nodes.add(new Node<Integer>(0));
        nodes.add(new Node<Integer>(31));

        for (Node<Integer> n : nodes) {
            tree.insert(n);
        }

        tree.inorderVisit();
        tree.delete(nodes.get(1));
        tree.inorderVisit();
    }

}
