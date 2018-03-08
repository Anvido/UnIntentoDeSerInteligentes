public class MyStack<T> extends SearchList<T> {

    public MyStack() {
        super();
        this.tail = null;
    }

    @Override
    public void add(T x) {
        Node<T> aux = new Node(x, this.head.next);
        this.head.next = aux;
        this.expanddedNodes++;
        this.size++;
        if(this.size > this.maxSize){
          this.maxSize++;
        }
    }
}
