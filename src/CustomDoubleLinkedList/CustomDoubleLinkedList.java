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
public class CustomDoubleLinkedList<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;
    
    public void addAtHead(E data) {
        if(size == 0) {
            head = new Node(data);
            tail = head;
        } else {
            Node<E> newNode = new Node(data);
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size = size + 1;
    }
    
    public void addAtTail(E data) {
        if(size == 0) {
            tail = new Node(data);
            head = tail;
        } else {
            Node<E> newNode = new Node(data);
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size = size + 1;
    }
    
    
    public void addAtIndex(int index, E data) {
        if(index == 0) {
            addAtHead(data);
        } else if(index == size - 1) {
            addAtTail(data);
        } else {
            Node previous = null;
            Node current = null;
            Node ref = head;
            
            for(int i = 0 ; i < size ; i++) {
                if(i == index - 1) {
                    previous = ref;
                }
                if(i == index) {
                    current = ref;
                    Node<E> newNode = new Node(data);
                    
                    previous.next = newNode;
                    newNode.previous = previous;
                    
                    current.previous = newNode;
                    newNode.next = current;
                    
                    size = size + 1;
                    break;
                }
                ref = ref.next;
            }
        }
    }
    
    public void deleteHead() {
        Node<E> temp = head.next;
        head.next = null;
        temp.previous = null;
        head = temp;
        size = size - 1;
        
        if(size == 1) {
            tail = head;
        }
    }
    
    public void deleteTail() {
        Node<E> temp = tail.previous;
        tail.previous = null;
        temp.next = null;
        tail = temp;
        size = size - 1;
        
        if(size == 1) {
            head = tail;
        }
    }
    
    public void deleteIndex(int index) {
        if(index == 0) {
            deleteHead();
        } else if(index == size - 1) {
            deleteTail();
        } else {
            Node<E> previous = null;
            Node<E> current = null;
            Node<E> ref = head;
            
            for(int i = 0 ; i < size ; i++) {
                if(i == index - 1) {
                    previous = ref;
                }
                if(i == index) {
                    current = ref;
                    
                    previous.next = current.next;
                    current.next.previous = previous;
                    
                    current.next = null;
                    current.previous = null;
                    
                    size = size - 1;
                    break;
                }
                ref = ref.next;
            }
        }
    }
    
    public E get(int index) {
        if(index == 0) {
            return head.getData();
        } else if(index == size - 1) {
            return tail.getData();
        } else {
            Node<E> current = head;
            
            for(int i = 0 ; i < size ; i++) {
                if(i == index) {
                    break;
                }
                
                current = current.next;
            }
            
            return current.getData();
        }
    }
}
