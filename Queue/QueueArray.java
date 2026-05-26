package Queue;

public class QueueArray {
    int[] arr;
    int front;
    int rear;
    int size;

    QueueArray(int size) {
        this.size = size;
        arr = new int[size];
        front = rear = -1;
    }

    // Insert element
    void enqueue(int data) {

        // Queue Full
        if(rear == size - 1) {
            System.out.println("Queue Overflow!");
            return;
        }

        // First element insertion
        if(front == -1) {
            front = 0;
        }

        rear ++;
        arr[rear] = data;
        System.out.println(data + " inserted");
    }

    // Remove element
    int dequeue() {

        // Queue Empty
        if(front == -1 || front > rear) {
            System.out.println("Queue Underflow!");
            return -1;
        }

        int removed = arr[front];
        front ++;
        return removed;
    }

    // Front element
    int peek() {
        if(front == -1 || front > rear) {
            System.out.println("Queue Empty");
            return -1;
        }

        return arr[front];
    }

    boolean isEmpty() {
        return front == -1 || front > rear;
    }

    // Display Queue
    void display() {
        if(isEmpty()) {
            System.out.println("Queue Empty!");
            return;
        }

        for(int i = front; i <=rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Removed : " + q.dequeue());
        q.display();

        System.out.println("Front : " + q.peek());
    }
}

