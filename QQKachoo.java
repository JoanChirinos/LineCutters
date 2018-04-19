/*
  Team LineCutters - Joan Chirinos, Mohtasim Howlander, Kashf Mashrafi
  APCS2 pd08
  L02 -- All Hands on Deque
*/

public class QQKachoo<D> implements Deque<D>
{
  private int _size;
  private LinkedList<D> _front;

  public QQKachoo() {
    _size = 0;
    _front = _back = null;
  }

  public int size() {
    return _size;
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public boolean offerFirst(D newEl) {

  }

  public static void main(String[] args) {
    QQKachoo xd = new QQKachoo();

    System.out.println("init QQKachoo xd");
    System.out.println("xd is empty: " + xd.isEmpty());
  }
}
