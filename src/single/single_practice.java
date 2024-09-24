public class single_practice <E extends Comparable<E>>{
    private static class Node<E>{
        private E data;
        private Node<E> next;
        public Node( E e, Node<E> n){
            data = e;
            next = n;
        }
        public E getData(){
            return data;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    private single_practice(){
        //empty
    }
    private boolean isEmpty(){
        return size == 0;
    }
    private int indexOf(E e){
        int index = 0;
        Node<E> current = head; 
        while(current != null){
            if(e.equals(current.data)){
                return index;
            }
            else {
                current = current.next;
                index++; 
            }
        }
        return -1;
    }
    private boolean contains(E e){
        return indexOf(e) != -1;
    }
    private Node<E> first(){
        return head;
    }
    private Node<E> last(){
        return tail;
    }
    private void addFirst(E e){
         
        Node<E> newNode = new Node<E>(e, head);
        head = newNode;
        if( size == 0){
            tail = head; 
        }
        size++;
    }
    private void addLast(E e){
        Node<E> newNode = new Node<E>(e, null); 
        if(isEmpty()){
            head = newNode; 
            tail = head;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    private E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E remove = head.getData();
        head = head.next; 
        if(head == null){
            tail = null;
        }
        return remove;
    }
    private E removeLast(){
        if(isEmpty()){
            return null;

        }
        E last = tail.getData();
        if(head == tail){
            head = null;
            return last;
        }
        size--;
        Node<E> current = head; 
        while(current.next != tail){
            current = current.next;
        }
        current.next = null;
        tail = current;


        return last;
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

    private void reverse(){
        Node<E> current = head.next;
        head = null;
        while(current != null){
            Node<E> temp = current.next;
            current.next = head;
            head = current;
            current = temp;
        }
    }
    private void insert(E e, int index){
        Node<E> current = head; 
        for(int i = 0; i < size; i++){
            
            if(i == index){
                Node<E> newNode = new Node<E>(e,null);
                newNode.next = current.next;
                current.next = newNode;
            }
            current = current.next;
        }
    }
    
    public static void main(String[] args){
        single_practice<Integer> list = new single_practice<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.reverse();
        System.out.println(list.toString());
        
        
    }
}
