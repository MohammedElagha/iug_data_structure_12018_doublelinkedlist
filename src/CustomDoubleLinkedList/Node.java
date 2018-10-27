/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomDoubleLinkedList;

/**
 *
 * @author Mohammed El-Agha
 */
public class Node<E> {
    E data;
    Node next;
    Node previous;

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }
}
