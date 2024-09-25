package stack;

import java.util.*;

class stark{
    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.peek();
        test.add(10);

        test.remove(2);
        
        System.out.println(test);
    }
}