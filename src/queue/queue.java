import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args){
        Queue<Integer> test = new LinkedList<>();
        test.add(1);
        test.add(2);
        int n = test.remove();
        System.out.println(n);
        System.out.println(test);
    }
    
}
