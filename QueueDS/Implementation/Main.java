package QueueDS.Implementation;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(10);
        
        // Add Operations
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        // Display Operation
        q.display();

        // Delete Operations
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.display();

        System.out.println(q.peek());

        System.out.println(q.isEmpty());
    }
}
