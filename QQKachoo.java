/*
  Team LineCutters - Joan Chirinos, Mohtasim Howlader, Kashf Mashrafi
  APCS2 pd08
  L02 -- All Hands on Deque
*/

public class QQKachoo<D> implements Deque<D> {

  private int _size;
  private DLLNode<D> _front, _back;

  public QQKachoo() {
    _size = 0;
    _front = _back = null;
  }

  public String toString() {
    String ret = "FRONT: ";
    DLLNode<D> ptr = _front;
    for (int i = 0; i < this.size(); i++) {
      ret += ptr.toString() + " | ";
      ptr = ptr.getPrev();
    }
    return ret + ": BACK";
  }

  public int size() {
    return _size;
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public boolean offerFirst(D newEl) {
    if (this.isEmpty()) {
      _front = _back = new DLLNode<D>(newEl, null, null);
    }
    else {
      _front.setNext(new DLLNode<D>(newEl, _front, null));
      _front = _front.getNext();
    }
    _size++;
    return true;
  }

  public D pollFirst() {
    if (this.isEmpty()) return null;
    D tmp = _front.getCargo();
    _front.getPrev().setNext(null);
    _front = _front.getPrev();
    _size--;
    return tmp;
  }

  public D peekFirst() {
    if (this.isEmpty()) return null;
    return _front.getCargo();
  }

  public boolean offerLast(D newEl) {
    if (this.isEmpty()) {
      _front = _back = new DLLNode<D>(newEl, null, null);
    }
    else {
      _back.setPrev(new DLLNode<D>(newEl, null, _back));
      _back = _back.getPrev();
    }
    _size++;
    return true;
  }

  public D pollLast() {
    if (this.isEmpty()) return null;
    D tmp = _back.getCargo();
    _back.getNext().setPrev(null);
    _back = _back.getNext();
    _size--;
    return tmp;
  }

  public D peekLast() {
    if (this.isEmpty()) return null;
    return _back.getCargo();
  }

  public void addFirst(D c) {
    this.offerFirst(c);
  }

  public Card removeFirst() {
    D tmp = this.pollFirst();
    if (tmp == null) {
      throw new NoSuchElementException();
    }
    return tmp;
  }

  public Card getFirst() {
    D tmp = this.peekFirst();
    if (tmp == null) {
      throw new NoSuchElementException();
    }
    return tmp;
  }

  public void addLast(D c) {
    this.offerLast(c);
  }

  public Card removeLast() {
    D tmp = this.pollLast();
    if (tmp == null) {
      throw new NoSuchElementException();
    }
    return tmp;
  }

  public Card getLast() {
    D tmp = this.peekLast();
    if (tmp == null) {
      throw new NoSuchElementException();
    }
    return tmp;
  }

  private class DequeIter<D> implements Iterator<D>  {

    private DLLNode<E> _dummy;
    private boolean _okToRemove;

    public DequeIter() {
      _dummy = new DLLNode<D>(null, _front, null);
      _okToRemove = false;
    }

    public boolean hasNext() {
      return _dummy.getPrev() != null;
    }

    public D next() {
      _dummy = _dummy.getPrev()
      if (!this.hasNext()) {
        throw new NoSuchElementException();
      }
      _okToRemove = true;
      return _dummy.getCargo();
    }

    public void remove() {
      
    }

  }

  public static void main(String[] args) {
    QQKachoo<String> xd = new QQKachoo<String>();

    System.out.println("init QQKachoo xd");
    System.out.println("xd is empty: " + xd.isEmpty());

    System.out.println("\nadding some Strings to front of xd");
    xd.offerFirst("xd");
    xd.offerFirst("is");
    xd.offerFirst("name");
    xd.offerFirst("My");
    System.out.println("xd: " + xd);

    System.out.println("\nFirst element: " + xd.peekFirst());
    System.out.println("Popping first element: " + xd.pollFirst());
    System.out.println("xd: " + xd);

    System.out.println("\nadding \"!\" to the back");
    xd.offerLast("!");
    System.out.println("xd: " + xd);

    System.out.println("\nLast element: " + xd.peekLast());
    System.out.println("Popping last element: " + xd.pollLast());
    System.out.println("xd: " + xd);
  }
}
