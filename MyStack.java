public class MyStack<T> extends SearchList<T> {

    public MyStack() {
      this.clear();
    }

    @Override
    public void clear(){
      this.head = new Node(null, null);
      this.tail = null;
      this.size = 0;
      this.maxSize = 0;
    }

    @Override
    public void add(T x) {
        Node<T> aux = new Node(x, this.head.next);
        this.head.next = aux;
        this.size++;
        if(this.size > this.maxSize){
          this.maxSize++;
        }
    }
}
