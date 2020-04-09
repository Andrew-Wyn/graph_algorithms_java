package binsearchtree;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Node<TKEY extends Comparable<TKEY>>{

    /*
        Classe node rappresenta i nodi dell'albero
    */

    private TKEY key;
    private Node<TKEY> piNode;
    private Node<TKEY> leftNode;
    private Node<TKEY> rightNode;

    public Node(TKEY key) {
        this.piNode = null;
        this.leftNode = null;
        this.rightNode = null;
        this.key = key;
    }
}