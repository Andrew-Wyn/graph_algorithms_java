package bfs;

import lombok.*;

// coda a puntatori home-made
public class Queue<NODE extends GraphNodeIface> {
    
    @Getter
    @Setter
    private class QueueNode {

        private NODE value;
        private QueueNode next;

        public QueueNode(NODE value) {
            this.value = value;
            this.next = null;
        }

    }

    private QueueNode head;
    private QueueNode tail;
    
    public Queue() {
        this.head = null;
        this.tail = null;
    }

    // aggiungo in coda
    public void enqueue(NODE toQueue) {
        QueueNode node = new QueueNode(toQueue);
        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            QueueNode appo = this.tail;
            //for (appo = head; appo.getNext() != null; appo = appo.getNext()) {}
            appo.setNext(node);

            this.tail = node;
        }
    }

    // rimuovo in testa
    public NODE dequeue() {
        if (this.head == null) {
            return null;
        } else {
            QueueNode appo = this.head;
            if (this.head == this.tail) { // singolo elemento
                this.head = this.tail = null;
                return appo.getValue();
            } else {
                this.head = this.head.getNext();
                return appo.getValue();
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}