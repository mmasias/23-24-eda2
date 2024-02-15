package entregas.quiñonezJorge;

public class genericNode<T> {
  private T data;
  private genericNode<T> next;

  public genericNode(T data) {
    this.data = data;
    this.next = null;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public genericNode<T> getNext() {
    return next;
  }

  public void setNext(genericNode<T> next) {
    this.next = next;
  }
}
