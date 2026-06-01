package StackDS;

public class StackArray {
    private int capacity;
    private int top;
    private int[] arr;

    StackArray(int size) {
        capacity = size;
        arr = new int[size];
        top = -1;
        capacity = size;
    }

    private boolean isEmpty() {
        if(top != -1) return false;
        return true;
    }

    public void push(int x) {
        if(top == capacity - 1) {
            System.out.println("Stack Overflow!");
            return;
        }else {
            arr[++top] =  x;
        }
    }

    public int pop() {
        if(top == -1) {
            System.out.println("Stack UnderFlow!");
            return -1;
        }
        return arr[top --];
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top];
    }

    public void display() {
        System.out.println("Stack : ");
        System.out.println("  ___   ");
        for(int i = top; i >=0 ; i--) {
            System.out.println( " | " + arr[i] + " | ");
        }
        System.out.print("  ___  ");
    }
}
