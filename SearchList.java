public abstract class SearchList<T> {

    //Node subclass exclusive for SearchList
    protected class Node<T>{

        //Properties
        protected T data;
        protected Node<T> next;

        //Methods
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    //Properties
    protected Node<T> head = null, tail = null;

    //Methods
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
