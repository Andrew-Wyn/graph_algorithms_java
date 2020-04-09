package binsearchtree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tree<TKEY extends Comparable<TKEY>> {
    /*
        Tree class to rappresent Tree
    */

    private Node<TKEY> root;

    public Tree() {
        this.root = null;
    }

    private void transplant(Node<TKEY> u, Node<TKEY> v) {
        if (u.getPiNode() == null) {
            this.root = v;
        } else if (u == u.getPiNode().getLeftNode()) {
            u.getPiNode().setLeftNode(v);
        } else {
            u.getPiNode().setRightNode(v);
        }

        if (v != null) {
            v.setPiNode(u.getPiNode());
        }
    }


    public Node<TKEY> delete(Node<TKEY> toDelete) {
        if (toDelete.getLeftNode() == null) {
            transplant(toDelete, toDelete.getRightNode());
        } else if (toDelete.getRightNode() == null) {
            transplant(toDelete, toDelete.getLeftNode());
        } else {
            Node<TKEY> y = getMin(toDelete);
            if (y.getPiNode().getKey().compareTo(toDelete.getKey()) != 0) {
                transplant(y, y.getRightNode());
                y.setRightNode(toDelete.getRightNode());
                y.getRightNode().setPiNode(y);
            }
            transplant(toDelete, y);
            y.setLeftNode(toDelete.getLeftNode());
            y.getLeftNode().setPiNode(y);
        }
        return toDelete;
    }

    public void inorderVisit() {
        inorderVisit(this.root);
    }

    private void inorderVisit(Node<TKEY> iterator) {
        if (iterator != null) {
            inorderVisit(iterator.getLeftNode());
            System.out.println(iterator.getKey());
            inorderVisit(iterator.getRightNode());
        }
    }


    public Node<TKEY> insert(Node<TKEY> toInsert) {
        Node<TKEY> iterator = this.root;
        Node<TKEY> pred = null;
    
        if (iterator == null) {
            this.root = toInsert;
        } else {
            while (iterator != null) {
                pred = iterator;
                if (iterator.getKey().compareTo(toInsert.getKey()) > 0) {
                    iterator = iterator.getLeftNode();
                } else {
                    iterator = iterator.getRightNode();
                }
            }

            if (toInsert.getKey().compareTo(pred.getKey()) > 0) {
                pred.setRightNode(toInsert);
            } else {
                pred.setLeftNode(toInsert);
            }

            toInsert.setPiNode(pred);

        }
    
        return toInsert;
    }


    public Node<TKEY> search(Node<TKEY> toSearch) {
        return search(this.root, toSearch);
    }

    private Node<TKEY> search(Node<TKEY> iterator, Node<TKEY> toSearch) {
        if (toSearch == null || iterator.getKey().compareTo(toSearch.getKey()) == 0) {
            return iterator;
        } else {
            if (iterator.getKey().compareTo(toSearch.getKey()) > 0) { // iterator maggiore di toSearch devo ricorrere sulla sinistra su elementi minori
                return search(iterator.getLeftNode(), toSearch);
            } else {
                return search(iterator.getRightNode(), toSearch);
            }
        }
    }

    // MIN
    public Node<TKEY> getMin() {
        return getMin(this.root);
    }

    private Node<TKEY> getMin(Node<TKEY> iterator) {
        if (iterator.getLeftNode() == null) {
            return iterator;
        }
        return getMin(iterator.getLeftNode());
    }


    // MAX
    public Node<TKEY> getMax() {
        return getMax(this.root);
    }

    private Node<TKEY> getMax(Node<TKEY> iterator) {
        if (iterator.getRightNode() == null) {
            return iterator;
        }
        return getMin(iterator.getRightNode());
    }

}