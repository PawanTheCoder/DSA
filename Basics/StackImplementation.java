package Basics;

public class StackImplementation {
    public static void main(String[] args) {
        StackArray stack = new StackArray(10);
        stack.push(100);
        System.out.println(stack.peek());
    }
}

class StackArray {
    private int[] arr;
    private int top;
    private int capacity;


    public StackArray(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if(top == capacity -1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    public int pop() {
        if(top == -1) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if(top == -1) return -1;
        return arr[top];
    }
}
