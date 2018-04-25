/*
  Team LineCutters - Joan Chirinos, Mohtasim Howlader, Kashf Mashrafi
  APCS2 pd08
  L02 -- All Hands on Deque
*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QQKachoo<D> implements Deque<D> {

  private int _size; //stores size of this
  private DLLNode<D> _front, _back; //pointers for either side of this

  //constructor: _front and _back point to null and size is 0
  public QQKachoo() {
    _size = 0;
    _front = _back = null;
  }

  //turns QQKachoo to String of format "FRONT: el1 | el2... | eln| : BACK"
  public String toString() {

    String ret = "FRONT: ";

    DLLNode<D> ptr = _front;
    for (int i = 0; i < this.size(); i++) {
      ret += ptr.toString() + " | ";
      ptr = ptr.getPrev();
    }

    return ret + ": BACK"; //returns String representation of this

  }

  //returns _size
  public int size() {
    return _size; //literally what it sounds like
  }

  //returns true if size == 0
  public boolean isEmpty() {
    return this.size() == 0; //literally what it sounds like
  }

  //adds newEl to front of QQKachoo
  public boolean offerFirst(D newEl) {

    if (this.isEmpty()) {
      _front = _back = new DLLNode<D>(newEl, null, null); //if first el being added, points to null
    }

    else {
      _front.setNext(new DLLNode<D>(newEl, _front, null)); //if not first el, points back to front and forward to null
      _front = _front.getNext();
    }

    _size++; //increments size

    return true;

  }

  //returns and removes first element
  public D pollFirst() {

    if (this.isEmpty()) return null; //literally what it sounds like

    //otherwise remove and store the element at the front
    D tmp = _front.getCargo();
    _front.getPrev().setNext(null);
    _front = _front.getPrev();

    _size--; //decrements size

    //return previously stored el
    return tmp;
  }

  //returns first el, sans removing
  public D peekFirst() {

    if (this.isEmpty()) return null; //literally what it sounds like

    return _front.getCargo(); //return the element at the front

  }

  //adds newEl to back of QQKachoo
  public boolean offerLast(D newEl) {

    if (this.isEmpty()) {
      _front = _back = new DLLNode<D>(newEl, null, null); //if first el being added, points to null
    }

    else {
      _back.setPrev(new DLLNode<D>(newEl, null, _back));//if not first el, points back to null and forward to back
      _back = _back.getPrev();
    }

    _size++; //increments size

    return true;

  }

  //returns and removes last el
  public D pollLast() {

    if (this.isEmpty()) return null; //literally what it sounds like

    //otherwise remove and store the element at the back
    D tmp = _back.getCargo();
    _back.getNext().setPrev(null);
    _back = _back.getNext();

    _size--; //decrements size

    //return previously stored el
    return tmp;

  }

  //returns last el, sans removing
  public D peekLast() {

    if (this.isEmpty()) return null; //literally what it sounds like it

    return _back.getCargo(); //return the element at the back

  }

  /***
  * We chose to implement these wrapper methods in case the user wants an
  * exception to be thrown rather than null being returned
  ***/

  //wrapper for offerFirst
  public void addFirst(D c) {
    this.offerFirst(c);
  }

  //wrapper for removeFirst but throws exception rather than null
  public D removeFirst() {
    D tmp = this.pollFirst();
    if (tmp == null) {
      throw new NoSuchElementException();
    }
    return tmp;
  }

  //wrapper for peekFirst but throws exception rather than null
  public D getFirst() {
    D tmp = this.peekFirst();
    if (tmp == null) {
      throw new NoSuchElementException();
    }
    return tmp;
  }

  //wrapper for offerLast
  public void addLast(D c) {
    this.offerLast(c);
  }

  //wrapper for pollLast but throws exception rather than null
  public D removeLast() {
    D tmp = this.pollLast();
    if (tmp == null) {
      throw new NoSuchElementException();
    }
    return tmp;
  }

  //wrapper for peekLast but throws exception rather than null
  public D getLast() {
    D tmp = this.peekLast();
    if (tmp == null) {
      throw new NoSuchElementException();
    }
    return tmp;
  }

  //returns a new Iterator as implemented in class DequeIter
  public Iterator<D> iterator() {
    return (Iterator<D>)(new DequeIter());
  }

  //uses iterator to verify if this contains d
  public boolean contains(D d) {
    for (D el : this) {
      if (el.equals(d)) return true;
    }
    return false;
  }

  //removes first occurrence of toRemove from this
  public boolean removeFirstOccurrence(D toRemove) {
    Iterator<D> it = iterator();
    while (it.hasNext()) {
      if (it.next().equals(toRemove)) {
        it.remove();
        return true;
      }
    }
    return false;
  }

  //returns a new Iterator as implemented in class ReverseDequeIter
  public Iterator<D> descendingIterator() {
    return (Iterator<D>)(new ReverseDequeIter());
  }

  //removes last occurrence of toRemove from this
  public boolean removeLastOccurrence(D toRemove) {
    Iterator<D> it = descendingIterator();
    while (it.hasNext()) {
      if (it.next().equals(toRemove)) {
        it.remove();
        return true;
      }
    }
    return false;
  }

  //implementation of Iterator iterating from _front to _back
  private class DequeIter implements Iterator<D> {

    private DLLNode<D> _dummy;
    private boolean _okToRemove;

    public DequeIter() {
      _dummy = new DLLNode<D>(null, _front, null);
      _okToRemove = false;
    }

    public boolean hasNext() {
      return _dummy.getPrev() != null;
    }

    public D next() {
      _dummy = _dummy.getPrev();
      if (_dummy == null) {
        throw new NoSuchElementException();
      }
      _okToRemove = true;
      return _dummy.getCargo();
    }

    public void remove() {
      if (!_okToRemove) {
        throw new IllegalStateException();
      }
      _okToRemove = false;
      if (_front == _back) {
        _front = _back = null;
      }
      else if (_front == _dummy) {
        _front = _front.getPrev();
        _front.setNext(null);
      }
      else if (_back == _dummy) {
        _back = _back.getNext();
        _back.setPrev(null);
      }
      else {
        _dummy.getPrev().setNext(_dummy.getNext());
        _dummy.getNext().setPrev(_dummy.getPrev());
      }
      _size--;
    }

  }//end class DequeIter

  //implementation of Iterator iterating from _back to _front
  private class ReverseDequeIter implements Iterator<D> {

    private DLLNode<D> _dummy;
    private boolean _okToRemove;

    public ReverseDequeIter() {
      _dummy = new DLLNode<D>(null, null, _back);
      _okToRemove = false;
    }

    public boolean hasNext() {
      return _dummy.getNext() != null;
    }

    public D next() {
      _dummy = _dummy.getNext();
      if (_dummy == null) {
        throw new NoSuchElementException();
      }
      _okToRemove = true;
      return _dummy.getCargo();
    }

    public void remove() {
      if (!_okToRemove) {
        throw new IllegalStateException();
      }
      _okToRemove = false;
      if (_front == _back) {
        _front = _back = null;
      }
      else if (_front == _dummy) {
        _front = _front.getPrev();
        _front.setNext(null);
      }
      else if (_back == _dummy) {
        _back = _back.getNext();
        _back.setPrev(null);
      }
      else {
        _dummy.getPrev().setNext(_dummy.getNext());
        _dummy.getNext().setPrev(_dummy.getPrev());
      }
      _size--;
    }

  }//end class DequeIter

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

    System.out.println("\nIterating:");
    for (String n : xd) {
      System.out.println("\t" + n);
    }

    System.out.println("\nxd contains \"!\": " + xd.contains("!"));
    System.out.println("xd contains \"name\" :" + xd.contains("name"));

    System.out.println("\nxd: " + xd);
    System.out.println("using iterator to remove all els from xd:");
    Iterator<String> it = xd.iterator();
    while (it.hasNext()) {
      System.out.println("\tremoving " + it.next());
      it.remove();
    }
    System.out.println("xd : " + xd);

    System.out.println("\nadding some els to xd");
    xd.offerLast("hello");
    xd.offerLast("bro");
    xd.offerLast("my");
    xd.offerLast("bro");
    xd.offerLast("is");
    xd.offerLast("named");
    xd.offerLast("bro");
    xd.offerLast("okay");
    System.out.println("xd: " + xd);

    System.out.println("\nremoving first occurrence of \"bro\":");
    xd.removeFirstOccurrence("bro");
    System.out.println("xd: " + xd);

    System.out.println("\nremoving last occurrence of \"bro\":");
    xd.removeLastOccurrence("bro");
    System.out.println("xd: " + xd);


  }
}
