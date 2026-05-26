package Stack;

public class Main {
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        stack.push(40);
        stack.push(50);
        
        stack.pop();
        stack.display();
    }

}
