package small_java_challenge.data;

import interfaces.NotFullyUnderstoodYet;

/**
 * A class to represent singly list in Java
 *
 * @author WINDOWS 8
 */
@NotFullyUnderstoodYet(reason = "I don't understand nada yet in this implementation")
public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int data() {
            return data;
        }

        public Node next() {
            return next;
        }
    }

    /**
     * Java method to add a Node to a linked list
     *
     * @param node refers to the node being added
     */
    public void add(Node node) {
        Node current = head;
        while (current != null) {
            if (current.next == null) {
                current.next = node;
                break;
            }
            current = current.next;
        }
    }

    /**
     * Java method to print a singly linked list
     */
    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data() + " ");
            node = node.next();
        }
        System.out.println("");
    }

    /**
     * Java method to reverse a linked list without recursion
     */
    public void reverse() {
        Node pointer = head;
        Node previous = null, current;
        while (pointer != null) {
            current = pointer;
            pointer = pointer.next; // reverse the link
            current.next = previous;
            previous = current;
            head = current;
        }
    }
}