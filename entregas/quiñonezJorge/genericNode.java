package entregas.quiñonezJorge;

public class GenericNode<T> {
  private T data;
  private GenericNode<T> next;

  public GenericNode(T data) {
    this.data = data;
    this.next = null;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public GenericNode<T> getNext() {
    return next;
  }

  public void setNext(GenericNode<T> next) {
    this.next = next;
  }
}
