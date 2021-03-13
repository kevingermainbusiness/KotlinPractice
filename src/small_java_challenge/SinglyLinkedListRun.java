package small_java_challenge;

import interfaces.NotFullyUnderstoodYet;
import small_java_challenge.data.SinglyLinkedList;

@NotFullyUnderstoodYet(reason = "I don't yet understand the way the SinglyLinkedList class is implemented")
public class SinglyLinkedListRun {
    public static void main(String[] args) {
        // creating a singly linked list
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(1);
        SinglyLinkedList linkedList = new SinglyLinkedList(head);
        // adding node into singly linked list
        linkedList.add(new SinglyLinkedList.Node(2));
        linkedList.add(new SinglyLinkedList.Node(3));
        // printing a singly linked list
        linkedList.print();
        // reversing the singly linked list
        linkedList.reverse();
        // printing the singly linked list again
        linkedList.print();
    }

}
