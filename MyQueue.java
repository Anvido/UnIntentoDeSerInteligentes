public class MyQueue<T> extends SearchList<T> {

    public MyQueue() {
      this.clear();
    }

    @Override
    public void clear(){
      this.head = new Node(null, null);
      this.tail = this.head;
      this.size = 0;
      this.maxSize = 0;
    }

    @Override
    public void add(T x) {
        Node<T> aux = new Node(x, null);
        this.tail.next = aux;
        this.tail = aux;
        this.size++;
        if(this.size > this.maxSize){
          this.maxSize++;
        }
    }
}
