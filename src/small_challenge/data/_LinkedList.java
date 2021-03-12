package small_challenge.data;

/**
 * Custom LinkedList recreated by me
 *
 * @author Kevin Germain
 */
public class _LinkedList {
    private final Node head;
    private Node tail;

    public _LinkedList() {
        this.head = new Node("_head");
        this.tail = head;
    }

    public Node getHead() {
        return head;
    }

    public void addNode(Node node) {
        tail.setNext(node);
        tail = node;
    }

    /**
     * Data class to add and get new Nodes to [_LinkedList]
     */
    public static final class Node {
        private Node next;
        private final String data;

        public Node(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return this.data;
        }
    }
}
