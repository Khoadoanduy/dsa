public class doubly <E extends Comparable<E>>{
    private static class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E e, Node<E> n){
            data = e;
            next = n;
        }
        public E getData(){
            return data;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node <E> n){
            next = n;
        }

    }
}
