package QueueDS.DeQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Implimentation {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // Insert at rear
        deque.addLast(10);
        deque.addLast(20);

        // Insert at first
        deque.addFirst(5);

        System.out.println("Deque after insertions: " + deque);

        // Remove From front
        int front = deque.removeFirst();
        System.out.println("Removed from front: " + front);

        // Remove from rear
        int rear = deque.removeLast();
        System.out.println("Removed from rear: " + rear);

        //Peek front and rear
        System.out.println("Front element: " + deque.peekFirst());
        System.out.println("Rear element: " + deque.peekLast());
    }
}
