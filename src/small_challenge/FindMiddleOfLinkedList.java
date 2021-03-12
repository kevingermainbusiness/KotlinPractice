package small_challenge;

import interfaces.NotFullyUnderstoodYet;
import small_challenge.data._LinkedList;

/**
 * Java program to find middle element of linked list in one pass.
 * In order to find middle element of a linked list
 * we need to find the length first but since we can only
 * traverse linked list one time, we will have to use two pointers
 * one which we will increment on each iteration while
 * other which will be incremented every second iteration.
 * So when the first pointer will point to the end of a
 * linked list, second will be pointing to the middle
 * element of a linked list
 *
 * @author Javin Paul
 * Made some structural modifications - Signed Kevin Germain
 */

@NotFullyUnderstoodYet(reason = "Having some issues understanding how the nodes point to one another")
public class FindMiddleOfLinkedList {

    public static void main(String[] args) {
        //creating _LinkedList with 6 elements including head
        _LinkedList linkedList = new _LinkedList();
        linkedList.addNode(new _LinkedList.Node("1"));
        linkedList.addNode(new _LinkedList.Node("2"));
        linkedList.addNode(new _LinkedList.Node("3"));
        linkedList.addNode(new _LinkedList.Node("4"));
        linkedList.addNode(new _LinkedList.Node("5"));
        linkedList.addNode(new _LinkedList.Node("6"));

        _LinkedList.Node currentLinkedNode = linkedList.getHead();
        _LinkedList.Node middleNodeOfLinkedList = currentLinkedNode;
        int nodePosition = 0;

        while (currentLinkedNode.getNext() != null) {
            nodePosition++; // increments until last currentLinkedNode.getNext() returns null
            if (nodePosition % 2 == 0) {
                middleNodeOfLinkedList = middleNodeOfLinkedList.getNext();
            }
            currentLinkedNode = currentLinkedNode.getNext();
        }

        if (nodePosition % 2 == 1) {
            middleNodeOfLinkedList = middleNodeOfLinkedList.getNext();
        }

        System.out.println("Amount of nodes in LinkedList: " + nodePosition);
        System.out.println("Middle node of LinkedList : " + middleNodeOfLinkedList);
    }
}
