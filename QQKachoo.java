/*
  Team LineCutters - Joan Chirinos, Mohtasim Howlander, Kashf Mashrafi
  APCS2 pd08
  L02 -- All Hands on Deque
*/

public class QQKachoo<D> implements Deque<D>
{
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

  public static void main(String[] args) {
    QQKachoo<String> xd = new QQKachoo<String>();

    System.out.println("init QQKachoo xd");
    System.out.println("xd is empty: " + xd.isEmpty());

    System.out.println("\nadding some Strings to front of xd");
    xd.offerFirst("xd");
    xd.offerFirst("is");
    xd.offerFirst("name");
    xd.offerFirst("My");
    System.out.println(xd);
  }
}
