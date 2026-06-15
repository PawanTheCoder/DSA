package Linked_List.Implimentation;

public class LinkedListImp {
    private Node head;
    private int size;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Insert at Beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        size++;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            size++;
            return ;
        }
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        size++;
    }

    // Insert at position
    public void insertAtPosition(int pos , int val) {
        if(pos < 0 || pos > size){
            return;
        }

        if(pos == 0) {
            insertAtBeginning(pos);
            return;
        }

        Node newNode = new Node(val);
        Node curr = head;
        for(int i=0; i < pos - 1 ; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    // Delete Firt Node
    public void deletFirst() {
        if(head == null) {
            System.out.println("Linked List is empty!");
            return;
        }

        head = head.next;
        size--;
    }

    // Delete Last Node
    public void deleteLast() {
        if(head == null) return;

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


    //Delete By Value
    public void deleteByValue(int val) {
        if(head == null) {
            System.out.println("Linked List is empty!");
            return;
        }

        if(head.data == val) {
            head = head.next;
            size--;
            return;
        }

        Node curr = head;
        while(curr.next != null && curr.next.data != val) {
            curr = curr.next;
        }

        if(curr.next != null) {
            curr.next = curr.next.next;
            size--;
        }
    }

    // Search
    public boolean search(int val) {
        Node curr = head;
        while(curr!= null) {
            if(curr.data == val) {
                return true;
            }
        }

        return false;
    }

    // Get Node at index
    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node curr = head;
        for(int i=0 ; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }
    // Reverse an List
    public void reverseList() {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void display() {
        if(head == null) return;

        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + "-> ");
        }
        System.out.print("null");
    }

    // Size
    public int size() {
        return size;
    }

    // isEmpty() 
    public boolean isEmpty() {
        return size == 0;
    }
}
