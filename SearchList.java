public abstract class SearchList<T> {

    protected class Node<T>{

        protected T data;
        protected Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    protected Node<T> head = null, tail = null;

    public SearchList(){
        this.head = new Node(null, null);
    }

    public abstract void add(T x);

    public T remove(){
        if(this.head == this.tail){ return null; }
        if(this.head.next == null){
            this.tail = null;
            return null;
        }
        T aux = this.head.next.data;
        this.head = this.head.next;
        return aux;
    }
}
