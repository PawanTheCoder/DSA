package Linked_List.Implimentation;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.insertAtBeginning(5);

        list.display();

        list.deleteByValue(20);

        list.display();

        list.reverse();

        list.display();

        System.out.println(list.contains(30));
        System.out.println(list.get(1));
        System.out.println(list.size());
    }
}
