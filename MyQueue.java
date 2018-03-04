public class MyQueue<T> extends SearchList<T> {

    public MyQueue() {
        super();
        this.tail = this.head;
    }

    @Override
    public void add(T x) {
        Node<T> aux = new Node(x, null);
        this.tail.next = aux;
        this.tail = aux;
    }
}
