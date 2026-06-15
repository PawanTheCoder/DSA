package Linked_List.Implimentation;

public class LinkedList {
    private Node head;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at begining
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        newNode.next  = head;
        head = newNode;

        size++;
    }

    // Insert at end
    public void insertAtEnd(int data){
        Node newNode = new Node(data);

        // Linked List is empty
        if(head == null){
            head = newNode;
            size++;
            return;
        }

        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        size++;
    }

    // Insert at position 
    public void insertAtPosition(int index, int data) {

        if (index < 0|| index > size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node curr = head;

        for(int i =0; i < index - 1 ; i++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        size++;
    }

    // Delete First Node
    public void deleteFirst() {
        if(head == null) {
            return;
        }

        head = head.next;
        size--;
    }

    // Delete Last Node
    public void deleteLast() {
        if(head == null) {
            return;
        }

        if(head.next == null) {
            head = null;
            size--;
            return;
        }

        Node curr = head;

        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = null;
        size--;
    }

    // Delete By Value
    public void deleteByValue(int value) {
        if(head == null) {
            return;
        }

        if(head.data == value) {
            head = head.next;
            size--;
            return;
        }

        Node curr = head;
        while(curr.next != null && curr.next.data != value) {
            curr = curr.next;
        }

        if(curr.next != null) {
            curr.next = curr.next.next;
            size--;
        }
    }

    // Search
    public boolean contains(int value) {
        Node curr = head;

        while(curr != null) {
            if(curr.data == value) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }

    // Get node at index
    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node curr = head;

        for(int i =0; i < index; i ++) {
            curr = curr.next;
        }

        return curr.data;
    }

    // Reverse List
    public void reverse() {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev  = curr;
            curr = next;
        }

        head = prev;
    }

    // Dispaly 
    public void display() {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + "-> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    // size
    public int size() {
        return size;
    }

    // Empty 
    public boolean isEmpty() {
        return size == 0;
    }

    public Node getHead() {
        return head;
    }
}
