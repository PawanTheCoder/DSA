package QueueDS.Implementation;

public class Queue {
    int[] arr;
    int size;
    int front;
    int rear;

    Queue(int capacity) {
        arr = new int[capacity];
        front =0;
        rear = -1;
        size = 0;
        System.out.println("Hello Pawan I am called");
    }

    public void enqueue(int x) {
        if(size == arr.length) {
            System.out.println("Queue is Full ");
            return;
        }
        arr[++rear] = x;
        size++;
    }

    public int dequeue() {
        if(size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int val = arr[front];
        front++;
        size --;
        return val;
    }

    public int peek() {
        if(size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if(size == 0){
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("[ ");
        for(int i = front; i <= rear ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");

    }
}
