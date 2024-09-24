import java.util.Scanner;

public class single<E extends Comparable<E>> {
    private static class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E e,Node<E> n){
            data = e;
            next = n;
        }
        public E getData(){
            return data;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }

    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public single( ) { }
    public boolean isEmpty( ) {
        return size == 0;
    }
    public int indexOf(E e) {		// return the position of a value in the list
        if (isEmpty()) return -1;
        Node<E> p = head;
        for (int i = 0; i<size; i++) {
            if (e.equals(p.getData( )))
                return i;
            p = p.getNext();
        }
        return -1;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }
    public E first( ) { 			// returns (but does not remove) the first data
        if (isEmpty( ))
            return null;
        return head.getData();
    }
    public E last( ) { 				// returns (but does not remove) the last data
        if (isEmpty( ))
            return null;
        return tail.getData( );
    }

    // update methods
    public void addFirst(E e) { 	// adds data e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0)
            tail = head; 			// special case: new node becomes tail also
        size++;
    }

    public void addLast(E e) { 		// adds data e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty( ))
            head = newest; 			// special case: previously empty list
        else
            tail.setNext(newest); 	// new node after existing tail
        tail = newest; 				// new node becomes the tail
        size++;
    }
    public E removeFirst( ) { 		// removes and returns the first data
        if (isEmpty( )) return null; // nothing to remove
        E answer = head.getData( );
        head = head.getNext( ); 	// will become null if list had only one node
        size--;
        if (size == 0)
            tail = null; 			// special case as list is now empty
        return answer;
    }

    public E removeLast( ) { 		// removes and returns the last data
        if (isEmpty( )) return null; // nothing to remove
        E answer = tail.getData( );
        if (head == tail) {			// check for only one item on the list
            head = null;
            tail = null;
            size = 0;
            return answer;
        }
        Node<E> p = head;			// find the next to last item
        Node<E> prev;
        do {
            prev = p;
            p = p.getNext( );
        } while (p != tail);
        tail = prev;				// make the next to last item the last item
        prev.next = null;
        size--;
        return answer;
    }
    public single<E> intersect (single<E> comareList){
        single<E> newList = new single<>();
        newList.head = null;
        newList.tail = null;
        newList.size = 0;
        Node<E> p = head;
        while( p != null){
            if(comareList.contains(p.data)){
                newList.addLast(p.data);
            }
            p = p.next;
        }

        return newList;
    }
    @Override
    public String toString() {
        String result = "";
        Node<E> p = head;
        while (p != null) {
            result = result + "," + p.getData();
            p = p.getNext();
        }
        result = result.substring(1);
        return result;
    }
    public void reserve(){
        if(size < 2) return;
        Node<E> p = head.next;
        head.next = null;
        while(p!=null){
            Node<E> temp = p.next;
            p.next = head;
            head = p;
            p = temp;
        }

    }
    public static void main(String[] args) {
        single<Integer> list1 = new single<>();
        single<Integer> list2 = new single<>();

        // Adding elements 1, 2, 3, 4, 5 to list1
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(4);

        // Adding elements 2, 4, 5 to list2
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(5);
//        System.out.print(list1.intersect(list2).toString());
        list1.reserve();
        System.out.print(list1);


    }
}